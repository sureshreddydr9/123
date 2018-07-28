import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import javax.microedition.lcdui.TextField;


public class userRegister implements CommandListener {

	Display dis;
	
	private TextField uname=new TextField("User Name:","",20,TextField.ANY);
	private TextField pass=new TextField("Password:","",20,TextField.PASSWORD);
	private TextField cpass=new TextField("Confirm Password:","",20,TextField.PASSWORD);
	private TextField name=new TextField("Name:","",25,TextField.ANY);
	private TextField fname=new TextField("Fathers Name:","",20,TextField.ANY);
	private TextField age=new TextField("Age:   ","",20,TextField.NUMERIC);
	private TextField dob=new TextField("Date Of Birth:","",20,TextField.ANY);
	private TextField sex=new TextField("Sex:    ","",20,TextField.ANY);
	private TextField education=new TextField("Education:","",20,TextField.ANY);
	private TextField occupation=new TextField("Occupation:","",20,TextField.ANY);
	private TextField aincome=new TextField("Anual Income:","",20,TextField.NUMERIC);
	private TextField address=new TextField("Address:","",20,TextField.ANY);
	private TextField city=new TextField("City:     ","",20,TextField.ANY);
	private TextField phone=new TextField("Phone:","",20,TextField.PHONENUMBER);
	private TextField email=new TextField("Email-Id:","",20,TextField.ANY);
	private TextField intdeposit=new TextField("Initial Deposit:","",20,TextField.NUMERIC);
	private TextField ccno=new TextField("Credit Card Number:            ","",6,TextField.PASSWORD);

	MobileAjax parent;

	private Form reg;
	private Command regok=new Command("OK",Command.OK,1);
	private Command regback=new Command("Back",Command.BACK,1);
	
	public static String useruname="";
	public static String username="";
	public static String password="";
	public static String userfname="";
	public static String userage="";
	public static String userdob="";
	public static String usersex="";
	public static String usereducation="";
	public static String useroccupation="";
	public static String useraincome="";
	public static String useraddress="";
	public static String usercity="";
	public static String userphone="";
	public static String useremail="";
	public static String userintdeposit="";
	public static String cclength="";
	


	//Constuctor


	public userRegister(MobileAjax m,Display display)
	{
		this.parent=m;
		//options


		this.dis=display;
		reg=new Form("Registration");
		reg.append(uname);
		reg.append(pass);
		reg.append(cpass);
		reg.append(name);
		reg.append(fname);
		reg.append(age);
		reg.append(dob);
		reg.append(sex);
		reg.append(education);
		reg.append(occupation);
		reg.append(aincome);
		reg.append(address);
		reg.append(city);
		reg.append(phone);
		reg.append(email);
		reg.append(intdeposit);
		reg.append(ccno);
		System.out.println("regiater ----");

		reg.addCommand(regok);
		reg.addCommand(regback);
		dis.setCurrent(reg);
		reg.setCommandListener(this);
	}
	
	public void commandAction(Command command, Displayable d) {
		if(command == regok)
    	{
			
			cclength= ccno.getString();
			
			if(cclength.length()!=6 )
					{
						tryAgain();
						System.out.print("you must type 6 nnumbers");
					}
			else
			{
    		System.out.println("Register");
    		useruname=uname.getString();
    		password=pass.getString();
    		username=name.getString();
    		userfname=fname.getString();
    		userage=age.getString();
    		userdob=dob.getString();
    		usersex=sex.getString();
    		usereducation=education.getString();
    		useroccupation=occupation.getString();
    		useraincome=aincome.getString();
    		useraddress=address.getString();
    		usercity=city.getString();
    		userphone=phone.getString();
    		System.out.println("-----------------"+userphone);
    		useremail=email.getString();
    		userintdeposit=intdeposit.getString();
    		
    		Register register=new Register(this,dis);
    	}
    	}
		else if(command == regback)
		{
			parent.show();
		}
		
	}
	public void tryAgain()
	{
		Alert error = new Alert("InValid","Invalid Creditcard Number", null, AlertType.ALARM); 

		dis.setCurrent(error);
		error.getType().playSound(dis);
	}
	void login()
	{
	parent.show();
	}

}
