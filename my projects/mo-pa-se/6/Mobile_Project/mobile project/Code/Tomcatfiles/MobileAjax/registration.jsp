<%@ page import="java.sql.*" %>

<%	
	
	Connection con=null;
	Statement st=null;
	Statement st1=null;
	
	ResultSet rs=null;
	ResultSet rs1=null;
	
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	
	String name=request.getParameter("name");
	String fname=request.getParameter("fname");
	
	int age=Integer.parseInt(request.getParameter("age"));
	String date_birth=request.getParameter("dob");
	
	String date[]=date_birth.split("-");
	for(int i=0;i<date.length;i++)
	System.out.println("date : "+date[i]);
	String dob=date[2]+"-"+date[1]+"-"+date[0];
	
	
	String sex=request.getParameter("sex");
	
	String education=request.getParameter("education");
	String occupation=request.getParameter("occupation");
	
	String phoneno=request.getParameter("phone");
	String aincome=request.getParameter("aincome");
	
	String address=request.getParameter("address");
	String city=request.getParameter("city");
	String email=request.getParameter("email");
	int intdeposit=Integer.parseInt(request.getParameter("intdeposit"));
	
	int id=0;
	int accno=0;
	
	try
	{
		System.out.println("su");
		
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mobileajax";
		System.out.println("gan");
		System.out.println("SQL : "+url);
		con=DriverManager.getConnection(url,"root","root");
		st=con.createStatement();
		st1=con.createStatement();
		//java.sql.Statement st=con.createStatement();
		System.out.println("user"+user);

		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		try
		{
		String sql="insert into login(username,password,regdate) values('" + user + "','" + pass + "',current_date)";	
		System.out.println("sql"+sql);
		st.executeUpdate(sql);
		System.out.println("hai");
		
		String query="select id from login where username='"+user+"' and password='"+pass+"'";
		rs=st.executeQuery(query);
		System.out.println("query"+query);
		if(rs.next())
		{
			id=rs.getInt(1);
		}
		System.out.println("id ------------- "+id);
		rs.close();
	
	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	
	try
	{
		
		String insert="insert into registration (id,name,fname,age,dob,sex,education,occupation,aincome,address,city,phoneno,email) values (" +id+ ",'"+name+"', '" + fname +"',"+ age +",'"+ dob +"','"+ sex +"','"+ education +"','" + occupation + "','"+aincome+"','"+address+"','" + city + "','"+phoneno+"','"+email+"')";
		
		
		System.out.println("insert "+insert);
		st.executeUpdate(insert);
		
		
		String query1="SELECT accno from registration as r,login as l where l.id="+id+" and r.id="+id;
		rs1=st.executeQuery(query1);
	
		if(rs1.next())
		{
			accno=rs1.getInt(1);
		}
	
	
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	try
	{
		System.out.println("accno ------------- "+accno);
		String depinsert="insert into accdetail (accno,id,intdeposit) values ("+accno+","+id+","+intdeposit+")";
		st.executeUpdate(depinsert);
		System.out.println("inserted successfully");
		
		String deposit="insert into deposit (id,accno,deposit,depositdate) values ("+id+","+accno+","+intdeposit+",current_date)";
		st1.executeUpdate(deposit);
		
		
		System.out.println("inserted completed in deposit");
		st.close();
		st1.close();
		
		con.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();	
		
		st.close();
		
		con.close();
	}
%>