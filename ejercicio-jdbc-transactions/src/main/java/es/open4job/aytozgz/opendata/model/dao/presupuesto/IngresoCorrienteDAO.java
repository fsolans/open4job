package es.open4job.aytozgz.opendata.model.dao.presupuesto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.aytozgz.opendata.model.vo.presupuesto.IngresoCorrienteVO;

/**
 * Ejemplo de transacción para ver su funcionamiento
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
	 * Intenta agregar dos datos. La transacción solo se efectua al hacer el
	 * commit. Si alguno de los insert falla hace rollback y no guarda ninguno
	 *
	 */
	public void insertDobuleWithRollback(String datoInsert) {

		String query = "INSERT INTO presupuesto_ingreso (aplicacion, id) VALUES(?,?)";
		PreparedStatement stmt = null;

		try {

			this.abrirConexion();
			connection.setAutoCommit(false); // inicio transacción

			// se inserta un dato
			stmt = connection.prepareStatement(query);
			stmt.setString(1, datoInsert);
			stmt.setString(2, datoInsert);
			stmt.executeUpdate();

			//
			// Se inserta otro para que falle y haga rollback
			//
			String cadenaLarga = "Si la cadena de texto es demasiado larga, "
					+ "el insert falla y hace un rollback. "
					+ "Por lo que el insert anterior tampoco se guardará";

			stmt.setString(1, cadenaLarga); 
			// stmt.setString(1, datoInsert); 
			stmt.setString(2, datoInsert);
			stmt.executeUpdate();

			connection.commit(); // fin transacción

		}

		catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());

			//rollback
			try {
				connection.rollback();
				logger.log(Level.INFO, "Rollback completado");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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

	}

	/**
	 * Obtiene un listado de objetos
	 * 
	 * @return List de objetos IngresoCorrienteVO
	 */
	public List<IngresoCorrienteVO> getListadoIngresos() {

		List<IngresoCorrienteVO> ingresos = null;
		ingresos = new ArrayList<IngresoCorrienteVO>();

		IngresoCorrienteVO ingreso = null;

		String query = "SELECT * FROM presupuesto_ingreso";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {

				// Guarda los datos en variables
				String aplicacion = rs.getString("APLICACION");
				float derechosCancelados = rs.getFloat("DERECHOS_CANCELADOS");
				float excesoDefectoPrevision = rs
						.getFloat("EXCESO_DEFECTO_PREVISION");
				float derechosReconocidosNetos = rs
						.getFloat("DERECHOS_RECONOCIDOS_NETOS");
				float previsionModificacion = rs
						.getFloat("PREVISION_MODIFICACION");
				float derechosReconocidos = rs.getFloat("DERECHOS_RECONOCIDOS");
				String id = rs.getString("ID");
				float recaudacionNeta = rs.getFloat("RECAUDACION_NETA");
				String fecha = rs.getString("FECHA");
				float previsionInicial = rs.getFloat("PREVISION_INICIAL");
				String concepto = rs.getString("CONCEPTO");
				int idCapitulo = rs.getInt("ID_CAPITULO");
				String capitulo = rs.getString("CAPITULO");
				float derechosAnuladosYDevoluciones = rs
						.getFloat("DERECHOS_ANULADOS_Y_DEVOL");
				float previsionDefinitivo = rs.getFloat("PREVISION_DEFINITIVO");
				float derechosPendientesCobro = rs
						.getFloat("DERECHOS_PENDIENTES_COBRO");

				// Crea un objeto con los datos
				ingreso = new IngresoCorrienteVO(aplicacion,
						derechosCancelados, excesoDefectoPrevision,
						derechosReconocidosNetos, previsionModificacion,
						derechosReconocidos, id, recaudacionNeta, fecha,
						previsionInicial, concepto, idCapitulo, capitulo,
						derechosAnuladosYDevoluciones, previsionDefinitivo,
						derechosPendientesCobro);

				// Añade el objeto al listado
				ingresos.add(ingreso);

			}

		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

		}

		this.cerrarConexion();

		return ingresos;

	}

	public void deleteDatosIngreso(String id) {
		String query = "DELETE FROM presupuesto_ingreso WHERE id = ?";

		PreparedStatement stmt = null;
		int rowsAffected = 0;

		try {

			this.abrirConexion();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, id);

			// executeUpdate para insert, update y delete.
			// Devuelve un entero, el numero de filas afectadas
			rowsAffected = stmt.executeUpdate();

			logger.log(Level.INFO, rowsAffected + " filas cambiadas.");

		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();
	}
}
