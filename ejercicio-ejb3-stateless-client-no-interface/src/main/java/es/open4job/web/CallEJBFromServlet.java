package es.open4job.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.open4job.ejb3.stateless.HelloWorldBean;

public class CallEJBFromServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	HelloWorldBean bean;

	/*
	java:global/ejercicio-ejb3-stateless-client-no-interface/HelloWorldBean!es.open4job.ejb3.stateless.HelloWorldBean
	java:app/ejercicio-ejb3-stateless-client-no-interface/HelloWorldBean!es.open4job.ejb3.stateless.HelloWorldBean
	java:module/HelloWorldBean!es.open4job.ejb3.stateless.HelloWorldBean
	java:global/ejercicio-ejb3-stateless-client-no-interface/HelloWorldBean
	java:app/ejercicio-ejb3-stateless-client-no-interface/HelloWorldBean
	java:module/HelloWorldBean
	 */
	
	// EJB3.1 look up naming convention
	// @EJB(mappedName = “ejb:/HelloWorldSessionBean//HelloWorldBean!com.theopentutorials.business.HelloWorld”)
	// @EJB(mappedName = “java:global/HelloWorldSessionBean/HelloWorldBean”)
	
	public CallEJBFromServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html><body><h2>Servlet b&aacute;sico llamando a EJB3 (SLSB)</h2>");
		
		out.println(bean.sayHello());

		out.println("</body></html>");

	}

}
