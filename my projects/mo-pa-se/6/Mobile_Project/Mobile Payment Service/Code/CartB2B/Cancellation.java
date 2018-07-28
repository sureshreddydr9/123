import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;


public class Cancellation implements CommandListener {
	Process parent;
	Display dis;
	
	private Form cancel;
	public static String cname="";
	public static String creditcard="";
	private TextField name,ccno;
	private Command home=new Command("Home",Command.OK,1);
	private Command ok=new Command("Ok",Command.OK,1);
	private Command back=new Command("back",Command.BACK,1);
	private Ticker t;
	public Cancellation(Process process, Display display) {
		this.dis=display;
		this.parent=process;
		
		
		cancel=new Form ("Cancellation");
		name=new TextField("Name","",10,TextField.ANY);
		ccno=new TextField("Credit card No","",10,TextField.PASSWORD);
		 t=new Ticker("To cancel your bill plz give ur correct Name and Credit card Number that u give in Place order");
		cancel.setTicker(t);
		cancel.append(name);
		cancel.append(ccno);
		cancel.addCommand(home);
		cancel.addCommand(ok);
		cancel.addCommand(back);
		
		dis.setCurrent(cancel);	
		cancel.setCommandListener(this);
		}
	
	void shop()
	{
		parent.shop();
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
		else if(c==ok)
		{
			System.out.println("-------------------------------><--------");
			cname=name.getString();
			creditcard=ccno.getString();
			billcancel bill=new billcancel(this,dis);
			//Cancelticker ct=new Cancelticker(this,dis);
		}
		
	}

}
