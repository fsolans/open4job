package es.open4job.ejercicio.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.open4job.ejercicio.model.vo.Alumno;

public class Principal {

	public static void main(String[] args) {
		
		Alumno alumnoNuevo = new Alumno();
		
		alumnoNuevo.setNombre("Francisco");
		alumnoNuevo.setApellido1("Solans");
		alumnoNuevo.setApellido2("Benedí");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("neodoo-jpa");	
		EntityManager em =  emf.createEntityManager();
		
		// Guardar alumno
		em.getTransaction().begin();
		    
		em.persist(alumnoNuevo);
		
		System.out.println("> Creado el objeto Alumno como una fila en la tabla alumno (INSERT). id = " + alumnoNuevo.getId());	// Devuelve el valor del autonumérico id
		
		em.getTransaction().commit();
		
		// Borrar alumno anterior
		em.getTransaction().begin();
		
		em.remove(alumnoNuevo);	// Es suficiente con tener un objeto con el id de la fila a borrar
		
		System.out.println("> Borrado el objeto Alumno de  la tabla alumno (DELETE). id = " + alumnoNuevo.getId());

		em.getTransaction().commit();
		
		// Listar alumnos
		em.getTransaction().begin();
		
		System.out.println("> Listado de alumnos (SELECT)");
		
		List<Alumno> alumnos = em.createQuery( "from Alumno", Alumno.class ).getResultList();
		for ( Alumno alumnoFila : alumnos ) {
		    System.out.println( "> Alumno (id = " + alumnoFila.getId() + ", nombre = " + alumnoFila.getNombre() + ", apellido1 = " + alumnoFila.getApellido1() + ", apellido2 = " +
		    		alumnoFila.getApellido2() + ")");
		}
		
		em.getTransaction().commit();
		
		em.close();
		
	}
}
