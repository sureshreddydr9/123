import java.io.IOException;
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
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;


public class moneyTransfer implements CommandListener,Runnable {
	
	MoneyTransferDesign parent;
	Display dis;
	private Ticker t;
	private Command back;
	

	Image img=loadImage("/success.jpg");
	public moneyTransfer(MoneyTransferDesign mt, Display display, String sender, String receiver,String amount) {
	
		this.parent=mt;
		this.dis=display;
		
				
   		back=new Command("Back",Command.BACK,1);
   		System.out.println(userRegister.username);
   		Thread t=new Thread(this);
   		t.start();
	}

		public void run() {
			StringBuffer sb =new StringBuffer();
			InputStream is=null;
			HttpConnection hc=null;
			
			//adding the options into the Screen
			try
			{
				long len=0;
				int ch=0;
				
				System.out.println("********* "+userRegister.userphone);
				String url="http://localhost:8080/MobileAjax/moneytransfer.jsp?sender="+login.accno+"&receiver="+MoneyTransferDesign.receive+"&amount="+MoneyTransferDesign.money;
				System.out.println("URL : "+url);
				hc=(HttpConnection)Connector.open(url);
				System.out.println(" : "+hc);
				is= hc.openInputStream();
				System.out.println("is : "+is);
				
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
				String balList=sb.toString();
				
				if(balList.trim().equals("")){
					tryAgain();
					System.out.println("error entry");
					//dis.setCurrent(form2);
				}
				else
				{
					Form success= new Form("Money Transfer");
					String sucticker= "***********Rs "+" "+MoneyTransferDesign.money+" "+"has been  sent successfully to the Accno"+MoneyTransferDesign.receive+"**********Thank you Visit again....." ;
					t=new Ticker(sucticker);
					success.setTicker(t);
					success.addCommand(back);
					
			
					success.append(new ImageItem("",img,ImageItem.LAYOUT_CENTER,"thank you"));
					dis.setCurrent(success);
					success.setCommandListener(this);
					
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
			Alert error = new Alert(" Incorrect","Insufficient Balance, so you cant do Money Transfer", null, AlertType.ERROR);
			dis.setCurrent(error);
			error.getType().playSound(dis);
		}
		
		
		
		public void commandAction(Command c, Displayable arg1) {
		if(c==back)
		{
			parent.show();
		}
			
		}

}

