import javax.swing.*;
import java.awt.*;
public class MenuButton extends JButton{
	String id;
	public MenuButton(String label, String id){
		super(label);
		this.id = id;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
}
