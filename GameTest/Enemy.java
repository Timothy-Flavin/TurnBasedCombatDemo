import javax.swing.*;
import java.util.*;

public class Enemy extends Entity{

  private String name;
  private String[] moveList;
  private boolean moveNotAssigned = true;
  private Random rand = new Random();
  private int bs, ba, bh, ss, sa, sh, xpReward, level;

  public Enemy(String nm, int lvl){
    name = nm;
    level = lvl;
    moveList = new String[4];
    if(name.equals("batSquirrel")){

      moveList[0] = "bite";
      moveList[1] = "rest";
      moveList[2] = "nothing";
      moveList[3] = "nothing";
      addAttack(level);
      bs = 10;
      ba = 4;
      bh = 10;
      ss = 2;
      sa = 3;
      sh = 1;
      xpReward = 5 * level;
      setParams(name, level, bs, ba, bh, ss, sa, sh, moveList);
    }
    else{
      System.out.println("you entered a wrong enemy name");
    }
  }
  //this is really the make wild attack list, add attack will have to be if enemy level = number
  //from biggest to smallest
  public int getXpReward(){
    return xpReward;
  }
  private void addAttack(int level){
    if(name.equals("batSquirrel")){
      if(level > 4){
        //loop to assign move at level 4
        for(int i = 0; i<4 && moveNotAssigned; i++){
          if(moveList[i].equals("nothing")){
              moveList[i] = "slash";
              moveNotAssigned = false;
              System.out.println("batSquirrel learned a new move, slash");
          }
          else if(i == 3){
            moveList[rand.nextInt(4)] = "slash";
            moveNotAssigned = true;
          }
        }
      }
    }
    else{
      System.out.println("bruh its not a squirrel, (add attack section)");
    }
  }

  /*enemySprite = enemy.getSprite();
  enemyHealth = enemy.getHealth();
  enemyMaxHealth = enemy.getMaxHealth();
  enemyAttack = enemy.getAttack();
  enemySpeed = enemy.getSpeed();
  enemyName = enemy.getName();*/
}
