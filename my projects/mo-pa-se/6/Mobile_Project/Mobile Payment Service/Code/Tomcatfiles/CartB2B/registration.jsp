<%@ page import="java.sql.*" %>

<%	System.out.println("11111 : ");
	Connection con=null;
	Statement st=null; 
	String strl="";
	System.out.println("SQL : ");
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	String address=request.getParameter("address");
	String phoneno=request.getParameter("phone");
	String email=request.getParameter("email");

	
	try
	{
	
		
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/cart";
		con=DriverManager.getConnection(url,"root","root");
		st=con.createStatement();
		//java.sql.Statement st=con.createStatement();
		System.out.println("user"+user);
			System.out.println("insert into  cart_login(username,password,address,phone,email) values('" + user + "',AES_ENCRYPT('"+pass+"','2') ,'" + address + "','" + phoneno +"','" + email + "')");
		st.executeUpdate("insert into  cart_login(username,password,address,phone,email) values('" + user + "',AES_ENCRYPT('"+pass+"','2'),'" + address + "','" + phoneno +"','" + email + "')");
		
		
	

		
		st.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
%>