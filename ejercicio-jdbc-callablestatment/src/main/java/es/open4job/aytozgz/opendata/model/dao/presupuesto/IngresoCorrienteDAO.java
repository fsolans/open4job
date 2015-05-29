package es.open4job.aytozgz.opendata.model.dao.presupuesto;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejemplo con callableStatment Utilizado cuando tenemos paramentros de entrada
 * y salida
 * 
 * @author ccano
 *
 */

public class IngresoCorrienteDAO extends GenericDAO {

	public static final Logger logger = Logger
			.getLogger(IngresoCorrienteDAO.class.getName());

	// Obtiene la conexión
	public IngresoCorrienteDAO(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}

	/**
	 * Llama a un procedimiento y este devuelve un parametro
	 * 
	 * @param idCapitulo
	 *            identificador
	 * @return nombre del capitulo
	 */
	public String getCapituloById(int idCapitulo) {

		String query = "{call get_capitulo_by_id (?,?)}";

		CallableStatement stmt = null;
		String capitulo = null;

		try {

			this.abrirConexion();
			stmt = connection.prepareCall(query);

			stmt.setInt(1, idCapitulo);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR); // parametro de salida

			stmt.execute();

			capitulo = stmt.getString(2);

		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
		}

		this.cerrarConexion();

		return capitulo;

	}

}
