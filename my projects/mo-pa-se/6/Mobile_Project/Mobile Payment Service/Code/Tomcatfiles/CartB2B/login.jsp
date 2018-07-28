<%@ page import="java.sql.*" %>

<%
	Connection con=null;
	Statement st=null; 
	ResultSet rs=null;
	String strl="";
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	
	try
	{
	
		
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/cart";
		con=DriverManager.getConnection(url,"root","root");
		st=con.createStatement();
		//java.sql.Statement st=con.createStatement();
		//String sql="select * from cart_login where username='"+user+"' and password=AES_DECRYPT('"+pass+"','2')";
		String sql="select username,AES_DECRYPT(password,'2') from cart_login where username='"+user+"' and password=AES_ENCRYPT('"+pass+"','2')";
		System.out.println("user"+user);
		System.out.println("SQL : "+sql);
		rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			//strl+=rs.getString(2)+"#";
			strl=rs.getString(2);
		}
		
		out.println(strl);

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
