import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel{

	private ImageIcon enemySprite, playerSprite, battleBackground;
	private String enemyString = " ", playerString = " ";
	private Enemy enemy;
	private Player player;
	private boolean enemyAlive = false, playerAlive = false;

	public DisplayPanel(){
		battleBackground = new ImageIcon("battleBackground.png");
	}
	public void setPlayer(Player pl){
		player = pl;
		playerString = player.getName() +  "  " + player.getHealth() + " / " + player.getMaxHealth() + "Health";
		playerSprite = player.getSprite();
		playerAlive = true;
	}
	public void setEnemy(Enemy en){
		enemy = en;
		enemyString = enemy.getName() +  "  " + String.valueOf(enemy.getHealth()) + " / " + String.valueOf(enemy.getMaxHealth()) + "Health";
		enemySprite = enemy.getSprite();
		enemyAlive = true;
	}
	public void updateStats(){
		enemyString = enemy.getName() + "  " + String.valueOf(enemy.getHealth()) + " / " + String.valueOf(enemy.getMaxHealth()) + "Health";
		enemySprite = enemy.getSprite();
		playerString = player.getName() + "  " + String.valueOf(player.getHealth()) + " / " + String.valueOf(player.getMaxHealth()) + "Health";
		playerSprite = player.getSprite();
		repaint();
	}
	public void paintComponent(Graphics g){
		setBackground(Color.blue);
		battleBackground.paintIcon(this, g, 0, 0);
		if(playerAlive){
			g.setColor(Color.black);
			g.drawRect(99, 169, 101, 11);
			g.setColor(Color.red);
			g.fillRect(100, 170, 100, 10);
			g.setColor(Color.green);
			g.fillRect(100, 170, 100*player.getHealth()/player.getMaxHealth(), 10);
			g.setColor(Color.lightGray);
			g.drawString(playerString, 100, 160);
			playerSprite.paintIcon(this, g, 100, 200);
		}
		if(enemyAlive){
			g.setColor(Color.black);
			g.drawRect(354, 19, 101, 11);
			g.setColor(Color.red);
			g.fillRect(355, 20, 100, 10);
			g.setColor(Color.green);
			g.fillRect(355, 20, 100*enemy.getHealth()/enemy.getMaxHealth(), 10);
			g.setColor(Color.lightGray);
			g.drawString(enemyString, 355, 16);
			enemySprite.paintIcon(this, g, 350, 60);
		}
	}
}
