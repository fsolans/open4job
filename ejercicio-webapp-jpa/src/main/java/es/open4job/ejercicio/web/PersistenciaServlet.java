package es.open4job.ejercicio.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.open4job.ejercicio.model.vo.Alumno;

public class PersistenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersistenciaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletOutputStream out = response.getOutputStream();
		
		Alumno alumnoNuevo = new Alumno();
		
		alumnoNuevo.setNombre("Francisco");
		alumnoNuevo.setApellido1("Solans");
		alumnoNuevo.setApellido2("Benedí");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("neodoo-jpa");	
		EntityManager em =  emf.createEntityManager();
		
		// Guardar alumno
		em.getTransaction().begin();
		    
		em.persist(alumnoNuevo);
		
		out.println("<h3>Creado el objeto Alumno como una fila en la tabla alumno (INSERT). id = " + alumnoNuevo.getId() + "</h3><br />");	// Devuelve el valor del autonumérico id
		
		em.getTransaction().commit();
		
		// Borrar alumno anterior
		em.getTransaction().begin();
		
		em.remove(alumnoNuevo);	// Es suficiente con tener un objeto con el id de la fila a borrar
		
		out.println("<h3>Borrado el objeto Alumno de  la tabla alumno (DELETE). id = " + alumnoNuevo.getId() + "</h3><br />");

		em.getTransaction().commit();
		
		// Listar alumnos
		em.getTransaction().begin();
		
		out.println("<h3>Listado de alumnos (SELECT)</h3><br />");
		
		List<Alumno> alumnos = em.createQuery( "from Alumno" ).getResultList();
		for ( Alumno alumnoFila : alumnos ) {
		    out.println( "<h3>Alumno (id = " + alumnoFila.getId() + ", nombre = " + alumnoFila.getNombre() + ", apellido1 = " + alumnoFila.getApellido1() + ", apellido2 = " +
		    		alumnoFila.getApellido2() + ")</h3><br />");
		}
		
		em.getTransaction().commit();
		
		em.close();
		
	}


}
