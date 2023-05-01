package com.demo.serviceImpl;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.dto.Bike;



public class BikeImpl{
	String username ="root";
	String password="Ag3484e@";
	String url = "jdbc:mysql://localhost/assignment";
	
	
	Bike bikeDto = new Bike();

		public void getAllBike() {
		try
		{
			String query = "select * from Bike";
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url, username, password);
			
		
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{		
				String bikeId = rs.getString(1);
				bikeDto.setBikeId(bikeId);
				String Name = rs.getString(2);
				bikeDto.setName(Name);;
				String email = rs.getString(3);
				bikeDto.setEmail(email);
				String address = rs.getString(4);
				bikeDto.setAddress(address);;
				String mobile = rs.getString(5);
				bikeDto.setMobile(mobile);;
				
				String newline = System.lineSeparator();
				
				System.out.printf(bikeId+" "+Name+" "+address+" "+email+" "+mobile+" "+newline);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
			}
		}
	
		
		public Bike getBikeById(String bikeId) {
			try
			{
				String query = "SELECT * FROM Bike WHERE contactId='"+bikeId+"'";
				Class.forName("com.mysql.jdbc.Driver");	
				Connection conn = DriverManager.getConnection(url, username, password);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);
					while(rs.next())
					{					
						
//						String contactId1 = rs.getString(1);
						bikeDto.setBikeId(bikeId);
						String Name = rs.getString(2);
						bikeDto.setName(Name);;
						String email = rs.getString(3);
						bikeDto.setEmail(email);
						String address = rs.getString(4);
						bikeDto.setAddress(address);;
						String mobile = rs.getString(5);
						bikeDto.setMobile(mobile);
						
						String newline = System.lineSeparator();
						
						System.out.printf(bikeId+" "+Name+" "+address+" "+email+" "+mobile+" "+newline);
					}
				
				
				rs.close();
				st.close();
				conn.close();
			}
			catch (ClassNotFoundException | SQLException e) {		
				e.printStackTrace();
			}
			return bikeDto;
		}
	
			
	
		public Bike addBike(Scanner input) throws SQLException {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			System.out.println("Enter Bike Details: ");
			System.out.println("Enter Bike ID: ");
			String id2 = input.next();
			System.out.println("Enter Bike Name: ");
			String name = input.next();
			System.out.println("Enter email: ");
			String email = input.next();
			System.out.println("Enter address: ");
			String address = input.next();
			System.out.println("Enter mobile number: ");
			String mobile = input.next();

	        // Display available service advisors
	        System.out.println("Available Service Advisors:");
	        ResultSet rs = stmt.executeQuery("SELECT * FROM service_advisors");
	        while (rs.next()) {
	            String id = rs.getString("empId");
	            String name1 = rs.getString("empName");
	            String email1 = rs.getString("email");
	            String address1 = rs.getString("address");
	            String mobile1 = rs.getString("mobile");
	            
	            System.out.printf("%s. %s %s %s %s\n", id, name1, email1,address1,mobile1);
	        }

	        // Prompt user to select a service advisor
	        String serviceAdvisorId;
	        do {
	            System.out.print("Enter Service Advisor ID: ");
	            serviceAdvisorId = input.next();
	            input.nextLine(); // Consume newline character

	            rs = stmt.executeQuery("SELECT * FROM Advisor WHERE id ='"+serviceAdvisorId+"'");
	            if (!rs.next()) {
	                System.out.println("Invalid Service Advisor ID.");
	            }
	        } while (!rs.next());

	        // Insert new bike into database
	        String sql = String.format("INSERT INTO Bike (bikeId, name, email, address, mobile, empId) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", id2,name, email, address, mobile, serviceAdvisorId);
	        stmt.executeUpdate(sql);

	        System.out.println("Bike added successfully.");
	    }
	
		
		public Bike delBike(String bikeId) {
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, username, password);
				String sql = "DELETE FROM Bike WHERE contactId=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, bikeId);
												 
				int i = ps.executeUpdate();
				if (i > 0) {
				    System.out.println("Data deleted successfully!");
				}
				else
					System.out.println("Failed to delete data..!");
				
				ps.close();
				conn.close();
				
			}catch (ClassNotFoundException | SQLException ex) {
		        ex.printStackTrace();
		    }
			return null;
			
		}


		@Override
		public Bike updateBike(String contactId, String address) {
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, username, password);
				String sql = "UPDATE Bike SET address= ?  WHERE contactId=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, address);
				ps.setString(2, contactId);
				
				
				//ps.setString(3, mobile);
								 
				int i = ps.executeUpdate();
				if (i > 0) {
				    System.out.println("An existing movie was updated successfully!");
				}
				else
					System.out.println("Failed to update data..!");
				
				ps.close();
				conn.close();
				
			}catch (ClassNotFoundException | SQLException ex) {
		        ex.printStackTrace();
		    }
			return null;
			
		}
}
