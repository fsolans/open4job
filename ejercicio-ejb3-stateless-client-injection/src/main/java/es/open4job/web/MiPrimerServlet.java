package es.open4job.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.open4job.ejb3.stateless.HelloWorld;

public class MiPrimerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/ejercicio-ejb3-stateless-client-injection/HelloWorldBean!es.open4job.ejb3.stateless.HelloWorld")
	HelloWorld bean;
	
	public MiPrimerServlet() {
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
