import java.awt.*;
public class GameDriver{
  public static void main(String[] args){
    MasterWindow theWindow = new MasterWindow(500, 510);
    theWindow.setResizable(false);
    System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
  }
}
