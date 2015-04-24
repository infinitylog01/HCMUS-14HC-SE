package hcmus14hc.cnpm.airplaneticket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebApp implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent ctx) {
		// When WebApp is about to shutdown
	}

	@Override
	public void contextInitialized(ServletContextEvent ctx) {
		// When WebApp is about to start/deployed
		DBConnectionPool.init();
//		Config.loadConfig();
	}

}
