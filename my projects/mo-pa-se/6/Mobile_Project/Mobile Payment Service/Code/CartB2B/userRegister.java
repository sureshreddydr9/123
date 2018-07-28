import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import javax.microedition.lcdui.TextField;


public class userRegister implements CommandListener {

	Display dis;
	private TextField name=new TextField("User Name  ","",20,TextField.ANY);
	private TextField pass=new TextField("Password  ","",20,TextField.PASSWORD);
	private TextField cpass=new TextField("Confirm Password","",10,TextField.PASSWORD);
	private TextField address=new TextField("Address","",40,TextField.ANY);
	private TextField phone=new TextField("Phone           ","",10,TextField.PHONENUMBER);
	private TextField email=new TextField("Email-Id  ","",40,TextField.ANY);

	CartB2B parent;

	private Form reg;
	private Command regok=new Command("OK",Command.OK,1);
	private Command regback=new Command("Back",Command.BACK,1);
	
	public static String username="";
	public static String password="";
	public static String useaddress="";
	public static String userphone="";
	public static String usermailid="";
	
	//Constuctor


	public userRegister(CartB2B m,Display display)
	{
		this.parent=m;
		//options


		this.dis=display;
		reg=new Form("Registration");
		reg.append(name);
		reg.append(pass);
		reg.append(cpass);	
		reg.append(address);
		reg.append(phone);
		reg.append(email);
		System.out.println("regiater ----");
		
		reg.addCommand(regok);
		reg.addCommand(regback);
		dis.setCurrent(reg);
		reg.setCommandListener(this);
	}
	
	public void commandAction(Command command, Displayable d) {
		if(command == regok)
    	{
    		System.out.println("Register");
    		username=name.getString();
    		password=pass.getString();
    		useaddress=address.getString();
    		userphone=phone.getString();
    		System.out.println("-----------------"+userphone);
    		usermailid=email.getString();
    		Register register=new Register(this,dis);
    	}
		else if(command == regback)
		{
			parent.show();
		}
		
	}

	
	void showlogin()
	{
		parent.disp();
	}
}
