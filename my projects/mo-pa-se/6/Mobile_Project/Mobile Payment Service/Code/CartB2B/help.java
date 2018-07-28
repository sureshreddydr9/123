

	import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
	

	public class help  implements CommandListener{
	   
	    private static final String TICKER_TEXT = "Welcome to HELP PAGE " ;

	    private Form helpForm=new Form("Help Page");;
	    private Command hback = new Command("Back", Command.BACK, 1);
	    private TextField message=new TextField("","This is an eay Process to PlaceOrder.Go on presssing,if u..",75,TextField.ANY);
	    private Display  myDisplay;
	    String msg="Specify the project ,then you will get the  price Finally the money is detucted from your credit card";
	    FileSharing parent;
	    private Ticker t;
	    
	    public help(FileSharing sharing, Display dis){
	    	this.parent=sharing;
	        myDisplay =dis;
	        t = new Ticker(TICKER_TEXT);
            helpForm.setTicker(t);
            
            helpForm.append(message);
            helpForm.append(msg);
	        helpForm.addCommand(hback);
	        dis.setCurrent(helpForm);
	        helpForm.setCommandListener(this);
	    }                    

	   

		
		




		public void commandAction(Command c, Displayable s) {
		if (c == hback) {
			
	          parent.show();     
		}	
	    }
	}



