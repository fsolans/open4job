package es.open4job.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet básico.
 * Ejecutar as Server
 * 
 * Necesario tener el .WAR en el directorio WildFly-x.x/standalone/deployments
 * Introducir en el navegador /appServlet (por el web.xml)
 * 
 * @author ccano
 *
 */

public class MiPrimerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public MiPrimerServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Date date = new Date();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Servlet basico</h2>");
		
		out.println("Invocado a las " + date.toString()
				+ " desde la direccion : " + request.getRemoteAddr());
		
		out.println("</body>");
		out.println("</html>");
	}
}
