import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;


public class Gauge1 implements Runnable{
	
	Quantity parent;
	Display dis;
	private Form gauge;
	

	private static final String STR_PROGRESS = "progress";
	private static int WAIT_TIME = 500;
	private static String STR_LAODING_MSG = "Loading ";
	private static String STR_DOTS_MSG = "...";
	private static String strAction = "";
	private Gauge progressGauge ;

	public Gauge1(Quantity department, Display display) {
		this.parent=department;
		this.dis=display;
		
		
		gauge=new Form("GAUGE");
		 dis.setCurrent(gauge);
		
		
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
		
         dis.setCurrent(gauge);
	 }

}
