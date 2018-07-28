import java.io.IOException;

import javax.microedition.lcdui.*;
public class Quantity implements CommandListener{
	verification parent;
	Display dis;
	private Form dept;
	private TextField quantity;
	private Command ok,back;
	
	
	 public static String no="";
	 public static String name="";
	 public static String address="";
	 public static String mobno="";
	 public static String ccno="";
	 private static String amount="";
	 
	 Image qty=loadImage("/mobile.jpg");
	 
	
	public Quantity(verification v,Display display,String a)
	{
		amount=a;
		this.dis=display;
		this.parent =v;
		dept=new Form("Quantity");
		quantity=new TextField("Quantity","",10,TextField.NUMERIC);
		ok=new Command("continue",Command.OK,1);
		back=new Command("Back",Command.BACK,1);
		dept.append(quantity);
		dept.append(new ImageItem("",qty,ImageItem.LAYOUT_EXPAND,"thank you"));
		dept.addCommand(ok);
		dept.addCommand(back);
		dis.setCurrent(dept);
		dept.setCommandListener(this);
		
	}
	public void commandAction(Command c, Displayable arg1) {
	
		if(c==ok)
		{
			name=verification.name;
			address=verification.address;
			mobno=verification.mobno;
			ccno=verification.ccno;
			no=quantity.getString();
			Process gauge=new Process(this,dis,amount);
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
		dis.setCurrent(dept);
		
		
	}	
	
	public void shop() {
		parent.shop();
				
	}
   				

}
