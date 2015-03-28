package hcmus14hc.cnpm.airplaneticket.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{

	/**
	 * being a Servlet chapter 4
	 */
	private static final long serialVersionUID = 9174297804683470435L;

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// we want browser recognize that this is JAR, not HTML
		resp.setContentType("application/jar");
		/**
		 * common MIME type:
		 * 
		 */
		
		ServletContext servletContext = getServletContext();
		InputStream is = servletContext.getResourceAsStream("/org.json.jar");
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		OutputStream os = resp.getOutputStream();
		while((read = is.read(bytes)) > 0) {
			os.write(bytes, 0 , read);
		}
		os.flush();
		os.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
