import java.io.IOException;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;


public class checkrequest implements CommandListener{
	login parent;
	Display dis;
	private Form crequest,done;
	private TextField name,accno,acctype,bname,place;
	private Command ok,back,aback;
	String msg="your Request has Accepted. After 24 hrs you Collect your Check book from your Bank";
	Image img=loadImage("/check.jpg");
	public checkrequest(login login, Display display) {
		crequest=new Form("Check Book Request");
		done=new Form("Accept");
		this.dis=display;
		this.parent=login;
		ok=new Command("Request",Command.OK,1);
		back=new Command("Back",Command.BACK,1);
		aback=new Command("Back",Command.BACK,1);
		name=new TextField("Name","",10,TextField.ANY);
		accno=new TextField("Accno","",10,TextField.NUMERIC);
		acctype=new TextField("Acctype","",10,TextField.ANY);
		bname=new TextField("Branch Name","",10,TextField.ANY);
		place=new TextField("Location","",10,TextField.ANY);
		crequest.append(name);
		crequest.append(accno);
		crequest.append(acctype);
		crequest.append(bname);
		crequest.append(place);
		
		crequest.append(new ImageItem("",img,ImageItem.LAYOUT_CENTER,"thank you"));
		crequest.addCommand(ok);
		crequest.addCommand(back);
		dis.setCurrent(crequest);
		crequest.setCommandListener(this);
		
		
	}


	public void tryAgain()
		{
			Alert error = new Alert(" Incorrect","Please Give all the Fields", null, AlertType.ERROR);
			dis.setCurrent(error);
			error.getType().playSound(dis);
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
	if(c==ok)
	{

		if(name.getString().equals("")|| accno.getString().equals("") || acctype.getString().equals("") || bname.getString().equals("")  || place.getString().equals("") )
		{
			tryAgain();
		}
		else
		{
		System.out.println("------------------");
		done.append(msg);
		System.out.println("------------------");
		done.addCommand(aback);
		System.out.println("------------------");
		dis.setCurrent(done);
		done.setCommandListener(this);
			
		
		}
	}
	else if(c==back)
	{
		parent.display();
	}
	
	if(arg1==done)
	{
		if(c==aback)
		{
			parent.display();
		}
	}
	}

}
