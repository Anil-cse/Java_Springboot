package com.demo.serviceImpl;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.connection.MySqlConnection;
import com.demo.dto.student;
import com.demo.service.StudentDao;

public class StudentImpl implements StudentDao {
	
	Scanner sc = new Scanner(System.in);
	
	student stu = new student();
	
	@Override
	public student addStudent(student stu) {
		try {
			Connection conn = null;
			conn = MySqlConnection.getConnection();
	       // PreparedStatement ps = conn.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?)");
			String query = "INSERT INTO student VALUES (?, ?, ?, ?)";
			CallableStatement ps = conn.prepareCall(query);
	       ps.setString(1, stu.getStudentId());
	       ps.setString(2, stu.getStudentName());
	       ps.setString(3, stu.getStudentAddress());
	       ps.setString(4, stu.getEmail());
	      int i =  ps.executeUpdate();
	      if(i > 0) {
	    	  System.out.println(" added successfully...!");		      	     
	      }
	      else
	    	  System.out.println("Failed to add a record........!");
	      ps.close();
	      conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return stu;
	}




	@Override
	public void getAllStudent() {
		
		try
		{
			Connection conn = null;
			conn = MySqlConnection.getConnection();
			
			//String query = "select * from student";
			String sql = "call retreive_users()";
		
			
			CallableStatement ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{		
				String studentId = rs.getString(1);
				stu.setStudentId(studentId);
				String studentName = rs.getString(2);
				stu.setStudentName(studentName);
				String address = rs.getString(3);
				stu.setStudentAddress(address);
				String email = rs.getString(4);
				stu.setEmail(email);
				
				
				String newline = System.lineSeparator();
				
				System.out.printf(studentId+" "+studentName+" "+address+" "+email+" "+newline);
			}
			
			rs.close();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {		
			e.printStackTrace();
			}
		
	}




	@Override
	public student getStudentById() {

		try
		{
			Connection conn = null;
			conn = MySqlConnection.getConnection();
			
			String query = "select * from student where studentId=?";
			CallableStatement st = conn.prepareCall(query);
//			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("enter student id");
	        String studentId1 = sc.next();
	        st.setString(1, studentId1);
			ResultSet rs = st.executeQuery();
				while(rs.next())
				{					
					
					String studentId2 = rs.getString(1);
					stu.setStudentId(studentId2);
					String studentName = rs.getString(2);
					stu.setStudentName(studentName);
					String address = rs.getString(3);
					stu.setStudentAddress(address);
					String email = rs.getString(4);
					stu.setEmail(email);
					
					
					String newline = System.lineSeparator();
					
					System.out.printf(studentId2+" "+studentName+" "+address+" "+email+" "+newline);
				}
			
			
			rs.close();
			st.close();
			conn.close();
		}
		catch (SQLException e) {		
			e.printStackTrace();
		}
		return stu;
	}




	@Override
	public student delStudent(String studentId) {

		try
		{
			Connection conn = null;
			conn = MySqlConnection.getConnection();
			String sql = "DELETE FROM student WHERE studentId=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, studentId);
											 
			int i = ps.executeUpdate();
			if (i > 0) {
			    System.out.println("Data deleted successfully!");
			}
			else
				System.out.println("Failed to delete data..!");
			
			ps.close();
			conn.close();
			
		}catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		return null;
		
	}




	@Override
	public student updateStudent(String studentId, String studentAddress) {

		try
		{
			Connection conn = null;
			conn = MySqlConnection.getConnection();
			String sql = "UPDATE student SET studentAddress= ? WHERE studentId = ? ";
//			PreparedStatement ps = conn.prepareStatement(sql);
			CallableStatement ps = conn.prepareCall(sql);
			
			
			ps.setString(1, studentAddress);
			
			
			ps.setString(2, studentId);
							 
			int i = ps.executeUpdate();
			if (i > 0) {
			    System.out.println("An existing data was updated successfully!");
			}
			else
				System.out.println("Failed to update data..!");
			
			ps.close();
			conn.close();
			
		}catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		return null;
		
	}
	
	
	
	

		
}
