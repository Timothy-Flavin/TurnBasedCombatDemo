
//package javaminigame;

import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class GamePanel1 extends JPanel implements Runnable{
    Image face;
    Image monster;
    int x = 250, y = 250;
    int mx = 0, my = 0;
    private int panelx = 500, panely = 500, xDirection, yDirection;
    private final int CHARACTERWIDTH = 50, CHARACTERHEIGHT = 50;
    private Image dbImage;
    private Graphics dbg;
    private int[] direction = new int[4];
    
    public void run(){
        try{
            while(true){
                move();
                moveMonster();
                Thread.sleep(20);
            }
        }
        catch(Exception e){
            System.out.println("why you do dis?");
        }
    }
    public void moveMonster(){
    	int mcy = my + 81, mcx = mx + 120;
    	int ydis = mcy - y, xdis = mcx - x;
    	double totaldis = Math.pow((double)ydis*ydis + (double)xdis*xdis, 0.5);
    	
    	if(totaldis > 0){
    		my -= Math.round(ydis/totaldis * 5);
    		mx -= Math.round(xdis/totaldis * 5);
    		if(totaldis < 5){
    			mx = x - 120;
    			my = y - 81;
    		}
    	}
    }
    public void move(){
        x += 10*(direction[1] - direction[3]);
        y += 10*(direction[2] - direction[0]);
        if(x <= 0){
            x = 0;
        }
        if(x >=panelx-CHARACTERWIDTH){
            x = panelx-CHARACTERWIDTH;
        }
        if(y <= 0){
            y = 0;
        }
        if(y >=panely-CHARACTERHEIGHT){
            y = panely-CHARACTERHEIGHT;
        }
    }
    public void setXDirection(int xDir){
        xDirection = xDir;
    }
    public void setYDirection(int yDir){
        yDirection = yDir;
    }
    public class AL extends KeyAdapter {
       
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_UP){
                direction[0] = 1;
            }
            if(keyCode == e.VK_RIGHT){
                direction[1] = 1;
            }
            if(keyCode == e.VK_DOWN){
                direction[2] = 1;
            }
            if(keyCode == e.VK_LEFT){
                direction[3] = 1;
            }
        }
        
        public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_UP){
                direction[0] = 0;
            }
            if(keyCode == e.VK_RIGHT){
                direction[1] = 0;
            }
            if(keyCode == e.VK_DOWN){
                direction[2] = 0;
            }
            if(keyCode == e.VK_LEFT){
                direction[3] = 0;
            }
        }
    }
    public GamePanel1(){
        ImageIcon i = new ImageIcon("face.png");
        ImageIcon m = new ImageIcon("Giaprey_No_Background.png");
        face = i.getImage();
        monster = m.getImage();
        this.setFocusable(true);
        addKeyListener(new AL());
        x = 250;
        y = 250;
    }
    public void paint(Graphics g){
        //System.out.println("x, " + x + ", y, " + y);
        panelx = getWidth();
        panely = getHeight();
        dbImage = createImage(panelx, panely);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent(Graphics g){
        //g.fillOval(x, y, CHARACTERWIDTH, CHARACTERHEIGHT);
        g.drawImage(monster, mx, my, this);
        g.drawImage(face, x, y, this);
        repaint();
    }
}
