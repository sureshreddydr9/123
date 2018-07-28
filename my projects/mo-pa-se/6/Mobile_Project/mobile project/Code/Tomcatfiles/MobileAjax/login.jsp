<%@ page import="java.sql.*" %>

<%
	Connection con=null;
	 Statement st=null; 
	ResultSet rs=null;
	ResultSet rs1=null;
	String strl="";
		String str2="";
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	String accno=request.getParameter("accno");
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mobileajax";
		con=DriverManager.getConnection(url,"root","root");
		st=con.createStatement();
		//java.sql.Statement st=con.createStatement();
		//String sql="select * from login where username='"+user+"' and password='"+pass+"'";
		String sql="select id from login  where username='"+user+"'and password='"+pass+"' ";
		System.out.println("SQL : "+sql);
		rs=st.executeQuery(sql);
		
		if (rs.next())
		{
			//strl+=rs.getString(2)+"#";
			strl=rs.getString(1);
		}
		String query="select * from registration where id="+strl+" and accno="+accno+"";
		rs1=st.executeQuery(query);
				System.out.println("SQL-----------> :"+query);

		if(rs1.next())
		{

			str2=rs1.getString(1);
		}
		
		
	
		
		out.println(str2);
		System.out.println("String User : "+strl);
		rs.close();
		st.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
%>