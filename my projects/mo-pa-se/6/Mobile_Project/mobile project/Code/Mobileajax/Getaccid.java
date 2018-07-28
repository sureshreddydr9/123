import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Ticker;


public class Getaccid implements CommandListener,Runnable {
	Display dis;
	Register parent;
	private Ticker t;
	public static String name="";
	public static String balList="";
	private Command back2login=new Command("back",Command.BACK,1);
	private static final String sucticker= "Ur Details are Registered SuccussFully....." ;
	public Getaccid(Register register, Display dis,String a) {
		name=a;
		this.dis=dis;
		this.parent=register;
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
			long len=0;
			int ch=0;

			
			String url="http://localhost:8080/MobileAjax/accno.jsp?username="+name;
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
			 balList=sb.toString();
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
		
		t=new Ticker(sucticker);
		
		success.setTicker(t);
		success.append("ur Accno is:"+balList);
		
		
		success.addCommand(back2login);
		dis.setCurrent(success);
		
		success.setCommandListener(this);

}
	public void commandAction(Command c, Displayable arg1) {
		
		
		 if(c == back2login )
			{
				parent.login();
			}
		}


	
		
	}

