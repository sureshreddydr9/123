import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Ticker;


public class billcancel implements Runnable,CommandListener{
	 Cancellation parent;
	 Display dis;
	 
	 private static final String TICKER_TEXT = "-----------------> Your bill have been cancelled successfully <----------------" ;
		private Form cancelForm=new Form("CancelForm");
		private Command back = new Command("Home", Command.BACK, 1);
		private Ticker t;  
	public billcancel(Cancellation cancellation, Display display) {
		
		this.parent=cancellation;
		this.dis=display;
		Thread t1=new Thread(this);
		t1.start();
		
	}
	public void run() {
		StringBuffer sb =new StringBuffer();
		InputStream is=null;
		HttpConnection hc=null;
		
		//adding the options into the Screen
		try
		{
			System.out.println("********* ");
			String url="http://localhost:8080/CartB2B/cancel.jsp?name="+Cancellation.cname+"&ccno="+Cancellation.creditcard;
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
		}
		
		 t = new Ticker(TICKER_TEXT);
		 cancelForm.setTicker(t);
		 cancelForm.addCommand(back);
	      dis.setCurrent(cancelForm);
	      cancelForm.setCommandListener(this);
		
	}
	public void commandAction(Command c, Displayable arg1) {
		if(c==back)
		{
		parent.shop();	
		}
	}

}
