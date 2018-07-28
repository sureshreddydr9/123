import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Image;
import java.io.*;


public class MiniStatement implements CommandListener,Runnable{
	
	login parent;
	Display dis;
	String acc;
	String item[];
	public static String SpilitString[];
	List acclist;
	int counterLength = 0;
	
	public Command back = new Command("Back",Command.BACK,1);

	public MiniStatement(login login, Display display, String accno) {
		
		this.parent=login;
		this.dis=display;
		acc=accno;
		Thread t=new Thread(this);
   		t.start();
	}
	public void run() {
		
		StringBuffer sb =new StringBuffer();
		InputStream is=null;
		HttpConnection hc=null;
		
		//adding the options into the Screen
		try
		{
			long len=0;
			int ch=0;
			String url="http://localhost:8080/MobileAjax/ministatement.jsp?accno="+acc;
			System.out.println("URL : "+url);
			hc=(HttpConnection)Connector.open(url);
			System.out.println("hai : "+hc);
			is= hc.openInputStream();
			System.out.println("is : "+is);
			len=hc.getLength();
			System.out.println("length : "+len);
			if(len!=-1)
			{
				for(int i=0;i<len;i++)
				{
					if((ch=is.read())!=-1)
					{
						sb.append((char)ch);
						//System.out.println("sb:"+sb.toString());

					}
				}
			}
			String balList=sb.toString();
			
			
			if(balList.trim().equals("")){
				tryAgain();
				System.out.println("error entry");
				//dis.setCurrent(form2);
			}
			else{
			System.out.println("string from : "+balList);
			//System.out.println(balList);
			item=new String[balList.trim().length()];
			acclist = new List("Mini Statement",List.IMPLICIT);
			int index=balList.trim().indexOf("#");
			int delimiterCount=0;
			char[] proResult=balList.toCharArray();
			
			for (int i = 0; i < proResult.length; i++)
			{
				
				if(proResult[i]=='#')
				{
					delimiterCount++;
				}
			}
			System.out.println("Count : " + delimiterCount);
			if(index >= 0)
			{
				for(int i=0;i<delimiterCount;i++)
				{
					item[i]=balList.substring(0,balList.indexOf("#") );
					balList=balList.substring(balList.indexOf("#")+1);
					System.out.println("ITEM address :  "+item[i]);
					System.out.println("ITEM address :  "+balList);
					//String amt=item[0];
					//System.out.println("Amount :  "+ amt);
					//String dat=item[1];
					//System.out.println("date :  "+ dat);
					//acclist.append(item[i].trim(), null);
					
					
					
					
				}
				
						
			}
			HandsomeV(item);
			SetDisplay();
			String str1=sb.toString();
		System.out.println("User :"+str1.trim());



			if(str1.trim().equals("")){
				tryAgain();
				System.out.println("error entry");

			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e+"Exception In Menu");
			
	 	}
		finally
		{
			try
			{
				is.close();
				hc.close();
			}
			catch(Exception e)
			{}
		
	}
	}
	
	public void SetDisplay()
	{
		System.out.println(SpilitString.length);
		for(int i=0;i<(SpilitString.length/2);i++)
		{
			for(int j=(SpilitString.length/2)+1;j<SpilitString.length;j++)
			{
		String result="";
			try {
				
				
					result ="credit:"+ SpilitString[i].trim()+"date:"+SpilitString[j].trim();//+SpilitString[6].trim();
					
					System.out.println("Result : "+result);
					
				
				
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
			
	
		acclist.addCommand(back);
		acclist.setCommandListener(this);
		dis.setCurrent(acclist);
		
	}
	
	public void HandsomeV(String resultString[])
	{
		System.out.println("Handsome V Method -----"+resultString);
		
		String resultString1 = resultString[0];
		String resultString2 = resultString[1];
		
		String[] strings1 = getFamilyNumber(resultString1); 
		String[] strings2 = getFamilyNumber(resultString2); 
		
		for (int i = 0; i < strings2.length; i++) {
			System.out.println(strings1[i]+" ============================= "+strings2[i]);
			acclist.append("Credit : "+strings1[i].trim() + "  Date : "+strings2[i].trim() , null);
		}
		
		
		
		/*SpilitMessage spilitObj = new SpilitMessage();
		counterLength=spilitObj.mesLength(resultString);
		
		System.out.println("counter-----"+counterLength);
		SpilitString=new String[counterLength];
	
		for(int i=0;i<counterLength;i++)
		{
			
			SpilitString[i]=resultString.substring(0,resultString.indexOf("*") );
			resultString=resultString.substring(resultString.indexOf("*")+1);
			System.out.println("Spilt String : "+SpilitString[i]);
		}*/
		
	}
	
	public String[] getFamilyNumber(String resultString){
		SpilitMessage spilitObj = new SpilitMessage();
		counterLength=spilitObj.mesLength(resultString);
		
		System.out.println("counter-----"+counterLength);
		SpilitString=new String[counterLength];
	
		for(int i=0;i<counterLength;i++)
		{
			
			SpilitString[i]=resultString.substring(0,resultString.indexOf("*") );
			resultString=resultString.substring(resultString.indexOf("*")+1);
			System.out.println("Spilt String : "+SpilitString[i]);
		}
		return SpilitString;
	}
	
	public void tryAgain()
	{
		Alert error = new Alert(" Incorrect","Please try again", null, AlertType.ERROR);
		dis.setCurrent(error);
		error.getType().playSound(dis);
	}
	public void commandAction(Command c, Displayable arg1) {

	if(c==back)
	{
		parent.display();
	
	}
		

		
	}

	

}
