package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection(); //Establish connection with database
			
			st = conn.createStatement(); //Creates statement to allow execution of SQL commands
			
			rs = st.executeQuery("SELECT * FROM department");//Fires SQL statement against the database
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getNString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//These objects do not belong to the JVM, close them
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
			
		}
		
	}

}
