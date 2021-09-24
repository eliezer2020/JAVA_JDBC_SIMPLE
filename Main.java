package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		/*sysout  dowload driver(jar) and add to buildpath  */
		System.out.println("Starting database conector ...");
		
		
		String db ="mi_empresa";
		String driver="jdbc:postgresql://localhost:5432/"+db;
		
		Connection conn =null;
		Statement stmt =null;
		
		
		
		
		try {
			//(String url, String user, String password
			conn = DriverManager.
				getConnection(driver,"postgres","xxxxx");
		
			stmt = conn.createStatement();
			selecAndPrinttAll(stmt,"departamentos");
		}catch(SQLException e) {
			System.out.println("conn fail");
			
		}finally {
			if(conn!=null) {
			finishConn(conn,stmt);
				
			}
		}
		
		
		
		
	
	}
	
	
	
	private static void selecAndPrinttAll(Statement stmt, String tabla) {
		try {
			ResultSet rs= stmt.executeQuery("SELECT * FROM public."+tabla);
			while(rs.next()) {
				//column name
				System.out.println(rs.getString("descripcion"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			
			
		}
		
	}



	public static void finishConn(Connection conn,Statement stmt) {
		try {
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
