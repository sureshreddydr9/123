/*//class  2--searchID.java


 * This class is to search & list the available products in the shop 
 

*//**
 * @author amutha
 *
 */


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
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Image;
import java.io.*;



public class searchID implements Runnable,CommandListener
{
	List productList;//to display the available products
	
	Image loadimg=loadImage("/duke.png");
	
	
	 /* Command Button to */
	 
	
	private Command searchOk=new Command("List",Command.OK,1);
	private Command searchBack=new Command("Back",Command.BACK,1);
   	
	Display dis;
		
	FileSharing sharing;
	String item[];
	
	public static String productIndex="";//to retrieve the index of the product
	public String searchID="";

	public searchID(FileSharing sharing,Display display)
	{
		this.sharing=sharing;
		this.dis=display;
		Thread t1=new Thread(this);
		t1.start();

	}
	public void run()
	{
		StringBuffer availProduct =new StringBuffer();
		
		InputStream is=null;
		HttpConnection hc=null;
		
		try
		{
			long len=0;
			int ch=0;
			
			searchID=FileSharing.shopID;
			String url="http://localhost:8080/CartB2B/searchID.jsp?shopid="+searchID;
			
			hc=(HttpConnection)Connector.open(url);
			is= hc.openInputStream();
			len=hc.getLength();
			if(len!=-1)
			{
				for(int i=0;i<len;i++)
				{
					if((ch=is.read())!=-1)
					{
						if(ch!=13 && ch!=10)
							availProduct.append((char)ch);
						//System.out.println("Addres Buf   !"+sb);
					}
				}
			}
			String proList=availProduct.toString();
			
			if(proList.trim().equals("")){
				tryAgain();
				System.out.println("error entry");
				//dis.setCurrent(form2);
			}
			else{
			System.out.println("string from : "+proList);
			System.out.println(proList);
			//item=new String[proList.trim().length()];
			productList = new List("Available List",List.IMPLICIT);
			int index=proList.trim().indexOf("#");
			
			int delimiterCount=0;
			char[] proResult=proList.toCharArray();

			for (int i = 0; i < proResult.length; i++) {

				if(proResult[i]=='#')
				{
					delimiterCount++;
				}
			}
			System.out.println("Count : " + delimiterCount);
			item=new String[delimiterCount];
			
			
			
			
			if(index >= 0)
			{
				for(int i=0;i<delimiterCount;i++)
				{

					item[i]=proList.substring(0,proList.indexOf("#") );
					proList=proList.substring(proList.indexOf("#")+1);
					System.out.println("ITEM address :  "+item[i]);
					productList.append(item[i].trim(), null);

				}
				
			}
			//ListSpilit.spilitList(proList);
			productList.addCommand(searchOk);
			productList.addCommand(searchBack);

			productList.setCommandListener(this);
			dis.setCurrent(productList);
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

	public void commandAction(Command c, Displayable s)
	{
		if(c == productList.SELECT_COMMAND)
		{
			int index=productList.getSelectedIndex();
			switch(index)
			{
   				case 0:
   					productIndex=productList.getString(productList.getSelectedIndex());
   					System.out.println("Product Index 0 : "+productIndex);
   					break;
   				case 1:
   					productIndex=productList.getString(productList.getSelectedIndex());
   					System.out.println("Product Index 1 : "+productIndex);
   					break;
   				case 2:
   					productIndex=productList.getString(productList.getSelectedIndex());
   					System.out.println("Product Index 2 : "+productIndex);
   					break;
   				case 3:
   					productIndex=productList.getString(productList.getSelectedIndex());
   					System.out.println("Product Index 3 : "+productIndex);
   					//services m=new services(this,dis,zipcode);
   					break;
   				default:
   					productIndex=productList.getString(productList.getSelectedIndex());
					System.out.println("Product Index : "+productIndex);
			}
			productdetail product = new productdetail(this,dis);
		}
		else if(c == searchBack )
		{
			sharing.show();
		}
	}

	void disp()
	{
		dis.setCurrent(productList);
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
	     Alert error = new Alert("InValid","Please try again", null, AlertType.ERROR);
	     dis.setCurrent(error);
	     error.getType().playSound(dis);
	}
	 
	 public void shop() {
			sharing.shop();
			
			
		}
	   		

}