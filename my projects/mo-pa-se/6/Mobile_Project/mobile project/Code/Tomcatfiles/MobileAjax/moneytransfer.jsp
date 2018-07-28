
<%@ page import="java.sql.*" %>
<%
Connection con=null;
Statement st=null; 
Statement st1=null; 
Statement st2=null; 
Statement st3=null; 
Statement st4=null; 
Statement st5=null; 
Statement st6=null; 

ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
int sender=Integer.parseInt(request.getParameter("sender"));
int receiver=Integer.parseInt(request.getParameter("receiver"));
int amount=Integer.parseInt(request.getParameter("amount"));
int balance=0;
int balance1=0;
int id=0;
int rid=0;

try
{

	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/mobileajax";
	con=DriverManager.getConnection(url,"root","root");
	st=con.createStatement();
	st1=con.createStatement();
	st2=con.createStatement();
	st3=con.createStatement();
	st4=con.createStatement();
	st5=con.createStatement();
	st5=con.createStatement();
	st6=con.createStatement();
	//java.sql.Statement st=con.createStatement();
	String sql="select intdeposit from accdetail where accno="+sender;
	
	System.out.println("SQL : "+sql);
		
	rs=st.executeQuery(sql);
		
	while(rs.next())
	{
	
		 balance=rs.getInt(1);
		 
	}

	if(amount<=balance)
	{
	if(balance>=1000)
	{

	
String receiversql="select intdeposit from accdetail where accno="+receiver;
rs3=st6.executeQuery(receiversql);
while(rs3.next())
	{
	
		 balance1=rs3.getInt(1);
		 
	}
	
	String query="update accdetail set intdeposit="+balance+"-"+amount+ " where accno="+sender;
		System.out.println("haihai : "+query);
	String query1="update accdetail set intdeposit="+balance1+"+"+amount+ " where accno="+receiver;
		System.out.println("----------------------------- "+query1);
	
	String query2="select id from registration where accno="+sender;
	System.out.println("SQL : "+sql);
	rs2=st3.executeQuery(query2);
	System.out.println("SQL :===================================================== ");
	while(rs2.next())
	{
		 id=rs2.getInt(1);
		 
	}
	
	String query6="select id from registration where accno="+receiver;
	System.out.println("query6"+query6);
	rs1=st5.executeQuery(query6);
	System.out.println("________________________>");
	while(rs1.next())
	{
		 rid=rs1.getInt(1);
		 
	}

	
	String query3="insert into deposit(id,accno,deposit,depositdate)values("+id+","+sender+","+amount+",current_date)";
	String query4="insert into credit(id,accno,credit,cdate)values("+id+","+receiver+","+amount+",current_date)";
	String query5="insert into debit(id,accno,debit,ddate)values("+rid+","+sender+","+amount+",current_date)";
	System.out.println("query3 : "+query3);
	int h=st1.executeUpdate(query);
		
	System.out.println("id***************** : "+rid);
	int i=st.executeUpdate(query1);
		
	System.out.println("i***************** : "+i);
	int j=st2.executeUpdate(query3);
		
	System.out.println("j***************** : "+j);
	int k=st4.executeUpdate(query4);
		
	System.out.println("k***************** : "+k);
	int l=st5.executeUpdate(query5);
		
	System.out.println("l***************** : "+l);
	out.print(balance);
	
	}

	else
	{
		out.print("");
	}



}
	
	
else
{
out.print("");
}
	
		
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
