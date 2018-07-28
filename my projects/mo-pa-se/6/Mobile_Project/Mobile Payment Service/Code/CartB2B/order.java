import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;

public class order implements CommandListener {
	
	Display dis;
	productdetail parent;
	String msg="Do you want to purchase the product? Click OK to get your secret key (or) Go back to select some other product";
	private Form confirm;
	private Command ok,back;
	private static String price="";
	private static String amount="";
	Image searching=loadImage("/search.jpg");
	
	public order(Display dis, productdetail pdetails, String proprice){
		
		price=proprice;
		this.dis=dis;
		this.parent=pdetails;
		ok=new Command("ok",Command.OK,1);
		back=new Command("Back",Command.BACK,1);
		confirm=new Form("Confirm");
		confirm.append(msg);
		confirm.append(new ImageItem("",searching,ImageItem.LAYOUT_EXPAND,"thank you"));
		confirm.addCommand(ok);
		confirm.addCommand(back);
		dis.setCurrent(confirm);
		confirm.setCommandListener(this);
	}

	 {
		
		
	}

	public void commandAction(Command c, Displayable arg1) {
		
		if(c == ok)
		{
			amount=price;
			placeorder place=new placeorder(this,dis,amount);
		}
		else if(c==back)
		{
			parent.show();
		}
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
	public void show() {
		dis.setCurrent(confirm);
		
	}
	
	public void shop() {
		parent.shop();
		
		
	}
   		

}
