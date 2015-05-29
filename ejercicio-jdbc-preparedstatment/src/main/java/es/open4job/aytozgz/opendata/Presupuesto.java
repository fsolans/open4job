package es.open4job.aytozgz.opendata;

import java.util.Iterator;
import java.util.List;
import es.open4job.aytozgz.opendata.model.dao.presupuesto.IngresoCorrienteDAO;
import es.open4job.aytozgz.opendata.model.vo.presupuesto.IngresoCorrienteVO;

public class Presupuesto {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String HOST = "127.0.0.1";
	private static final String NOMBRE_BD = "open4job";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://" + HOST + "/" + NOMBRE_BD
			+ "?user=" + USER + "&password=" + PASSWORD;

	public static void main(String[] args) {

		// Obtener la conexión
		IngresoCorrienteDAO ingresoCorrienteDAO = new IngresoCorrienteDAO(
				DRIVER, URL, USER, PASSWORD);

		// Obtener el listado de todos los ingresos corrientes
		List<IngresoCorrienteVO> ingresos = ingresoCorrienteDAO
				.getListadoIngresos();

		if (ingresos != null) {

			Iterator<IngresoCorrienteVO> iterator = ingresos.iterator();

			while (iterator.hasNext()) {
				IngresoCorrienteVO ingreso = iterator.next();
				System.out.println(ingreso.toString());
			}
		}

		// Obtener el ingreso corriente dado el id
		String idConsulta = "dos";
		IngresoCorrienteVO ingreso = ingresoCorrienteDAO
				.getDatosIngreso(idConsulta);
		System.out.println(ingreso.toString());

		// Insertar un nuevo ingreso	
		String idInsert = "'cuatro'";	// Dato para probar más fácil el insert
		ingresoCorrienteDAO.insertDatosIngreso(idInsert, idInsert);
		
		//borrar un ingreso existente
		String idDelete = "cuatro";
		ingresoCorrienteDAO.deleteDatosIngreso(idDelete);
	}

}
