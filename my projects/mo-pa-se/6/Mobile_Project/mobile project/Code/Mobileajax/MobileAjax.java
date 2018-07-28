//Main Program

/*
 * Mobile Ajax
 * 
 */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import javax.microedition.lcdui.Image;
import java.io.IOException;


public class MobileAjax extends MIDlet implements CommandListener,Runnable
{
	private Display display;
	
  	/*
  	 * Form Objects
  	 */
  	
  	private Form mainForm; //Main Form
	private Form loginForm;//Login Formq
	private Form gaugeFrom;//To load the guage
	
	/*
	 * Commend Buttons
     */
	
	private Command login=new Command("Login",Command.SCREEN,1);
	private Command register=new Command("Register",Command.HELP,1);
	private Command changepwd=new Command("Change Password",Command.HELP,1);
	private Command exit=new Command("Exit",Command.EXIT,1);
	private Command ok=new Command("Ok",Command.OK,1);
	private Command back=new Command("Back",Command.BACK,1);
	
	
	/*
	 * String used for guage
	 */
	
	private static final String STR_PROGRESS = "progress";
	private static int WAIT_TIME = 500;
	private static String STR_LAODING_MSG = "Loading ";
	private static String STR_DOTS_MSG = "...";
	private static String strAction = "";

	private Gauge progressGauge ;
	
	
	private TextField customerid=new TextField("User Name       :","",20,TextField.ANY);
	private TextField password=new TextField("Password        :","",20,TextField.PASSWORD);
	private TextField accno=new TextField("Account No       : ","",20,TextField.ANY);

	/*
	 * str is used to read the help text file
	 */
  	
  	public StringBuffer sb = new StringBuffer();

  	/*
  	 * Images object to load on the screen
  	 */
  	Image img=loadImage("/java.png");
  	//Image img1=loadImage("/duke.png");
  //	Image image=loadImage("/logo.png");
  	Image rose=loadImage("/rupee.jpg");
  	Image key=loadImage("/key.jpg");
  	Image bg=loadImage("/bg.bmp");
  	
  	public static String username="";

	/*
	 * 
	 * constructor
	 */
  	
 	public MobileAjax()
  	{
 		
		display = Display.getDisplay(this);
		
	   
		gaugeFrom=new Form("Guage");
		//select1=new Form("Select one to Launch");
    	mainForm = new Form("Mobile Ajax");
		loginForm=new Form("Login");

		mainForm.append(new ImageItem("",rose,ImageItem.LAYOUT_CENTER,"thank you"));
		
       	mainForm.addCommand(exit);
    	mainForm.addCommand(login);
    	mainForm.addCommand(register);
    	mainForm.addCommand(changepwd);
		loginForm.addCommand(back);
		loginForm.addCommand(ok);
		
		progressGauge = new Gauge("Loading",true, 9 ,10);
		strAction = STR_PROGRESS;
        new Thread(this).start();
        
        gaugeFrom.append(progressGauge);
        display.setCurrent(gaugeFrom);
		
        
        loginForm.append(customerid);
		loginForm.append(password);
		loginForm.append(accno);
		loginForm.append(new ImageItem("",key,ImageItem.LAYOUT_CENTER,"thank you"));
		
		
		
    	mainForm.setCommandListener(this);
    	loginForm.setCommandListener(this);
 	}

  	public void startApp()	{ 	}

  	public void pauseApp() 	{ 	}

  	public void destroyApp(boolean unconditional)
  	{
  	    destroyApp(false);
  	    notifyDestroyed();
  	}

	//to load the image
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

	public void run()
	{
		
		if(strAction.equals(STR_PROGRESS))
	    {
             int i = 0;
             while(i <= 10)
             {
                 try
                 {
                     progressGauge.setValue(i);
                     progressGauge.setLabel(STR_LAODING_MSG + i * 10 + STR_DOTS_MSG);
                     Thread.sleep(WAIT_TIME);
                     i = i + 1;
                 }
                 catch(Exception e)
                 {
                     System.out.println("Exception" + e);
                 }
             }
         }
		
         display.setCurrent(mainForm);
	 }


	public void commandAction(Command command, Displayable s)
  	{

    	if(command == login)
    	{
    		display.setCurrent(loginForm);
    		
    	}

    	else if(command==register)
   		{
    		System.out.println("register");
    		
    			
    			System.out.println("regiaterasdfasdfsd");
    			
    			
   				userRegister register=new userRegister(this,display);
   				
   				
		   	
		}
    	else if(command == changepwd )
		{
			
			changepassword cpw=new changepassword(this,display);
			
					
			
		}
       	else if(command == exit)
    	{
			notifyDestroyed();
		}
		if(s==loginForm)
		{
			if(command == ok)
			{
					
				String user=customerid.getString();
				String pass=password.getString();
				String account=accno.getString();
				if(user.trim().equals("")||pass.trim().equals("")){
					Alert a=new Alert("ERROR","Invalid User",img,null);
					display.setCurrent(a, mainForm);
				}
				else
				{
					login l=new login(this,display,user,pass,account);
				}

			}
			else if(command == back )
			{
				
				display.setCurrent(mainForm);
				
						
				
			}
			
			
		}
	
		
			 if(command == back )
			{
				
				try {
					display.setCurrent(mainForm);
				} catch (Exception e) {
					// TODO: handle exception
				}				
				
						
				
			}
		}


	void show()
	{
		Display.getDisplay(this).setCurrent(mainForm);
	}
}