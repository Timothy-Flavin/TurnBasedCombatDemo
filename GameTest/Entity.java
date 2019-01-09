import java.util.*;
import javax.swing.*;

public class Entity{

  private AttackList aList;
  private String name, spriteName, attackChosen;
  private String[] moveSet;
  private ImageIcon spriteImage;
  private int level, scaleSpeed, scaleAttack, scaleHealth, baseHealth, baseSpeed, baseAttack;
  private int health, maxHealth, attack, speed;
  private Random rand = new Random();

  public void Entity(){
  }
  public void setParams(String nm, int lvl, int bs, int ba, int bh, int ss, int sa, int sh, String[] moves){
    aList = new AttackList();
    level = lvl;
    moveSet = moves;

    scaleSpeed = ss;
    scaleAttack = sa;
    scaleHealth = sh;

    baseSpeed = bs;
    baseAttack = ba;
    baseHealth = bh;

    name = nm;
    spriteName = name + "Sprite.png";
    spriteImage = new ImageIcon(spriteName);

    maxHealth = baseHealth + scaleHealth * level;
    health = maxHealth;
    speed = baseSpeed + scaleSpeed * level;
    attack = baseAttack + scaleAttack * level;
  }
  public void levelUp(){
    maxHealth += scaleHealth;
    health += scaleHealth;
    speed += scaleSpeed;
    attack += scaleAttack;
    level++;
  }
  public ImageIcon getSprite(){
    return spriteImage;
  }
  public int getHealth(){
    return health;
  }
  public int getMaxHealth(){
    return maxHealth;
  }
  public int getAttack(){
    return attack;
  }
  public int getSpeed(){
    return speed;
  }
  public String getName(){
    return name;
  }
  public void hurt(int damage){
    health -= damage;
  }
  public String[] getMoveSet(){
    return moveSet;
  }
  public int getLevel(){
    return level;
  }
  public void autoChooseAttack(){
  	do{
  		int r = rand.nextInt(4);
  		attackChosen = moveSet[r];
  	}while((attackChosen.equals("nothing")));
  }
  public String getAttackChosen(){
    return attackChosen;
  }
  public void setAttackChosen(String ac){
    attackChosen = ac;
  }
  public void setHealth(int h){
    health = h;
  }
  public int getDamageDone(){
  	int damageDealt = aList.returnDamage(attackChosen, attack);
    return damageDealt;
  }
}
