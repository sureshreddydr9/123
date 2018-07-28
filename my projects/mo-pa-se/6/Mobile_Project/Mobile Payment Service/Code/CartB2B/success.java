import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Ticker;


public class success implements CommandListener{
	Display dis;
	Process parent;
	FileSharing cart;
	private Ticker t;
	private Form success;
	private Command home,back;
	Image Thanks=loadImage("/thanks.jpg");
	
	public success(Process process, Display display) {
		this.dis=display;
		this.parent=process;
			success=new Form("SuccessFully Finished");	
			t=new Ticker("Thanks For Purchasing .........Visit again........");
			success.setTicker(t);
			home=new Command("Home",Command.OK,1);
			back=new Command("Back",Command.BACK,1);
			success.append(new ImageItem("",Thanks,ImageItem.LAYOUT_EXPAND,"thank you"));
			success.addCommand(home);
			success.addCommand(back);
			dis.setCurrent(success);
			success.setCommandListener(this);
			
		
		
		
		
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
		
		if(c==home)
		{
			parent.shop();
		}
		
		else if(c==back)
		{
			parent.show();
		}
		
		
	}
	

}
