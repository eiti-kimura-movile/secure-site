package com.movile.project.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger("system");
	private Properties properties;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		
		super();
		
		try {
			properties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader(); 
			InputStream in = loader.getResourceAsStream("security.properties");
			properties.load(in);
			in.close();
			log.info("Load property file");
		} catch (IOException e) {
			log.error("Error loading properties", e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String logoutUrl = properties.getProperty("security.cas.service.logout.url");
		
		request.getSession().invalidate();
		SecurityContextHolder.clearContext();
		response.sendRedirect(logoutUrl);
	}
}
