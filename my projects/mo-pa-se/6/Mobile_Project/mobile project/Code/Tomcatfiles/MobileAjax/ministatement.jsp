<%@ page import="java.sql.*" %>
<%
Connection con=null;
Statement st=null; 
Statement st1=null; 
ResultSet rs=null;
ResultSet rs1=null;
int cid=0;
String credit="";
String debit="";
String name="";
String cdate="";
String ddate="";
int accno=Integer.parseInt(request.getParameter("accno"));
String AccDetails="";
try
{

	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/mobileajax";
	con=DriverManager.getConnection(url,"root","root");
	st=con.createStatement();
	st1=con.createStatement();
	//java.sql.Statement st=con.createStatement();
	String sql="select credit,cdate from credit where accno="+accno+" LIMIT 5";
	String sql1="select debit,ddate from debit where accno="+accno;
	System.out.println("SQL : "+sql);
	System.out.println("SQL1--------> : "+sql1);
	rs=st.executeQuery(sql);
	
	while(rs.next())
	{
		
		 credit+=rs.getInt(1)+"*";
		 cdate+=rs.getString(2)+"*";
	

	}
	System.out.print("credit.........>"+credit);
			AccDetails=""+credit+"#"+cdate+"#"; 
	System.out.print("AccDetails.........>"+AccDetails);
		out.println(AccDetails);
	
	
	
}
catch(Exception e)
{
	e.printStackTrace();
}
%>