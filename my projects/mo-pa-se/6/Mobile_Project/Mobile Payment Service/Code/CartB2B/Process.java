//Main Program

/*
 * Mobile Ajax
 * 
 */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import javax.microedition.lcdui.Image;
import java.io.IOException;


public class Process  implements CommandListener,Runnable
{
	private Display dis;
	Quantity parent;
  	private Form gaugeFrom;//To load the guage
	private Form bill;
	private Command back,cancel,continue1;
		
	/*
	 * String used for guage
	 */
	
	private static final String STR_PROGRESS = "progress";
	private static int WAIT_TIME = 500;
	private static String STR_LAODING_MSG = "Checking ";
	private static String STR_DOTS_MSG = "...";
	private static String strAction = "";


	 public static String name="";
	 public static String address="";
	 public static String mobno="";
	 public static String ccno="";
	 public static String amount="";
	 public static int rate=0;
	 public static int qty=0;
	 public static int amt=0;
	 
	 
	 
	private Gauge progressGauge ;
	
		
  	public StringBuffer sb = new StringBuffer(); 	
   	
 	public Process(Quantity q,Display display,String a)
  	{
 		this.parent =q;
 		
		 this.dis= display;
		 
		 name=Quantity.name;
		 address=Quantity.address;
		 mobno=Quantity.mobno;
		 qty=Integer.parseInt(Quantity.no);
		 rate=Integer.parseInt(a);
		 amt=rate*qty;
		 
		gaugeFrom=new Form("Guage");
		  	
		
		progressGauge = new Gauge("Checking",true, 9 ,10);
		strAction = STR_PROGRESS;
        new Thread(this).start();
        
        gaugeFrom.append(progressGauge);
        display.setCurrent(gaugeFrom);
		bill();
        
		

  	
  	}

	public void run()
	{
		
		if(strAction.equals(STR_PROGRESS))
	    {
             int i = 0;
             while(i <= 10)
             {
                 try
                 {
                     progressGauge.setValue(i);
                     progressGauge.setLabel(STR_LAODING_MSG + i * 10 + STR_DOTS_MSG);
                     Thread.sleep(WAIT_TIME);
                     i = i + 1;
                 }
                 catch(Exception e)
                 {
                     System.out.println("Exception" + e);
                 }
             }
	    }
             	
             	
     
       //  dis.setCurrent(gaugeFrom);
	 }

void bill()
{
	bill=new Form("Billing");
 	bill.append("Name--->"+name);
 	bill.append("\nAddress--->"+address);
 	bill.append("\nMobile No--->"+mobno);
 	bill.append("\nquantity---->"+Quantity.no);
 	bill.append("\nRate---->"+amt);
 	
 	back=new Command("back",Command.BACK,1);
 	cancel=new Command("Cancellation",Command.SCREEN,1);
 	continue1=new Command("Continue",Command.SCREEN,1);
 	bill.addCommand(back);
 	bill.addCommand(cancel);
 	bill.addCommand(continue1);
 	
 	dis.setCurrent(bill);
 	bill.setCommandListener(this);
 	}

	public void commandAction(Command command, Displayable s)
  	{
		if(s==bill)
		{
			if(command==back)
			{
				parent.show();
			}
			else if(command==cancel)
			{
				System.out.println("success");
				Cancellation cancel=new Cancellation(this,dis);
			}
			else if(command==continue1)
			{
				success succ=new success(this,dis);
			}
		}
    	
  	}		
	void shop()
	{
		parent.shop();
	}
	void show()
	{
		dis.setCurrent(bill);
	}
	
	
		   	
	}
       	
		
				

			
			
	