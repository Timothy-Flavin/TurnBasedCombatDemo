import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoseScreen extends JPanel{
  private MasterWindow frame;
  private JButton loseButton;
  private JLabel loseLabel;

  public LoseScreen(MasterWindow frame){
    this.frame = frame;
    setBackground(Color.green);
    LoseListener ll = new LoseListener();
    loseButton = new JButton("Quit");
    loseButton.addActionListener(ll);
    loseLabel = new JLabel("You Died");

    add(loseLabel);
    add(loseButton);
  }
  public class LoseListener implements ActionListener{
    public void actionPerformed(ActionEvent ev){
      frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
  }
}
