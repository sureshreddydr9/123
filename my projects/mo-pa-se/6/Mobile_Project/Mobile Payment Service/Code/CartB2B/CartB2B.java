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


public class CartB2B extends MIDlet implements CommandListener,Runnable
{
	private Display display;
	
  	/*
  	 * Form Objects
  	 */
  	
  	private Form form;
	private Form form1;
	private Form firstForm;
	
		/*
	 * Commend Buttons
     */
	
	private Command login=new Command("Login",Command.SCREEN,1);
	private Command register=new Command("Register",Command.HELP,1);
	private Command exit=new Command("Exit",Command.EXIT,1);
	private Command ok=new Command("OK",Command.OK,1);
	private Command back=new Command("BACK",Command.BACK,1);
	
	
	/*
	 * String used for guage
	 */
	
	private static final String STR_PROGRESS = "progress";
	private static int WAIT_TIME = 500;
	private static String STR_LAODING_MSG = "Loading ";
	private static String STR_DOTS_MSG = "...";
	private static String strAction = "";

	private Gauge progressGauge ;
	
	
	private TextField customerid=new TextField("User Name       :","",10,TextField.ANY);
	private TextField password=new TextField("Password          :","",10,TextField.PASSWORD);
	

	/*
	 * str is used to read the help text file
	 */
  	
  	public StringBuffer sb = new StringBuffer();

  	/*
  	 * Images object to load on the screen
  	 */
  	
  	Image rose=loadImage("/IMAGE001.jpg");
  
  	
  	public static String username="";

	/*
	 * 
	 * constructor
	 */
  	
 	public CartB2B()
  	{
 		
		display = Display.getDisplay(this);
		
	   
		firstForm=new Form("Guage");
		//select1=new Form("Select one to Launch");
    	form = new Form("WELCOME");
		form1=new Form("Login");

		form.append(new ImageItem("",rose,ImageItem.LAYOUT_CENTER,"thank you"));
		
       	form.addCommand(exit);
    	form.addCommand(login);
    	form.addCommand(register);
		form1.addCommand(back);
		form1.addCommand(ok);
		progressGauge = new Gauge("Loading",true, 9 ,10);
		strAction = STR_PROGRESS;
        new Thread(this).start();
        firstForm.append(progressGauge);
        display.setCurrent(firstForm);
		form1.append(customerid);
		form1.append(password);
		
		
		
    	form.setCommandListener(this);
    	form1.setCommandListener(this);
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
		
         display.setCurrent(form);
	 }

	 private String readmsg()
	 {
		InputStream is = getClass().getResourceAsStream("/help.txt");
		try
		{
			int chr;
		    // Read until the end of the stream
		    while ((chr = is.read()) != -1)
		    {
			    sb.append((char) chr);
			}
			return sb.toString();
		}
		catch (Exception e)
		{
		    System.out.println("Unable to create stream");
		}
	   	return null;
    }

	public void commandAction(Command command, Displayable s)
  	{

    	if(command == login)
    	{
    		display.setCurrent(form1);
    		
    	}

    	else if(command==register)
   		{
    		System.out.println("regiater");
    		
    			//reg.append(new ImageItem("",bg,ImageItem.LAYOUT_CENTER,"thank you"));
    			System.out.println("regiaterasdfasdfsd");
    			
    			
   				userRegister register=new userRegister(this,display);
   				
   				
		   	
		}
       	else if(command == exit)
    	{
			notifyDestroyed();
		}
		if(s==form1)
		{
			if(command == ok)
			{
					
				String user=customerid.getString();
				String pass=password.getString();
				if(user.equals("")||pass.equals("")){
					Alert a=new Alert("ERROR","Invalid User",null,null);
					display.setCurrent(a, form);
				}
				else
				{
					login l=new login(this,display,user,pass);
				}

			}
			else if(command == back )
			{
				
				display.setCurrent(form);
				
						
				
			}
		}
	
		
			 if(command == back )
			{
				
				try {
					display.setCurrent(form);
				} catch (Exception e) {
					// TODO: handle exception
				}				
				
						
				
			}
		}


	void show()
	{
		Display.getDisplay(this).setCurrent(form);
	}
	
	void disp()
	{
		
		display.setCurrent(form1);
	}
	void logout()
	{
		notifyDestroyed();
	}
	
	
}