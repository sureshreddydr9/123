<%@ page import="java.sql.*, javax.sql.*,java.io.*,java.lang.*,java.text.SimpleDateFormat,java.util.Date,java.util.*" %>

<%
    Connection con=null;
    Statement st=null; 
    ResultSet rs=null;
	String id="";
	id=request.getParameter("shopid");
	System.out.println("ID : "+id);
	String product="";	


    try 
    {

    	Class.forName("com.mysql.jdbc.Driver");
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","root");
 
		st=con.createStatement();
		String sql="select * from  cart_avail_product where shopid="+id;
		rs=st.executeQuery(sql);

		while(rs.next())
		{
			product+=rs.getString("pro_name")+"#";
		}
		System.out.println("JSP : "+product);
		out.println(product);
		rs.close();
		st.close();
		con.close();
    }
    catch(Exception e)
    {
    	rs.close();
		st.close();
		con.close();
    }
%>