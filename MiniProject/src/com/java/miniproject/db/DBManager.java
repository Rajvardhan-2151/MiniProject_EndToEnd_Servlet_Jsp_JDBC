package com.java.miniproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

public class DBManager {

	private Connection connect = null;

	public DBManager() {

	}

	public Connection getConnect() {
		return connect;
	}

	public void openConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/mini_project_db";
			String name = "root";
			String pwd = "root";
			connect = DriverManager.getConnection(url, name, pwd);

			System.out.println("DB  Connection Success");

		} catch (SQLException | ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void closeConnecton() {

		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validateUser(User nuser)
	{
		//connect db 
		openConnection();
		//fire query
		try {
		String query = "SELECT * FROM USER_INFO_TBL WHERE USER_USERNAME='"+nuser.getUserName()+"' AND USER_PASSWORD= '"+nuser.getPassword()+"' ";  
	    Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		//validate  op
		
		if(rs.next())
		{
			nuser.setUserid(rs.getInt(1));
			nuser.setFname(rs.getString(2));
			nuser.setLname(rs.getString(3));
			nuser.setEmailID(rs.getString(4));
			nuser.setMobileNO(rs.getString(5));
			nuser.setUserName(rs.getString(6));
			nuser.setPassword(rs.getString(7));
			
			 return true;
			 
		}	 
		else
			 return false;
		
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally {
			// close connection;
			closeConnecton();
		}
		 return false;
	}
	
	public int createUser(User nuser)
	{
		openConnection();
		int temp = 0;
		
        try {
    		String query = "insert into user_info_tbl values(default ,? , ? , ?, ?, ?, ?)";
    		PreparedStatement pstmt = connect.prepareStatement(query);
    	
    		pstmt.setString(1, nuser.getFname());
    		pstmt.setString(2, nuser.getLname());
    		pstmt.setString(3, nuser.getEmailID());
    		pstmt.setString(4, nuser.getMobileNO());
    		pstmt.setString(5, nuser.getUserName());
    		pstmt.setString(6, nuser.getPassword());
           
            pstmt.executeUpdate();;
            
            return temp;
		} catch (SQLException e) {
			System.out.println(e);
		}
        finally {
        	closeConnecton();
		}
        return 0;
	}
	
	
	public void addHobby(Hobby hb)
	{
		openConnection();
		//fire query
		try {
		String query = "INSERT INTO HOBBY_TBL VALUES(DEFAULT , ? , ?)";  
	   
		PreparedStatement pstmt = connect.prepareStatement(query);
		
		
		pstmt.setInt(1, hb.getUser_Id());
		pstmt.setString(2, hb.getHobby());
		
		
		pstmt.executeUpdate();
		
		//validate  op
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally {
			// close connection;
			closeConnecton();
		}
		
	}
	
	
	
	public List<String> viewHobby(int id)
	{
		openConnection();
		
		List<String> list = new ArrayList<String>();
		
		
		String query = "SELECT * FROM HOBBY_TBL WHERE HOBBY_USERID=  ? ";
		
		try {
			PreparedStatement pstmt = connect.prepareStatement(query);
			System.out.println("User ID  :  "+id);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				list.add(rs.getString(3));
				System.out.println(rs.getString(3));
			}
			
			return list;
			
		} catch (SQLException e) {
		System.out.println(e);
		}
		
		
		return null;
	}
	
	
	/*public static void main(String[] args) {
		DBManager obj = new DBManager();
		boolean res = obj.validateUser("anil", "anil123");
		System.out.println(res);
	}*/

}
