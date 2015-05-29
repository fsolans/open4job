package es.open4job.aytozgz.opendata;

import es.open4job.aytozgz.opendata.model.dao.presupuesto.IngresoCorrienteDAO;

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

		// enviando el 'idCapitulo' devuelve el 'capitulo'
		String capitulo = null;
		capitulo = ingresoCorrienteDAO.getCapituloById(2);

		System.out.println(capitulo);
	}

}
