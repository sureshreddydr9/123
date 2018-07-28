import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Ticker;




public class newpolicy implements CommandListener{
	login parent;
	Display dis;
	private Ticker t;
	private Form policy;
	private Command back;
	Image baby=loadImage("/baby1.jpg");
	
	
	
public newpolicy(login login, Display display) 
{
	back=new Command("back",Command.BACK,1);
	policy=new Form("NEW POLICIES");
	this.parent=login;
	this.dis=display;
	policy.append(new ImageItem("",baby,ImageItem.LAYOUT_CENTER,"thank you"));

	String sucticker= "HURRY UP  GET UR EDUCATION LOAN ***REVIEW YOUR LOMBARD MOTOR INSURANCE AT OUR BANK***TRANSFER FUNDSONLINE TO OTHER THAN PROJECT BANK ACCOUNTS TO MORE THAN 100 CITIES ACCROSS INDIA...ITS ABSOLUTELY FREE!!!!!!!" ;
	t=new Ticker(sucticker);
	policy.setTicker(t);
	policy.addCommand(back);
	dis.setCurrent(policy);
	policy.setCommandListener(this);
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

	public void commandAction(Command c, Displayable arg1) {
		if(c==back)
		{
			parent.display();
		}
			
		
		
	}

}
