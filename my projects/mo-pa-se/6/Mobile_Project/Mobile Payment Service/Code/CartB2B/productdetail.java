import gov.nist.core.StringTokenizer;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


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
import javax.microedition.lcdui.List;

/**
 * @author mohana
 *
 */
public class productdetail implements Runnable,CommandListener
{
	List productDetail;//to display the productdetails
	//public static int primeKey=0;
	/*
	 * Command Button to 
	 */
	Form productForm ;
	private Form ConfirmForm;
	
	String item[];
	Vector vector1=new Vector();
	private Command proOk=new Command("OK",Command.OK,1);
	private Command proBack=new Command("Back",Command.BACK,1);
	private static String price="";
	private static String proprice="";
	private static String value="";
	Image jwel=loadImage("/jwel.jpg");

	
	
	Display dis;

	searchID sharing;  //object for searchID 

	public String proName="";
	public String shop="";
	public productdetail(searchID sharing,Display display)
	{
		this.sharing=sharing;
		this.dis=display;

		System.out.println("String from parent : "+searchID.productIndex);
		Thread t1=new Thread(this);
		t1.start();

	}
	public void run()
	{
		InputStream is=null;
		HttpConnection hc=null;

		try
		{
			StringBuffer availProduct =new StringBuffer();


			long len=0;
			int ch=0;

			proName=searchID.productIndex;
			shop=FileSharing.shopID;



			String url="http://localhost:8080/CartB2B/productName.jsp?proName="+proName+"&shop="+shop;
			System.out.println("url in product form : "+url);
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
				
				productDetail=new List("Product Details",List.IMPLICIT);
				
				ConfirmForm =new Form("Confirmation");
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
						productDetail.append(item[i].trim(), null);
						price=item[0];
					
						
					}
					int i=price.indexOf(":");
					
						String name=price.substring(0,i).trim();
						value=price.substring(i+1,price.length()).trim();
						System.out.print("sdghf"+name);
						System.out.print("\n\n\nThe value is"+value);
						
				}


			//	productDetail.append(new ImageItem("",jwel,ImageItem.LAYOUT_EXPAND,"thank you"));
				productDetail.addCommand(proBack);
				productDetail.addCommand(proOk);
				

				dis.setCurrent(productDetail);
				productDetail.setCommandListener(this);
				ConfirmForm.setCommandListener(this);

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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

	void disp()
	{
		dis.setCurrent(productDetail);
	}

	public void commandAction(Command c, Displayable s)
	{
		if(c == proOk )
		{
		
			proprice=value;
			order order=new order(dis,this,proprice);

		}
		else if(c == proBack )
		{
			sharing.disp();
		}


	}
	public void tryAgain()
	{
		Alert error = new Alert("InValid","Please enter the valid ID", null, AlertType.ERROR);
		dis.setCurrent(error);
		error.getType().playSound(dis);
	}

	public void show() {
		dis.setCurrent(productDetail);
	}
	
	public void shop() {
		sharing.shop();
		
		
	}
   		
}					