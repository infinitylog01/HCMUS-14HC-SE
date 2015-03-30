package hcmus14hc.cnpm.airplaneticket;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionController implements HttpSessionListener{

	int userCount = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent evt) {
		// TODO count user for example
		evt.getSession().getServletContext().setAttribute("userCounter", ++userCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		// TODO count user for example
		evt.getSession().getServletContext().setAttribute("userCounter", --userCount);
	}

}
