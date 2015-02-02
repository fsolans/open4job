package es.open4job.aytozgz.opendata.model.dao.presupuesto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.aytozgz.opendata.model.vo.presupuesto.GastoCorrienteVO;
import es.open4job.aytozgz.opendata.model.vo.presupuesto.IngresoCorrienteVO;

public class IngresoCorrienteDAO extends GenericDAO {

	public static final Logger logger = Logger
			.getLogger(IngresoCorrienteDAO.class.getName());

	public IngresoCorrienteDAO(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}

	// Listado de ingresos
	public List<IngresoCorrienteVO> getListadoIngresos() {

		List<IngresoCorrienteVO> ingresos = new ArrayList<IngresoCorrienteVO>();

		IngresoCorrienteVO ingreso = null;

		String query = "SELECT * " + " FROM PRESUPUESTO_INGRESO";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();

			stmt = connection.prepareCall(query);

			rs = stmt.executeQuery();

			while (rs.next()) {

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

				ingreso = new IngresoCorrienteVO(aplicacion,
						derechosCancelados, excesoDefectoPrevision,
						derechosReconocidosNetos, previsionModificacion,
						derechosReconocidos, id, recaudacionNeta, fecha,
						previsionInicial, concepto, idCapitulo, capitulo,
						derechosAnuladosYDevoluciones, previsionDefinitivo,
						derechosPendientesCobro);

				ingresos.add(ingreso);

			}

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

		return ingresos;

	}

	// Obtiene los datos de un registro en concreto
	public IngresoCorrienteVO getDatosIngreso(String idIngreso) {

		IngresoCorrienteVO ingreso = null;

		String query = "SELECT * " + " FROM PRESUPUESTO_INGRESO WHERE id = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();

			stmt = connection.prepareCall(query);

			stmt.setString(1, idIngreso);

			rs = stmt.executeQuery();

			rs.next();

			String aplicacion = rs.getString("APLICACION");
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

	// Obtiene las fechas de las que se tienen registros
	public List<Date> getFechasConIngresos(Date fecha) {

		List<Date> fechas = null;

		// TODO

		return fechas;

	}

	// Obtiene los datos de los registros en una fecha determinada
	public List<IngresoCorrienteVO> getListadoIngresosPorFecha(Date fecha) {

		List<IngresoCorrienteVO> ingresos = null;

		// TODO

		return ingresos;

	}

}
