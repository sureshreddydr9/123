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
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;


public class Balance implements CommandListener,Runnable{
	Display dis;
	login parent;
	
	String item[];
	List acclist;
	Image balance=loadImage("/balance1.jpg");
	
	public Command back = new Command("Back",Command.BACK,1);
	
	public static String useraccno="";
	//constructor
	public Balance(login l,Display display)
	{
		
		this.parent=l;
		this.dis=display;
		useraccno=login.accno;
		Thread t=new Thread(this);
   		t.start();
	}

	public void run() {
//		DB connections
		StringBuffer sb =new StringBuffer();
		InputStream is=null;
		HttpConnection hc=null;

		//adding the options into the Screen

		try
		{
			long len=0;
			int ch=0;

			String url="http://localhost:8080/MobileAjax/balance.jsp?accno="+useraccno;
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
			else{
			System.out.println("string from : "+balList);
			System.out.println(balList);
			item=new String[balList.trim().length()];
			acclist = new List("Available List",List.IMPLICIT);
			int index=balList.trim().indexOf("#");
			int delimiterCount=0;
			char[] proResult=balList.toCharArray();
			
			for (int i = 0; i < proResult.length; i++)
			{
				
				if(proResult[i]=='#')
				{
					delimiterCount++;
				}
			}
			System.out.println("Count : " + delimiterCount);
			if(index >= 0)
			{
				for(int i=0;i<delimiterCount;i++)
				{
					
					item[i]=balList.substring(0,balList.indexOf("#") );
					balList=balList.substring(balList.indexOf("#")+1);
					System.out.println("ITEM address :  "+item[i]);
					acclist.append(item[i].trim(),balance );
					
				}
				
			}
			
			//acclist.append(new ImageItem("",balance,ImageItem.LAYOUT_CENTER,null),null);
			//acclist.append("",new ImageItem("",balance,ImageItem.LAYOUT_CENTER,"thank you"));
			acclist.append("", null);
			acclist.addCommand(back);
			acclist.setCommandListener(this);
			dis.setCurrent(acclist);
			String str1=sb.toString();
			System.out.println("User :"+str1.trim());



			if(str1.trim().equals("")){
				tryAgain();
				System.out.println("error entry");

			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



		
		public void commandAction(Command c, Displayable f) {
			// TODO Auto-generated method stub
			if(c==back){
				parent.display();
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
			Alert error = new Alert(" Incorrect","Please try again", null, AlertType.ERROR);
			dis.setCurrent(error);
			error.getType().playSound(dis);
		}
	}
