import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Ticker;


public class change implements Runnable ,CommandListener{
	
	changepassword parent;
	MobileAjax ajax;
	Display dis;
	private Ticker t;
	private Form pass=new Form("Change Password");
	private Command back=new Command("back",Command.BACK,1);
	private Command Home=new Command("Home",Command.BACK,1);	
	Image img=loadImage("/pass.jpg");
	public change(changepassword cpw, Display display) {
		System.out.println("++++++++++++++++++++++++++++++++++");
		this.dis=display;
		this.parent=cpw;
		Thread thread= new Thread(this);
		thread.start();
	
	}
	public void run() {
		StringBuffer sb =new StringBuffer();
		InputStream is=null;
		HttpConnection hc=null;
		
		//adding the options into the Screen
		try
		{
			
			String url="http://localhost:8080/MobileAjax/changepwd.jsp?name="+changepassword.name+"&pass="+changepassword.pass+"&newpass="+changepassword.newpass;
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
			
			
			String sucticker= "***********Your Password changed successfully ***********" ;
			t=new Ticker(sucticker);
			pass.setTicker(t);
			
			
	
			pass.append(new ImageItem("",img,ImageItem.LAYOUT_CENTER,"thank you"));
			pass.addCommand(back);
		
			dis.setCurrent(pass);
			pass.setCommandListener(this);
			
		}
	
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
		if(c==back)
		{
			parent.display();
		}
		else if(c == Home)
		{
			ajax.show();
		}


		
	}
}

