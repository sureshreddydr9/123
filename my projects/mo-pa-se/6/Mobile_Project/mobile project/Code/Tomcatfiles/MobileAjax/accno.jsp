<%@ page import="java.sql.*" %>
<%
Connection con=null;
Statement st=null; 
ResultSet rs=null;
	String acc="";
String name=request.getParameter("username");

try
{

	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/mobileajax";
	con=DriverManager.getConnection(url,"root","root");
	st=con.createStatement();
	String sql="select accno from registration where name='"+name+"'";
	System.out.println("SQL : "+sql);
	rs=st.executeQuery(sql);
	System.out.println("Raja ");
	while(rs.next())
	{
	 acc=rs.getString(1);
		 
	}
	System.out.print("acc"+acc);
	out.println(acc);
	
	}
catch(Exception e)
{
	e.printStackTrace();
}
%>
