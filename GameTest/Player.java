import java.awt.*;
import java.io.*;
import java.util.*;

public class Player extends Entity{

  private Scanner fileReader;
  private String playerFile;
  private int ss, sa, sh, bs, ba, bh, xp, xpn;
	String moves[];

  public Player(String nm, int lvl){
		moves = new String[4];
  	playerFile = nm + ".txt";
  	try{
			fileReader = new Scanner(new File(playerFile));
  		ss = fileReader.nextInt();
  		sa = fileReader.nextInt();
  		sh = fileReader.nextInt();
  		bs = fileReader.nextInt();
  		ba = fileReader.nextInt();
  		bh = fileReader.nextInt();
  		xp = fileReader.nextInt();
  		xpn = fileReader.nextInt();
			moves[0] = fileReader.nextLine();
			moves[1] = fileReader.nextLine();
			moves[2] = fileReader.nextLine();
			moves[3] = fileReader.nextLine();
  		setParams(nm, lvl, bs, ba, bh, ss, sa, sh, moves);
  	}
  	catch(Exception e){
  		System.out.println("cannot load file for player");
  	}
  }
	public int getXp(){
		return xp;
	}
	public int getXpNeeded(){
		return xpn;
	}
	public void addXp(int xpAdded){
		xp+=xpAdded;
		if(xp >= xpn){
			levelUp();
			System.out.println("You leveld up");
			xp = xp - xpn;
			xpn += 5;
		}
	}

}
