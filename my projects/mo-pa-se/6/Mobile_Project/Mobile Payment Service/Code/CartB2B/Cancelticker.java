import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Ticker;


public class Cancelticker implements CommandListener {
	Display dis;
	Cancellation parent;
	private static final String TICKER_TEXT = "-----------------> Your bill have been cancelled successfully <----------------" ;
	private Form cancelForm=new Form("CancelForm");
	private Command back = new Command("Back", Command.BACK, 1);
	private Ticker t;  
	    
	    
	    
	public Cancelticker(Cancellation cancellation, Display display) {
		this.dis=display;
		this.parent=cancellation;
		
		
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
