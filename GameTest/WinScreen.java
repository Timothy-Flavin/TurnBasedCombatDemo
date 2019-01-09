import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinScreen extends JPanel{
  private JButton win;
  public boolean lu, set = false;
  private String leveledUp, xpReward, xpLeft;
  private MasterWindow frame;
  public WinScreen(MasterWindow frame){
    this.frame = frame;
    WinListener wl = new WinListener();
    win = new JButton("Ok");
    win.addActionListener(wl);
    add(win);
  }
  public void setWinScreen(boolean lu, int xpr, int xpn, int level){
    setBackground(Color.green);
    this.lu = lu;
    leveledUp = "You Gained a Level, you are now level: " + level;
    xpReward = "You got " + xpr + " Expiriance points.";
    if(lu){
      xpLeft = "You need " + xpn + " XP to level up again to " + (level+1);
    }
    else{
      xpLeft = "You need " + xpn + " XP to level up to " + (level+1);
    }
    set = true;
  }
  public class WinListener implements ActionListener{
    public void actionPerformed(ActionEvent ev){
      frame.toOverworld();
    }
  }
  public void paintComponent(Graphics g){
    g.setColor(Color.blue);
    g.fillRect(0, 0, getWidth(), getHeight());
    if(set){
      g.setColor(Color.white);
      if(lu){
        g.drawString(leveledUp, 40, 100);
      }
      g.drawString(xpLeft, 40, 120);
      g.drawString(xpReward, 40, 80);
    }
  }
}
