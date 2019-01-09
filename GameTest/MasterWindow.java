import javax.swing.*;
import java.awt.*;

public class MasterWindow extends JFrame{
  private JFrame frame;
  private JPanel mainPanel;
  private CardLayout panelHolder;
  private OverWorldPanel pn;
  private BattlePanel battlePanel;
  private Player player;
  private LoseScreen loss;
  private WinScreen winScreen;
  public MasterWindow(){

  }
  public MasterWindow(int x, int y){
    //adding panels needed
    player = new Player("player", 2);
    battlePanel = new BattlePanel(this);
    pn = new OverWorldPanel("starterMap.png", "player", this);
    loss = new LoseScreen(this);
    winScreen = new WinScreen(this);
    pn.setPlayer(player);
    mainPanel = new JPanel();
    panelHolder = new CardLayout();
    //adding panels to layout
    mainPanel.setLayout(panelHolder);
    mainPanel.add(pn, "overWorld");
    mainPanel.add(battlePanel, "battlePanel");
    mainPanel.add(loss, "LoseScreen");
    mainPanel.add(winScreen, "WinScreen");
    //picking which panel to show first
    panelHolder.show(mainPanel, "overWorld");
    //setting up frame
    setSize(x, y);
    setTitle("Final Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(true);
    setBackground(Color.cyan);
    this.add(mainPanel);
    setVisible(true);
  }
  public void lose(){
    panelHolder.show(mainPanel, "LoseScreen");
  }
  public void win(boolean lu, int xpr, int xpn, int level){
    winScreen.setWinScreen(lu, xpr, xpn, level);
    panelHolder.show(mainPanel, "WinScreen");
  }
  public void toOverworld(){
    panelHolder.show(mainPanel, "overWorld");
    pn.setFocusable(true);
    pn.requestFocusInWindow();
  }
  public void Battle(Enemy enemy){
    battlePanel.setEnemy(enemy);
    battlePanel.setPlayer(player);
    panelHolder.show(mainPanel, "battlePanel");
  }
}
