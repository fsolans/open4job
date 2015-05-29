package es.open4job.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MiPrimerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MiPrimerServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// coge los parametros de la url
		int edad = Integer.parseInt(request.getParameter("edad"));
		String nombre = (request.getParameter("nombre"));

		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Servlet basico</h2>");

		out.println("<p>Hola " + nombre + ", tu edad es: " + edad + "</p>");

		out.println("</body>");
		out.println("</html>");
		
	}
}
