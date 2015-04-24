package hcmus14hc.cnpm.airplaneticket;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionPool {
	private static DBConnectionPool mInstance;
	private static DataSource dataSource;
	
	static void init() {
		if(mInstance == null) {
			mInstance = new DBConnectionPool();
		}
	}
	
	private DBConnectionPool() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection openConnection() {
		Connection mysql_connection = null;
		try {
			mysql_connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mysql_connection;
	}
	
	public static void closeConnection(Connection mysql_connection) {
		try {
			if(mysql_connection != null && !mysql_connection.isClosed())
				mysql_connection.close();
			else
				System.out.println("db connection null");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
