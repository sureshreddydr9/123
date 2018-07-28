<%@ page import="java.sql.*" %>

<%	
	System.out.println("gan");
	Connection con=null;
	Statement st=null;
		
	ResultSet rs=null;
	
	
	String name=request.getParameter("name");
	String address=request.getParameter("address");
	
	String mobno=request.getParameter("mobno");
	int ccno=Integer.parseInt(request.getParameter("ccno"));

	
	
	
	
	
	try
	{
		System.out.println("su");
		
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/cart";
		
		System.out.println("SQL : "+url);
		con=DriverManager.getConnection(url,"root","root");
		st=con.createStatement();
	//java.sql.Statement st=con.createStatement();
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		try
		{
		String sql="insert into cart_billdetails(name,address,mobno,ccno) values('" + name + "','" + address + "','" + mobno + "', AES_ENCRYPT("+ccno+",'2') )";	
		System.out.println("sql"+sql);
		st.executeUpdate(sql);
	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	
	
	
%>