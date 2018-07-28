import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;


public class MoneyTransferDesign implements CommandListener{
	login parent;
	Display dis;
	private Form mt;
	//private TextField sender=new TextField("SENDER","",10,TextField.ANY) ;
   	private TextField receiver=new TextField("RECEIVER Accno","",10,TextField.ANY) ;
	private TextField amount=new TextField("AMOUNT","",10,TextField.ANY) ;
	
   	private Command mtok= new Command("Transfer",Command.OK,1);
   	private Command mtback=new Command("Back",Command.BACK,1);
   	public static String  send="",receive="", money="";
   
   
	public MoneyTransferDesign(login login, Display display)
	{
		Image img=loadImage("/money.jpg");
		this.dis=display;
		this.parent=login;
		mt=new Form("MONEY TRANSFER");
		//mt.append(sender);
		mt.append(receiver);
		mt.append(amount);
		mt.append(new ImageItem("",img,ImageItem.LAYOUT_CENTER,"thank you"));
		mt.addCommand(mtok);
		mt.addCommand(mtback);
		dis.setCurrent(mt);
		mt.setCommandListener(this);
}		

	public void commandAction(Command c, Displayable arg1) {
		if(c==mtok)
		{
			//send=sender.getString();
			receive=receiver.getString();
			money=amount.getString();
			
			
			moneyTransfer mt=new moneyTransfer(this,dis,send,receive,money);
		}
		else if(c==mtback)
		{
			System.out.print("Hai Handsome");
			parent.display();
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
	
	void show()
	{
		dis.setCurrent(mt);
	}
}
