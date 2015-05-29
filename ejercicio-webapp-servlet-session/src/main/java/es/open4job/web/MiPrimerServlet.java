package es.open4job.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * getParameter devuelve los parametros de http. Desde cliente a servidor (por
 * la url). Solo puede pasar String
 * 
 * Attribute es para el lado servidor. Defines el atributo en el servlet y lo
 * lees en el .jsp Puede enviar cualquier objeto
 * 
 * Guardo los parametros en session para que perduren. Con el request los datos
 * solo aguantan una llamada, luego se pierden
 * 
 */
public class MiPrimerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MiPrimerServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		// coge los parametros de la url
		int edad = Integer.parseInt(request.getParameter("edad"));
		String nombre = (request.getParameter("nombre"));

		// guardo los atributos en session
		session.setAttribute("edad", edad);
		session.setAttribute("nombre", nombre);

		request.getRequestDispatcher("mostrar_parametros.jsp").forward(request,
				response);
	}
}
