

	import java.io.IOException;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
	

	public class help  implements CommandListener{
	   
	    private static final String TICKER_TEXT = "Welcome to HELP PAGE " ;

	    private Form helpForm=new Form("Help Page");;
	    private Command hback = new Command("Back", Command.BACK, 1);
	    private TextField message=new TextField("","This is an easy Process for Banking...",75,TextField.ANY);
	    private Display  myDisplay;
	    String msg="Specify the project ,then you will get the  price Finally the money is detucted from your credit card";
	    login parent;
	    private Ticker t;
	    Image img=loadImage("/h.jpg");
	    public help(login login, Display dis) {
	    	this.parent=login;
	        myDisplay =dis;
	        t = new Ticker(TICKER_TEXT);
            helpForm.setTicker(t);
            
            helpForm.append(message);
            helpForm.append(msg);
            helpForm.append(new ImageItem("",img,ImageItem.LAYOUT_CENTER,"thank you"));
	        helpForm.addCommand(hback);
	        dis.setCurrent(helpForm);
	        helpForm.setCommandListener(this);
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

		
		
	    public void commandAction(Command c, Displayable s) {
		if (c == hback) {
			
	          parent.display();     
		}	
	    }
	}



