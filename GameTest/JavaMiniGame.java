
//package javaminigame;
import javax.swing.*;
import java.awt.*;

public class JavaMiniGame extends JFrame{
   
    public JavaMiniGame(){ 
        setSize(500, 500);
        setTitle("the game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); 
        setBackground(Color.cyan);
        GamePanel1 pn = new GamePanel1();
        Thread t1 = new Thread(pn);
        t1.start();
        add(pn);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JavaMiniGame();
    }
    
}
