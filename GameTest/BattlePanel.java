import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BattlePanel extends JPanel{

  private MasterWindow frame;
  private Enemy enemy;
  private Player player;
  private String[] movePool;
  private DisplayPanel displayPanel;
  private int xpReward = 0;

  private JPanel attackPanel, generalPanel, itemPanel, menuePanel;
  private DisplayPanel dPanel;
  private CardLayout menueLayout;

  private MenuButton runButton, attackButton, itemButton;
  private MenuButton[] attackButtonArray;
  private MenuButton tempItemButton;
  private MenuButton aBackButton, iBackButton;
  private BattleButtonListeners bBL;
  private boolean won = true;

  public BattlePanel(MasterWindow frm){
    //super();
    frame = frm;
    setBackground(Color.cyan);
    this.setLayout(null);

    movePool = new String[4];
    movePool[0] = "nothing";
    movePool[1] = "nothing";
    movePool[2] = "nothing";
    movePool[3] = "nothing";

    displayPanel = new DisplayPanel();
    displayPanel.setBounds(0, 0, 300, 200);
    menuePanel = new JPanel();
    menuePanel.setBounds(0, 200, 300, 100);
    bBL = new BattleButtonListeners();
/////////////////////////////////////////////////////////////////////////////////////////
    itemPanel = new JPanel();
    itemPanel.setBackground(Color.red);
    tempItemButton = new MenuButton("Use Item", "tempItemButton");
    tempItemButton.addActionListener(bBL);
    iBackButton = new MenuButton("Back", "iBackButton");
    iBackButton.addActionListener(bBL);
    itemPanel.add(tempItemButton);
    itemPanel.add(iBackButton);
/////////////////////////////////////////////////////////////////////////////
    generalPanel = new JPanel();
    generalPanel.setBackground(Color.orange);
    runButton = new MenuButton("Run", "run");
    runButton.addActionListener(bBL);
    attackButton = new MenuButton("Attack", "attack");
    attackButton.addActionListener(bBL);
    itemButton = new MenuButton("Item", "item");
    itemButton.addActionListener(bBL);
    generalPanel.add(runButton);
    generalPanel.add(attackButton);
    generalPanel.add(itemButton);
//////////////////////////////////////////////////////////////////////////////////
    attackPanel = new JPanel();
    attackPanel.setBackground(Color.blue);
    aBackButton = new MenuButton("Back", "aBackButton");
    aBackButton.addActionListener(bBL);
    attackButtonArray = new MenuButton[4];
    System.out.println("starting for loop");
    for(int i = 0; i < 4; i++){
      attackButtonArray[i] = new MenuButton("---", "nothing");
      attackButtonArray[i].addActionListener(bBL);
      System.out.println("hi there");
      System.out.println("button " + i + " id = " + attackButtonArray[i].getId());
      attackPanel.add(attackButtonArray[i]);
    }
    attackPanel.add(aBackButton);
    menueLayout = new CardLayout();

    menuePanel.setLayout(menueLayout);
    menuePanel.add(itemPanel, "itemPanel");
    menuePanel.add(attackPanel, "attackPanel");
    menuePanel.add(generalPanel, "generalPanel");
    menueLayout.show(menuePanel, "generalPanel");

    add(displayPanel);
    add(menuePanel);
  }
  public void setEnemy(Enemy en){
    enemy = en;
    displayPanel.setEnemy(enemy);
  }
  public void setPlayer(Player pl){
    player = pl;
    System.out.println(player.getName());
    displayPanel.setPlayer(player);
    movePool = player.getMoveSet();
    for(int i = 0; i < 4; i++){
      attackButtonArray[i].setText(movePool[i]);
      attackButtonArray[i].setId(movePool[i]);
    }
  }
  public void endBattle(){
    if(won){
      int h = player.getMaxHealth();
      player.addXp(xpReward);
      int h2 = player.getMaxHealth();
      boolean leveledUp = false;
      if(h != h2){
        leveledUp = true;
      }
      int xp = player.getXp();
      int xpn = player.getXpNeeded();
      frame.win(leveledUp, xpReward, xpn-xp, player.getLevel());
      //frame.toOverworld();
    }
    else{
      System.out.println("You lose...");
      frame.lose();
    }

  }
  public void takeTurn(){
    if(enemy.getSpeed() > player.getSpeed()){
      if(enemy.getDamageDone() < 0){
        enemy.hurt(enemy.getDamageDone());
      }
      else{
        player.hurt(enemy.getDamageDone());
      }
      if(player.getDamageDone() < 0 && player.getHealth() > 0){
        player.hurt(player.getDamageDone());
      }
      else if(player.getHealth() > 0){
        enemy.hurt(player.getDamageDone());
      }
      System.out.println(enemy.getAttackChosen());
      System.out.println(player.getAttackChosen());
    }
    else{
      if(player.getDamageDone() < 0){
        player.hurt(player.getDamageDone());
      }
      else{
        enemy.hurt(player.getDamageDone());
      }
      if(enemy.getDamageDone() < 0 && enemy.getHealth() > 0){
        enemy.hurt(enemy.getDamageDone());
      }
      else if(enemy.getHealth() > 0){
        player.hurt(enemy.getDamageDone());
      }
      System.out.println(player.getAttackChosen());
      System.out.println(enemy.getAttackChosen());
    }
    menueLayout.show(menuePanel, "generalPanel");
  }
  public class BattleButtonListeners implements ActionListener{
    public void actionPerformed(ActionEvent event){
      MenuButton b = (MenuButton)event.getSource();
      if(b.getId() == "iBackButton"){
        menueLayout.show(menuePanel, "generalPanel");
      }
      else if(b.getId() == "run"){
        frame.toOverworld();
      }
      else if(b.getId() == "attack"){
        menueLayout.show(menuePanel, "attackPanel");
      }
      else if(b.getId() == "item"){
        menueLayout.show(menuePanel, "itemPanel");
      }
      else if(b.getId() == "aBackButton"){
        menueLayout.show(menuePanel, "generalPanel");
      }
      else if(b.getId() == movePool[0]){
        enemy.autoChooseAttack();
        player.setAttackChosen(movePool[0]);
        takeTurn();
      }
      else if(b.getId() == movePool[1]){
        enemy.autoChooseAttack();
        player.setAttackChosen(movePool[1]);
        takeTurn();
      }
      else if(b.getId() == movePool[2]){
        enemy.autoChooseAttack();
        player.setAttackChosen(movePool[2]);
        takeTurn();
      }
      else if(b.getId() == movePool[3]){
        enemy.autoChooseAttack();
        player.setAttackChosen(movePool[3]);
        takeTurn();
      }
      if(player.getHealth() > player.getMaxHealth()){
        player.setHealth(player.getMaxHealth());
      }
      if(enemy.getHealth() > enemy.getMaxHealth()){
        enemy.setHealth(enemy.getMaxHealth());
      }
      if(player.getHealth() <= 0){
        player.setHealth(0);
        won = false;
        xpReward = 0;
        endBattle();
      }
      if(enemy.getHealth() <= 0){
        enemy.setHealth(0);
        xpReward = enemy.getXpReward();
        won = true;
        endBattle();
      }
      System.out.println(enemy.getHealth());
      displayPanel.updateStats();
    }
  }
}
