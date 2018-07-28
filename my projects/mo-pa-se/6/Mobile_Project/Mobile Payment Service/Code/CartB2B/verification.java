import java.io.IOException;

import javax.microedition.lcdui.*;

public class verification implements CommandListener 
{
	private Form verform;
	public Command vok,venter;
	Display display;
	placeorder parent;
	
	 public static String name="";
	 public static String address="";
	 public static String mobno="";
	 public static String ccno="";
	 private static String amount="";
	 
	 Image verify=loadImage("/plus.jpg");
	 
	public verification(placeorder placeorder,Display dis,String amount1) {
		
		amount=amount1;
		this.parent=placeorder;
		this.display=dis;
		verform= new Form("Verification");
		vok=new Command("OK",Command.OK,1);
		venter=new Command("Enter",Command.BACK,2);
		String msg=" Once again Press ENTER key to verify.........if u need otherwise Press OK";
		System.out.println(msg);
		verform.append(msg);
		verform.append(new ImageItem("",verify,ImageItem.LAYOUT_EXPAND,"thank you"));
		verform.addCommand(vok);
		verform.addCommand(venter);
		dis.setCurrent(verform);
		verform.setCommandListener(this);
	}
	public void commandAction(Command c, Displayable s)
	{
		if(c == vok)
		{
			name=placeorder.name;
			address=placeorder.address;
			mobno=placeorder.mobno;
			ccno=placeorder.ccno;
			Quantity dep= new Quantity(this,display,amount);
		}
		else if(c == venter)
		{
		parent.show();
		}
		
		// TODO Auto-generated method stub
		
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
	
	void show()
	{
		display.setCurrent(verform);
	}
	
	public void shop() {
		parent.shop();
		
		
	}
   		
}
