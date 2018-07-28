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
import javax.microedition.lcdui.Ticker;

import java.io.*;

public class placeorder implements CommandListener
{
	String msg="hai";
	//Ticker Creation
	private static final String poticker= "Order Ur Product Here...." ;
	//create a new form in the name of po
	private Form po=new Form("Fill the Form");

	//create a text fields for name, address, mobile,and creditcard no
	private TextField poname= new TextField("Name","",20,TextField.ANY); 	
	private TextField poaddress= new TextField("Address","",20,TextField.ANY);
	private TextField pomobno= new TextField("Mobileno      ","",10,TextField.PHONENUMBER);
	private TextField poccno= new TextField("Creditcard No            ","",6,TextField.PASSWORD);



	public static String name="";
	public static String address="";
	public static String mobno="";
	public static String ccno="";
	public static int length=0;
	public static int phlength=0;



	//create a commandbuttons

	private Command popress,poback;
	order parent;
	Display dis;
	//ticker object
	private Ticker t;
	private static String amount1="";
	success successParent;


	public placeorder(order order,Display display,String amount)
	{
		amount1=amount;
		this.dis=display;
		this.parent=order;
		orderPlaced();
	}


	public void orderPlaced()
	{

		popress=new Command("Press",Command.OK,1);
		poback=new Command("Back",Command.BACK,2);


		t=new Ticker(poticker);
		// set the ticker and textfields into the form
		po.setTicker(t);
		po.append(poname);
		po.append(poaddress);
		po.append(pomobno);
		po.append(poccno);
		po.addCommand(popress);
		po.addCommand(poback);
		// for display
		dis.setCurrent(po); 
		po.setCommandListener(this);
	}

	public void commandAction(Command c, Displayable s) {
		{

			if(c == popress)
			{
				System.out.print("haiiiiiiii");
				name=poname.getString();
				address=poaddress.getString();
				mobno=pomobno.getString();
				ccno=poccno.getString();

				length=ccno.length();
				phlength=mobno.length();
				if(phlength>6 || phlength<=10)
				{
					System.out.print("\nPhone Length------------>"+phlength);	
					phoneCheck();
					if(length!=6 )
					{
						tryAgain();
						System.out.print("you must type 6 nnumbers");
					}
					else
					{


						System.out.print("\nLength------------>"+length);			
						BillDetails bill=new BillDetails(this,dis);
						verification v = new verification(this,dis,amount1);
					}
				}
			}


			else if(c == poback)
			{

				parent.show();
			}


		}
	}


	public void tryAgain()
	{
		Alert error = new Alert("InValid","Please enter the valid Creditcard Number", null, AlertType.ALARM); 

		dis.setCurrent(error);
		error.getType().playSound(dis);
	}

	public void phoneCheck()
	{
		Alert error = new Alert("InValid","Please enter the valid Phone Number", null, AlertType.ERROR); 
		dis.setCurrent(error);
		error.getType().playSound(dis);
	}

	public void show() {
		dis.setCurrent(po);
	}

	public void shop() {
		parent.shop();


	}


}

