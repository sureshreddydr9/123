



// 2 class

import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Image;
import java.io.*;


class login implements Runnable,CommandListener
{

	private Command ok;
   	private Command back;
   	private Command sok;
   	/*private Command placeorder;
   	private Command help;*/
  	  	
   	Image loadimg=loadImage("/duke.png");
	Image spencer=loadImage("/spencer.jpg");
  	
   	Display dis;
   	String user="",pass="";
   	Form  form1,form2,form3;
   	
    CartB2B parent;
    
    //Constuctor
  
    
    login(CartB2B m,Display dis,String a,String b)
   	{
    	
		this.parent=m;
		this.dis=dis;
   		//options
   		ok=new Command("OK",Command.OK,1);
	    back=new Command("Logout",Command.BACK,1);
	    sok=new Command("Ok",Command.OK,1);
	  /*  placeorder=new Command("Place Order",Command.SCREEN,1);
	   help=new Command("Help",Command.SCREEN,1);*/
	   
	    user=a;
	    pass=b;
   		
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
		form1=new Form("Home");
		form2=new Form("Options");
		form2.addCommand(back);
//		form2.addCommand(placeorder);
//        form2.addCommand(help);
		form2.addCommand(sok);
    	form2.append(new ImageItem("",spencer,ImageItem.LAYOUT_CENTER,"thank you"));
		form2.setCommandListener(this);
    	try
		{
			long len=0;
			int ch=0;

			String url="http://localhost:8080/CartB2B/login.jsp?username="+user+"&password="+pass;
			System.out.println("URL : "+url);
			hc=(HttpConnection)Connector.open(url);
			System.out.println("hai : "+hc);
			is= hc.openInputStream();
			System.out.println("is : "+is);
			len=hc.getLength();
			System.out.println("length : "+len);
			if(len!=-1)
			{
				for(int i=0;i<len;i++)
				{
					if((ch=is.read())!=-1)
					{
						sb.append((char)ch);
						System.out.println("sb:"+sb.toString());

					}
				}
			}
			String str1=sb.toString();
			System.out.println("User :"+str1.trim());
			
			if(str1.trim().equals("")){
				tryAgain();
				System.out.println("error entry");
				
			}
			else
			{
				dis.setCurrent(form2);
				System.out.println("s");
			}

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
	     Alert error = new Alert(" Incorrect","Give Correct Userid & Password", null, AlertType.ERROR);
	     dis.setCurrent(error);
		error.getType().playSound(dis);
	}

	public void commandAction(Command c, Displayable s)
  	{
		
	  	
	  	if(c == back )
		{
	  		parent.logout();
	
			
		}
	  	else if(c == sok)
	  	{
	  	ShopDetails sd= new ShopDetails(this,dis);
	  	}
	  
	  	}


	void display()
	{
		dis.setCurrent(form2);
	}
	public void show() {
		dis.setCurrent(form2);
		
		
	}
}