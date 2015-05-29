package es.open4job.aytozgz.opendata.model.dao.presupuesto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.aytozgz.opendata.model.vo.presupuesto.IngresoCorrienteVO;


/**
 * Ejemplo con statment
 * Se utiliza para consultas que no necesitan enviar ni recibir parametros
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
	 * Obtiene un listado de objetos
	 * 
	 * @return List de objetos IngresoCorrienteVO
	 */
	public List<IngresoCorrienteVO> getListadoIngresos() {

		List<IngresoCorrienteVO> ingresos = null;
		ingresos = new ArrayList<IngresoCorrienteVO>();

		IngresoCorrienteVO ingreso = null;

		String query = "SELECT * FROM presupuesto_ingreso";

		Statement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);

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

	/**
	 * Obtiene los datos de un registro en concreto
	 * 
	 * @param idIngreso
	 *            identificador del registro a consultar
	 * @return objeto del tipo IngresoCorrienteVO
	 */
	public IngresoCorrienteVO getDatosIngreso(String idIngreso) {

		IngresoCorrienteVO ingreso = null;

		String query = "SELECT * FROM presupuesto_ingreso WHERE id = '"
				+ idIngreso + "'";

		Statement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();
			stmt = connection.createStatement();

			// executeQuery para consultas que obtienen un objeto
			rs = stmt.executeQuery(query);

			rs.next();

			// Guarda los datos en variables
			String aplicacion = rs.getString("aplicacion");
			float derechosCancelados = rs.getFloat("DERECHOS_CANCELADOS");

			float excesoDefectoPrevision = rs
					.getFloat("EXCESO_DEFECTO_PREVISION");
			float derechosReconocidosNetos = rs
					.getFloat("DERECHOS_RECONOCIDOS_NETOS");
			float previsionModificacion = rs.getFloat("PREVISION_MODIFICACION");
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
			ingreso = new IngresoCorrienteVO(aplicacion, derechosCancelados,
					excesoDefectoPrevision, derechosReconocidosNetos,
					previsionModificacion, derechosReconocidos, id,
					recaudacionNeta, fecha, previsionInicial, concepto,
					idCapitulo, capitulo, derechosAnuladosYDevoluciones,
					previsionDefinitivo, derechosPendientesCobro);

		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {

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

		return ingreso;

	}

	/**
	 * Inserta un nuevo registro en la BD
	 * 
	 * No incluye todos los parametros porque no es necesario.
	 * 
	 * @param aplicacion
	 * @param id
	 */
	public void insertDatosIngreso(String aplicacion, String id) {

		String query = "INSERT INTO presupuesto_ingreso (aplicacion, id) VALUES("
				+ aplicacion + ", " + id + ")";

		Statement stmt = null;
		int rowsAffected = 0;

		try {

			this.abrirConexion();
			stmt = connection.createStatement();

			// executeUpdate para insert, update y delete.
			// Devuelve un entero, el numero de filas afectadas
			rowsAffected = stmt.executeUpdate(query);

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

	/**
	 * Elimina un dato existente
	 * 
	 * @param id
	 *            identificador del dato a eliminar
	 */
	public void deleteDatosIngreso(String id) {
		String query = "DELETE FROM presupuesto_ingreso WHERE id = '" + id
				+ "'";

		Statement stmt = null;
		int rowsAffected = 0;

		try {

			this.abrirConexion();
			stmt = connection.createStatement();

			// executeUpdate para insert, update y delete.
			// Devuelve un entero, el numero de filas afectadas
			rowsAffected = stmt.executeUpdate(query);

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
