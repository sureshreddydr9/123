



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

import javax.microedition.lcdui.Image;
import java.io.*;


public class Register implements Runnable,CommandListener
{
	userRegister parent;
CartB2B cart;
    Display dis;
    
 
    Image login=loadImage("/login.gif");
    private Command back;
    //Constuctor
  
    
    public Register(userRegister m,Display display)
   	{
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
			String url="http://localhost:8080/CartB2B/registration.jsp?username="+userRegister.username+"&password="+userRegister.password+"&address="+userRegister.useaddress+"&phone="+userRegister.userphone+"&email="+userRegister.usermailid;
			System.out.println("URL : "+url);
			hc=(HttpConnection)Connector.open(url);
			System.out.println("hai : "+hc);
			is= hc.openInputStream();
			System.out.println("is : "+is);
		}
		catch(Exception e)
		{
			System.out.println(e+"Exception In Menu");
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
		Form success= new Form("Registration");
		String msg="Registered Successfully";
		back=new Command("Login",Command.OK,1);
		success.append(msg);
		success.append(new ImageItem("",login,ImageItem.LAYOUT_VEXPAND,"thank you"));
		success.addCommand(back);
		dis.setCurrent(success);
		success.setCommandListener(this);
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

	/*public void tryAgain()
	{
	     Alert error = new Alert(" Incorrect","Please try again", null, AlertType.ERROR);
	     dis.setCurrent(error);
		error.getType().playSound(dis);
	}
*/
	public void commandAction(Command c, Displayable s)
  	{
		
	  	 if(c == back )
		{
	  		parent.showlogin();
		}
	}

	void display()
	{
		//dis.setCurrent(form2);
	}
}