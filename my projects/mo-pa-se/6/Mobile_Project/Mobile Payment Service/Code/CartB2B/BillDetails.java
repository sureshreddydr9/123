import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;


public class BillDetails implements Runnable{
	Display dis;
	placeorder parent;
	public BillDetails(placeorder placeorder, Display display)
	{
		this.dis=display;
		this.parent=placeorder;
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
				System.out.println("********* "+placeorder.name);
				String url="http://localhost:8080/CartB2B/billdetail.jsp?name="+placeorder.name+"&address="+placeorder.address+"&mobno="+placeorder.mobno+"&ccno="+placeorder.ccno;
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
			
			//verification v = new verification(this,dis);
	}
		

}
