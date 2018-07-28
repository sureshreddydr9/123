<%@ page import="java.sql.*, javax.sql.*,java.io.*,java.lang.*,java.text.SimpleDateFormat,java.util.Date,java.util.*" %>

<%
    Connection con=null;
    
	Statement st=null; 
	Statement st1=null; 
    
	ResultSet rs=null;
	ResultSet rs1=null;
	
	String prodname="";
	String shop="";
	
	String variety="";
	String company="";
	String Availability="";
		
	int proid=0;
	int shopid=0;
	
	prodname=request.getParameter("proName");
	shop=request.getParameter("shop");

	int cost=0;
	String listDetails="";
	
    try 
    {

    	Class.forName("com.mysql.jdbc.Driver");
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","root");
 
		st=con.createStatement();
		System.out.println("11 : "+prodname);
		System.out.println("1 1111: "+shop);
		
		String sql= "select proid,shopid from cart_avail_product where pro_name='"+prodname+"' and shopid="+shop;
		System.out.println("1 : "+sql);
		rs=st.executeQuery(sql);

		while(rs.next())
		{
			proid=rs.getInt(1);
			shopid=rs.getInt(2);
		}
		
		System.out.println("2 : "+proid);
		String query= "select cost,variety,company,Availability from  cart_productdetail where  proid="+proid+" and shopid="+shopid;
		
		System.out.println("3 : "+query);
		st1=con.createStatement();
		rs1=st1.executeQuery(query);
        System.out.println("4 : "+query);
		while(rs1.next())
		{
			cost=rs1.getInt(1);
			variety=rs1.getString(2);
			company=rs1.getString(3);
			Availability=rs1.getString(4);
		}
		listDetails="Price : "+cost+"# Variety : "+variety+"# Company : "+company+"# Availability : "+Availability+"#";
		System.out.println("Cost : "+listDetails);
		out.println(listDetails);
		
		
		rs.close();
		st.close();
		rs1.close();
		st1.close();
		con.close();
    }
    catch(Exception e)
    {
    	rs.close();
		st.close();
		rs1.close();
		st1.close();
		con.close();
    }
%>