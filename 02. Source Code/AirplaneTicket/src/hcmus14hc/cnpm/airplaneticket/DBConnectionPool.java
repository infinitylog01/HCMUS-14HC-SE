package hcmus14hc.cnpm.airplaneticket;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionPool {
	private DataSource dataSource;
	private Connection mysql_connection;
	
	public DBConnectionPool() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Connection openConnection() {
		try {
			if(mysql_connection == null || mysql_connection.isClosed())
				mysql_connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mysql_connection;
	}
	
	public void closeConnection() {
		try {
			if(mysql_connection != null && !mysql_connection.isClosed())
				mysql_connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
