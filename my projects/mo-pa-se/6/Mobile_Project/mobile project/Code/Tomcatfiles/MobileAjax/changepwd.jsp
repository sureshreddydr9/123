
<%@ page import="java.sql.*" %>
<%
Connection con=null;
Statement st=null; 
ResultSet rs=null;

String name=request.getParameter("name");
String pass=request.getParameter("pass");
String newpass=request.getParameter("newpass");

try
{

	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/mobileajax";
	con=DriverManager.getConnection(url,"root","root");
	st=con.createStatement();
	String sql="update login set password='"+newpass+"' where username='"+ name+"' and password='"+pass+"'";
	System.out.print(sql);
	st.executeUpdate(sql);
	
		
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
