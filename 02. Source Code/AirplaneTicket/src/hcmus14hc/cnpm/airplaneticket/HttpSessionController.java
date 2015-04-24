package hcmus14hc.cnpm.airplaneticket;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Help you know how many concurrent user there are. 
 * In other word, you want to track the active session.
 * @author Vinh
 *
 */
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
