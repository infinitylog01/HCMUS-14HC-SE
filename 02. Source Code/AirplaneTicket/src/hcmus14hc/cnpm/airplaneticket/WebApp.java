package hcmus14hc.cnpm.airplaneticket;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebApp implements ServletContextListener{
	
	public static String DB_CONN = "mysql_connection";
	DBConnectionPool dbConn;

	@Override
	public void contextDestroyed(ServletContextEvent ctx) {
		// When WebApp is about to shutdown
		dbConn.closeConnection();
	}

	@Override
	public void contextInitialized(ServletContextEvent ctx) {
		// When WebApp is about to start/deployed
		dbConn = new DBConnectionPool();
		try {
			Config.loadConfig(dbConn.openConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
