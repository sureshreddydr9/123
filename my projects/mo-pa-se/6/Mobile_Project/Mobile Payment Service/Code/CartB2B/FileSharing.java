


import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import javax.microedition.lcdui.Image;
import java.io.IOException;


public class FileSharing implements CommandListener
{
	public static String shopID="";//to get the value of shop id in searchform
	
  	private Display display;//Display object
  		/*
  	 * Form Objects
  	 */
  	
  	private Form userForm;
	private Form searchForm;
	private Alert alHelp;
	private Alert a;
	
	/*
	 * Commend Buttons
     */
	
	private Command search=new Command("Search",Command.SCREEN,1);
	private Command help=new Command("Help",Command.HELP,1);
	private Command fback=new Command("Back",Command.BACK,1);
	private Command ok=new Command("Search",Command.OK,1);
	private Command back=new Command("BACK",Command.BACK,1);
	
	
	private TextField searchShop=new TextField("Shop ID","",10,TextField.NUMERIC);
	
	
	private String str="";

  	public StringBuffer sb = new StringBuffer();

  	
  	Image building=loadImage("/b.png");
  	Image searchimg=loadImage("/insert.jpg");
  	/*
	 * constructor
	 */
  	
  	
  	ShopDetails parent;
  	public FileSharing(ShopDetails details, Display dis)
  	{
  		this.parent=details;
  		this.display=dis;
		
    	userForm = new Form("File Sharing");
    	userForm.append(new ImageItem("",building,ImageItem.LAYOUT_EXPAND,"thank you"));
		searchForm=new Form("Search Shop");

		userForm.addCommand(fback);
    	userForm.addCommand(search);
    	userForm.addCommand(help);
		
    	
    	searchForm.append(searchShop);
    	searchForm.append(new ImageItem("",searchimg,ImageItem.LAYOUT_EXPAND,"thank you"));
    	searchForm.addCommand(back);
		searchForm.addCommand(ok);
    	
		
       
        dis.setCurrent(userForm);
        userForm.setCommandListener(this);
        
    	searchForm.setCommandListener(this);
    	
        
 	}
		


	
	//to load the image
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

	

	 private String readmsg()
	 {
		InputStream is = getClass().getResourceAsStream("/help.txt");
		try
		{
			int chr;
		    // Read until the end of the stream
		    while ((chr = is.read()) != -1)
		    {
			    sb.append((char) chr);
			}
			return sb.toString();
		}
		catch (Exception e)
		{
		    System.out.println("Unable to create stream");
		}
	   	return null;
	 }
	 
	 
	   	public void commandAction(Command command, Displayable s)
  	{

    	if(command == search)
    	{
    		
    		display.setCurrent(searchForm);
    	}
    	else if(command == fback)
    	{
    		
    		parent.show();
    	}

    	else if(command==help)
   		{
    		help help=new help(this,display);
   			/*if ((str = readmsg()) != null)
			{
				alHelp = new Alert("Help",str,null,null);
   				alHelp = new Alert("Help",str,null,null);
	 		    alHelp.setTimeout(Alert.FOREVER);
				display.setCurrent(alHelp, userForm);
		   	}*/
		}
    	
    	
    	
     	/*else if(command == exit)
    	{
			parent.show();
		}
    	*/
    	
    	
		if(s==searchForm)
		{
			if(command == ok)
			{
					
				shopID=searchShop.getString();
				
				/*if(shopID.equals("")){
					Alert a=new Alert("ERROR","Invalid ID",null);
					display.setCurrent(a, userForm);
				}*/
				
				if(shopID.equals(""))
				{}
				
				else
				{
					System.out.println("ID : "+shopID);
					searchID searchid = new searchID(this,display); 
				}

		}
			
			
			else if(command == back )
			{
				
				display.setCurrent(userForm);
			}
		}
  	}





			


	
	
	void show()
	{
		display.setCurrent(searchForm);
	}
	
	

	public void shop() {
		parent.show();
		
		
	}
}



	

