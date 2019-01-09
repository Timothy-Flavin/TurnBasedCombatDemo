import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class OverWorldPanel extends JPanel implements ActionListener{

  private MasterWindow eventCaller;
  private Random random;
  private MapLoader invisMap = new MapLoader();
  private AL pls;
  private int panelWidth, panelHeight, protagonistX, protagonistY, mapX, mapY;
  private String mapName, characterName;
  private ImageIcon currentMap, currentCharacter;
  private char direction;
  private char prevDirection;
  private boolean moving, encountered;
  private Timer moveAnimator;
  private int timerLoops = 0;
  private boolean feet = false;
  private String playerName;
  private char feetChar = 'f';
  private Player player;
  private Enemy enemy;
  private boolean playerExists = false;

  public class AL implements KeyListener{

          public void keyPressed(KeyEvent e){

              if(! moving){
                int keyCode = e.getKeyCode();
                if(keyCode == e.VK_UP){
                  prevDirection = direction;
                  direction = 'n';
                }
                if(keyCode == e.VK_LEFT){
                  prevDirection = direction;
                  direction = 'w';

                }
                if(keyCode == e.VK_DOWN){
                  prevDirection = direction;
                  direction = 's';

                }
                if(keyCode == e.VK_RIGHT){
                  prevDirection = direction;
                  direction = 'e';

                }
                moving = true;
                moveAnimator.start();
              }
          }

          public void keyReleased(KeyEvent e){
              int keyCode = e.getKeyCode();
              if(keyCode == e.VK_UP){

              }
              if(keyCode == e.VK_LEFT){

              }
              if(keyCode == e.VK_DOWN){

              }
              if(keyCode == e.VK_RIGHT){

              }
          }
          public void keyTyped(KeyEvent e){};
      }


    public void actionPerformed(ActionEvent ae){
      timerLoops++;
      feet = !feet;
      if(feet){
        playerName = characterName + direction + feetChar + ".png";
        setPlayerImage(playerName);
      }
      else{
        playerName = characterName + direction + ".png";
        setPlayerImage(playerName);
      }
      System.out.println(playerName);
      move();
      if(timerLoops == 5){
        moveAnimator.stop();
        timerLoops = 0;
        feet = false;
        playerName = characterName + direction + ".png";
        setPlayerImage(playerName);
        moving = false;
        if(!(invisMap.testEncounterTile(mapName, protagonistX, protagonistY))){
          encountered = false;
        }
        if(encountered){
          encountered = false;
          int l = random.nextInt(5) + 1;
          enemy = new Enemy("batSquirrel", l);
          eventCaller.Battle(enemy);
        }
      }
      repaint();
    }

//sets focusable to true and sets variables

  public OverWorldPanel(String mn, String cn, MasterWindow frame){
    //super();
    eventCaller = frame;

    random = new Random();
    moveAnimator = new Timer(100, this);
    moveAnimator.setRepeats(true);
    moving = false;

    direction = 'n';
    prevDirection = 'n';
    mapName = mn;
    currentMap = new ImageIcon(mapName);
    characterName = cn;
    playerName = characterName + direction + ".png";
    currentCharacter = new ImageIcon(playerName);

    this.setFocusable(true);
    requestFocusInWindow();
    addKeyListener(new AL());
//sets up the map in the panel using the map loader methods. come back later to make the
//start based on the panel size for a resizable screen
    mapX = invisMap.getMapStartX(mapName);
    mapY = invisMap.getMapStartY(mapName);
    protagonistX = -mapX + 150;
    protagonistY = -mapY + 150;
    System.out.println("protagonist x and y" + protagonistX + " " + protagonistY);
    this.setFocusable(true);
    requestFocusInWindow();
    //System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
    // not sure what to do for this yet protagonist = new Player(panelWidth/2, panelHeight/2);
  }

  public void move(){
    if(direction == 'n'){
      if(invisMap.hitsAWall(mapName, protagonistX, protagonistY - 20)){
        System.out.println("can't move");
      }
      else{
        if(invisMap.testEncounter(mapName, protagonistX, protagonistY - 20)){
          encountered = true;
        }
        mapY += 20;
        protagonistY -= 20;
      }
      //System.out.println("protagonist x and y" + protagonistX + " " + protagonistY);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    else if(direction == 's'){

      if(invisMap.hitsAWall(mapName, protagonistX, protagonistY + 20)){
        System.out.println("can't move");
      }
      else{
        if(invisMap.testEncounter(mapName, protagonistX, protagonistY + 20)){
          encountered = true;
        }
        mapY -= 20;
        protagonistY += 20;
      }
      //System.out.println("protagonist x and y" + protagonistX + " " + protagonistY);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    else if(direction == 'w'){

      if(invisMap.hitsAWall(mapName, protagonistX - 20, protagonistY)){
        System.out.println("can't move");
      }
      else{
        if(invisMap.testEncounter(mapName, protagonistX - 20, protagonistY)){
          encountered = true;
        }
        mapX += 20;
        protagonistX -= 20;
      }
      //System.out.println("protagonist x and y" + protagonistX + " " + protagonistY);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    else if(direction == 'e'){

      if(invisMap.hitsAWall(mapName, protagonistX + 20, protagonistY)){
        System.out.println("can't move");
      }
      else{
        if(invisMap.testEncounter(mapName, protagonistX + 20, protagonistY)){
          encountered = true;
        }
        mapX -= 20;
        protagonistX += 20;
      }
      //System.out.println("protagonist x and y" + protagonistX + " " + protagonistY);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    else if(direction == 'o'){
      //put a way to switch the character back to stationary sprite
    }

  }
//function called to change map image

  public void setMap(String mn){
    mapName = mn;
    currentMap = new ImageIcon(mapName);
  }
  public void setPlayerImage(String pn){
    currentCharacter = new ImageIcon(pn);
  }
  public void setPlayer(Player pla){
    player = pla;
    playerExists = true;
  }

  public void paintComponent(Graphics g){
        //System.out.println("painting stuff..");
        g.setColor(Color.lightGray);
        currentMap.paintIcon(this, g, mapX, mapY);
        currentCharacter.paintIcon(this, g, 100, 100);
        if(playerExists){
          g.drawString("Player Health: " + player.getHealth() + " / " + player.getMaxHealth(), 0, 20);
        }
  }

// Control listener


}
