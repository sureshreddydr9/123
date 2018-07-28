<%@ page import="java.sql.*, javax.sql.*,java.io.*,java.lang.*,java.text.SimpleDateFormat,java.util.Date,java.util.*" %>

<%
    Connection con=null;
    Statement st=null; 
    ResultSet rs=null;
	
	String quantity=request.getParameter("quantity");
	System.out.println("ID : "+quantity);
	

    try 
    {

    	Class.forName("com.mysql.jdbc.Driver");
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","root");
 
		st=con.createStatement();
		String sql="update cart_productdetail set  Availability=Availability - "+quantity+"  where prid="+id;
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