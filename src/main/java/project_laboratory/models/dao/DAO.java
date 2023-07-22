package project_laboratory.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/labstorage?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234567";
	
	public Connection connect() throws SQLException {
		
		Connection connection = null;
		
		try {
			Class.forName(driver); //load driver
			
			connection = DriverManager.
					getConnection
					(url, user, password);
			
			return connection;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
