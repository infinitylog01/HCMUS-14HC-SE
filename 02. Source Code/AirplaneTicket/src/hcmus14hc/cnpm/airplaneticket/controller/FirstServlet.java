package hcmus14hc.cnpm.airplaneticket.controller;

import hcmus14hc.cnpm.airplaneticket.model.DumpColorModel;
import hcmus14hc.cnpm.airplaneticket.pojo.Colors;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	/**
	 * mini MVC chapter 3
	 */
	private static final long serialVersionUID = 5060756860694342895L;
	
	/**
	 * do not write your own constructor, use this function instead
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	/**
	 * control http-get request
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	/**
	 * control http-post request
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		super.doPost(req, resp);
		// get the request parameters
		String selectColor = req.getParameter("colors");
		DumpColorModel dao = new DumpColorModel();
		Colors colorRs = dao.colorCode(selectColor);
		// add an attribute to the request object for JSP to use. (see result.jsp)
		req.setAttribute("color_code", colorRs);
		
		// instance request dispatcher for the JSP.
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		// use RD to ask the Container to crank up the JSP, sending it request & response. 
		view.forward(req, resp);
	}

}
