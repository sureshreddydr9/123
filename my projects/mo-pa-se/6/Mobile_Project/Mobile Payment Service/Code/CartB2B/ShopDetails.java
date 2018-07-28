import javax.microedition.lcdui.*;

public class ShopDetails implements CommandListener{

	login parentLogin;
	success parentsuccess;
	List Shoplist;
	Command list,back;
	Display display;
	
	
	public ShopDetails(login login, Display dis) {
		this.parentLogin=login;
	     this.display=dis;
	     detailsList();
    }    
	
	public ShopDetails(success success, Display dis) {
		this.parentsuccess=success;
	     this.display=dis;
	     detailsList();
    }   
	
	public void detailsList()
	{
		list=new Command("List",Command.OK,1);
		back=new Command("Back",Command.BACK,1);
		Shoplist = new List("Available List",List.IMPLICIT);
		Shoplist.append("saravana Stores --> 1001",null);
		Shoplist.append("GRT --> 1002",null);
		Shoplist.append("Jayachandran --> 1003",null);
		Shoplist.append("LifeStyle--> 1004",null);
		Shoplist.append("Pothys --> 1005",null);
		Shoplist.addCommand(list);
		Shoplist.addCommand(back);
		display.setCurrent(Shoplist);
		Shoplist.setCommandListener(this);
	}
	
	public void commandAction(Command c, Displayable dis) {

		if(c==list)
		{
			FileSharing fs=new FileSharing(this,display);
		}
		else if(c==back)
		{
			parentLogin.show();
		}
	}
	
	public void show() {
		display.setCurrent(Shoplist);
	
		
	}
	
	

}
