package com.amdocs.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	List<Alien> aliens;
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/anant";
	String uname = "root";
	String pass = "root";

	public AlienRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {			
			System.out.println(e);
		}
		try {
			con = DriverManager.getConnection(url, uname, pass);
		} catch (Exception e) {
			System.out.println(e);
		}
	    	 
	} 		
	
	public List<Alien> getAliens()
	{
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from test_table";
		try
		{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			Alien a = new Alien();
			a.setPoints(rs.getInt(1));
			a.setName(rs.getString(2));
			aliens.add(a);
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		return aliens;
	}
	
	public Alien getAlien(int points) {
		
		String sql = "select * from test_table where roll_no = " + points;
		Alien a = new Alien();
		try
		{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next())
		{			
			a.setPoints(rs.getInt(1));
			a.setName(rs.getString(2));						
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		return a;
	}
	
	public Alien getAlien(String name) {
		for(Alien a : aliens)
		{
			if(a.getName().equals(name))
				return a;
		}
		return null;
	}

	public void createAlien(Alien a1) {
		aliens.add(a1);
		
	}
	
}
