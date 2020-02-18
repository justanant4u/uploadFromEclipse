package com.amdocs.demorest;
import java.sql.*;

public class JDBCConnection {

	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/anant";
		String uname = "root";
		String pass = "root";
		String query = "select upper(name) as name from test_table where roll_no = 1";		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString("name");
		System.out.println(name);
		st.close();
		con.close();
		
	}
}
