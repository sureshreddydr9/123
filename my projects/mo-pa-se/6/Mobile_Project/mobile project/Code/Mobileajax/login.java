



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

	
	//commands for Login Screen
	private Command ok;
   	private Command back;    
   	private Command balance,moneytransfer,minist,check,newpolicy;
   
   	private Command help;
  	  	
   	
	Image spencer=loadImage("/balance.jpg");
  	
   	Display dis;
   	public static String user="",pass="";
   	public static String accno="";
   	
   	
   	//for money transfer form
     	
   	
   	
   	Form  form1,form2,form3,mtransfer;
   	
    MobileAjax parent;
    
    //Constuctor
  
    
    login(MobileAjax m,Display display,String a,String b,String c)
   	{
		this.parent=m;
		this.dis=display;
		//options for login page
   		ok=new Command("OK",Command.OK,1);
	    back=new Command("BACK",Command.BACK,1);
	    balance=new Command("Balance",Command.SCREEN,1);
	    moneytransfer=new Command("Money Transfer",Command.SCREEN,1);
	    minist=new Command("MiniStatement",Command.SCREEN,1);
	    check=new Command("Checkbook request",Command.SCREEN,1);
	    newpolicy=new Command("New policies",Command.SCREEN,1);
	    help=new Command("Help",Command.SCREEN,1);
	   
	    user=a;
	    pass=b;
	    accno = c;
	    	    
   		Thread t=new Thread(this);
   		t.start();
   	}
   	public void run()
   	{
   		//DB connections
		StringBuffer sb =new StringBuffer();
		InputStream is=null;
		HttpConnection hc=null;
		
		//adding the options into the  login Screen
		form1=new Form("Mobile Ajax");
		form2=new Form("Options");
		form2.addCommand(back);
		form2.addCommand(balance);
		form2.addCommand(moneytransfer);
		form2.addCommand(minist);
		form2.addCommand(check);
		form2.addCommand(newpolicy);
		form2.addCommand(help);
    	form2.append(new ImageItem("",spencer,ImageItem.LAYOUT_CENTER,"thank you"));
		form2.setCommandListener(this);
    	try
		{
			long len=0;
			int ch=0;

			String url="http://localhost:8080/MobileAjax/login.jsp?username="+user+"&password="+pass+"&accno="+accno;
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
				dis.setCurrent(form2);
				


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
	     Alert error = new Alert(" Incorrect ","Please Give the Information Correctly", null, AlertType.ERROR);
	     dis.setCurrent(error);
		error.getType().playSound(dis);
	}

	public void commandAction(Command c, Displayable s)
  	{
		
	  	
	  	if(c == back )
		{
			parent.show();
			
		}
	  	else if(c == balance)
	  	{	  		
	  		//Its go to Balance.jsp
	  		Balance bal=new Balance(this,dis);
	  	}
	  	
	  	else if(c == moneytransfer)
	  	{

	  		MoneyTransferDesign mtransfer=new MoneyTransferDesign(this,dis);
	  		
	  	}
	  	
	  	else if(c == minist)
	  	{
	  		MiniStatement minist=new MiniStatement(this,dis,accno);
	  	}
	  	else if(c == check)
	  	{
	  		checkrequest cr=new checkrequest(this,dis);
	  	}
	  	else if(c == newpolicy)
	  	{
	  		newpolicy np=new newpolicy(this,dis);
	  	}
	  	else if(c==help)
	  	{
	  		help help=new help(this,dis);
	  	}
	  	
	}

	void display()
	{
		dis.setCurrent(form2);
	}
}
