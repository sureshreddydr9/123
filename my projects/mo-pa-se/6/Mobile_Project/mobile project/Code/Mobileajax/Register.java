



// 2 class

import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Ticker;

import javax.microedition.lcdui.Image;
import java.io.*;


public class Register implements Runnable,CommandListener
{
	userRegister parent;
	
    Display dis;
	private Command back2login;
	private Form success;
	
	
	public static String name="";
	
    
 
    //Constuctor
  
    
    public Register(userRegister m,Display display)
   	{
    	 back2login=new Command("Back",Command.BACK,1);
		this.parent=m;
   		//options
   		
   		this.dis=display;
   		System.out.println(userRegister.username);
   		Thread t=new Thread(this);
   		t.start();
   	}
   	public void run()
   	{
   		//DB connections
		StringBuffer sb =new StringBuffer();
		InputStream is=null;
		HttpConnection hc=null;
		
		//adding the options into the Screen
		try
		{
			System.out.println("********* "+userRegister.userphone);
			String url="http://localhost:8080/MobileAjax/registration.jsp?username="+userRegister.useruname+"&password="+userRegister.password+"&name="+userRegister.username+"&fname="+userRegister.userfname+"&age="+userRegister.userage+"&dob="+userRegister.userdob+"&sex="+userRegister.usersex+"&education="+userRegister.usereducation+"&occupation="+userRegister.useroccupation+"&aincome="+userRegister.useraincome+"&address="+userRegister.useraddress+"&city="+userRegister.usercity+"&phoneno="+userRegister.userphone+"&email="+userRegister.useremail+"&intdeposit="+userRegister.userintdeposit;
			System.out.println("URL : "+url);
			hc=(HttpConnection)Connector.open(url);
			System.out.println("hai : "+hc);
			is= hc.openInputStream();
			System.out.println("is : "+is);
		}
		catch(Exception e)
		{
			System.out.println(e+"Exception In Menu");
			tryAgain();
	 	}
		finally
		{
			try
			{
				is.close();
				hc.close();
			}
			catch(Exception e )
			{
				System.out.println(e+"Exception In Finally");
				
			}
		}
		Getaccid getid=new Getaccid(this,dis,userRegister.useruname);
   	
		
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

	public void tryAgain()
	{
	     Alert error = new Alert(" Incorrect","Please try again", null, AlertType.ERROR);
	     dis.setCurrent(error);
		error.getType().playSound(dis);
	}

	

	void login()
	{
		parent.login();
	}
	public void commandAction(Command arg0, Displayable arg1) {
		// TODO Auto-generated method stub
		
	}
}
