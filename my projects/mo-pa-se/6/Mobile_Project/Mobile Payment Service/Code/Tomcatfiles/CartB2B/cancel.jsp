<%@ page import="java.sql.*, javax.sql.*,java.io.*,java.lang.*,java.text.SimpleDateFormat,java.util.Date,java.util.*" %>

<%


    Connection con=null;
    Statement st=null; 
    ResultSet rs=null;
	String cname=request.getParameter("name");
	int ccno=Integer.parseInt(request.getParameter("ccno"));


    try 
    {

    	Class.forName("com.mysql.jdbc.Driver");
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","root");
 
		st=con.createStatement();
		String sql="Delete * from  cart_billdetails where name='"+cname+"' and ccno=AES_ENCRYPT('"+ccno+"','2')";
		System.out.print("Cancelled Successfully"+sql);
		int i=st.executeUpdate(sql);
		
		out.println(i);
		
		}
    catch(Exception e)
    {
		
    	out.println("");
		st.close();
		con.close();
    }
%>