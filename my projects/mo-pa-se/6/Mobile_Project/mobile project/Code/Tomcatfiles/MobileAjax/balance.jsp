<%@ page import="java.sql.*" %>
<%
Connection con=null;
Statement st=null; 
ResultSet rs=null;
ResultSet rs1=null;
int acc=0;
int id=0;
int balance=0;
String name="";
int accno=Integer.parseInt(request.getParameter("accno"));
String ListDetails="";
try
{

	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/mobileajax";
	con=DriverManager.getConnection(url,"root","root");
	st=con.createStatement();
	//java.sql.Statement st=con.createStatement();
	String sql="select * from accdetail where accno="+accno;
	System.out.println("SQL : "+sql);
	rs=st.executeQuery(sql);
	
	while(rs.next())
	{
		 acc=rs.getInt(1);
		 id=rs.getInt(2);
		 balance=rs.getInt(3);
	}
	
	String query="select name from registration as r,accdetail as a where r.accno="+accno+" and a.accno="+accno;
		rs1=st.executeQuery(query);
	while(rs1.next())
	{
		 name=rs1.getString(1);
		 
	}
	
	ListDetails="Acc No : "+acc+"# Name : "+name+"# Balance : "+balance+"#";
	out.println(ListDetails);
	
	System.out.println("accno---------- : "+ListDetails);
	System.out.println("id---------- : "+id);
	
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
