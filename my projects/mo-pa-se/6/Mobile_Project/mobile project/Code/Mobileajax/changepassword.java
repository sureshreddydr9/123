import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;


public class changepassword implements CommandListener{
	MobileAjax parent;
	Display dis;
	public static String name="";
	public static String pass="";
	public static String newpass="";
	Image img=loadImage("/pass.png");
	
	private Form changepass=new Form("Change Password");
	private TextField username=new TextField("User Name       :","",9,TextField.ANY);
	private TextField password=new TextField("Password        :","",10,TextField.PASSWORD);
	private TextField newpassword=new TextField("New Password       : ","",20,TextField.PASSWORD);
	private Command change,back;
	
	
	public changepassword(MobileAjax ajax, Display display) {
		
		this.dis=display;
		this.parent=ajax;
		change=new Command("Change",Command.OK,1);
		back=new Command("back",Command.BACK,2);
		
		changepass.append(username);
		changepass.append(password);
		changepass.append(newpassword);
		changepass.append(new ImageItem("",img,ImageItem.LAYOUT_CENTER,"thank you"));
		changepass.addCommand(change);
		changepass.addCommand(back);
		dis.setCurrent(changepass);
		changepass.setCommandListener(this);
	}
	
	private Image loadImage(String name)
  	{
  	    Image image = null;
  	    try
  	    {
  		      image = Image.createImage(name);
  	    }
  	    catch (IOException ioe)
  	    {
  		      System.out.println(ioe);
  	    }

  	    return image;
	}


	

	public void commandAction(Command c, Displayable arg1) {
	if(c==change)
	{
		System.out.println("---------------------------");
		name=username.getString();
		pass=password.getString();
		newpass=newpassword.getString();
		System.out.print("zxycgzxh"+name);
		change pwd=new change(this,dis);
	}
	else if(c==back)
	{
		parent.show();
	}
		
	}

	void display()
	{
		dis.setCurrent(changepass);
	}
}
