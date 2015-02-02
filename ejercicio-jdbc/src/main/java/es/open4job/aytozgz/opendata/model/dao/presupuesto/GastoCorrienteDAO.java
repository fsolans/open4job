package es.open4job.aytozgz.opendata.model.dao.presupuesto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.open4job.aytozgz.opendata.model.vo.presupuesto.GastoCorrienteVO;

public class GastoCorrienteDAO extends GenericDAO {

	public static final Logger logger = Logger
			.getLogger(GastoCorrienteDAO.class.getName());

	public GastoCorrienteDAO(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}

	// Obtener todos los listado de gastos
	public List<GastoCorrienteVO> getListadoGastos() {

		List<GastoCorrienteVO> gastos = new ArrayList<GastoCorrienteVO>();

		String query = "SELECT OBLIGACION_PENDIENTE_PAGO, CREDITO_MODIFICACION, ORGANO, ID_ORGANO, "
				+ " OBLIGACION_NETA, ID, FECHA, CONCEPTO, PARTIDA, ID_CAPITULO, CREDITO_DEFINITIVO, "
				+ " CAPITULO, CREDITO_INICIAL, ID_AREA, ID_AREA, PAGO_NETO, GASTO_COMPROMETIDO, "
				+ " REMANENTE_DE_CREDITO, AREA " + " FROM PRESUPUESTO_GASTO";

		Statement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();

			stmt = connection.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {

				float obligacionPendientePago = rs.getFloat(1);
				float creditoModificacion = rs.getFloat(2);
				String organo = rs.getString(3);
				String idOrgano = rs.getString(4);
				float obligacionNeta = rs.getFloat(5);
				String id = rs.getString(6);
				String fecha = rs.getString(7);
				String concepto = rs.getString(8);
				String partida = rs.getString(9);
				int idCapitulo = rs.getInt(10);
				float creditoDefinitivo = rs.getFloat(11);
				String capitulo = rs.getString(12);
				float creditoInicial = rs.getFloat(13);
				String idArea = rs.getString(14);
				float pagoNeto = rs.getFloat(15);
				float gastoComprometido = rs.getFloat(16);
				float remanenteDeCredito = rs.getFloat(17);
				String area = rs.getString(18);

				GastoCorrienteVO gasto = new GastoCorrienteVO(
						obligacionPendientePago, creditoModificacion, organo,
						obligacionNeta, idOrgano, id, fecha, concepto, partida,
						idCapitulo, creditoDefinitivo, capitulo,
						creditoInicial, idArea, pagoNeto, gastoComprometido,
						remanenteDeCredito, area);

				gastos.add(gasto);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
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

		return gastos;

	}

	// Obtiene los datos de un registro en concreto
	public GastoCorrienteVO getDatosGasto(String idGasto) {

		GastoCorrienteVO gasto = null;

		String query = "SELECT OBLIGACION_PENDIENTE_PAGO, CREDITO_MODIFICACION, ORGANO, ID_ORGANO, "
				+ " OBLIGACION_NETA, ID, FECHA, CONCEPTO, PARTIDA, ID_CAPITULO, CREDITO_DEFINITIVO, "
				+ " CAPITULO, CREDITO_INICIAL, ID_AREA, ID_AREA, PAGO_NETO, GASTO_COMPROMETIDO, "
				+ " REMANENTE_DE_CREDITO, AREA "
				+ " FROM PRESUPUESTO_GASTO WHERE id= '" + idGasto + "'";

		Statement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();

			stmt = connection.createStatement();

			rs = stmt.executeQuery(query);

			rs.next();
			
			float obligacionPendientePago = rs.getFloat(1);
			float creditoModificacion = rs.getFloat(2);
			String organo = rs.getString(3);
			String idOrgano = rs.getString(4);
			float obligacionNeta = rs.getFloat(5);
			String id = rs.getString(6);
			String fecha = rs.getString(7);
			String concepto = rs.getString(8);
			String partida = rs.getString(9);
			int idCapitulo = rs.getInt(10);
			float creditoDefinitivo = rs.getFloat(11);
			String capitulo = rs.getString(12);
			float creditoInicial = rs.getFloat(13);
			String idArea = rs.getString(14);
			float pagoNeto = rs.getFloat(15);
			float gastoComprometido = rs.getFloat(16);
			float remanenteDeCredito = rs.getFloat(17);
			String area = rs.getString(18);

			gasto = new GastoCorrienteVO(obligacionPendientePago,
					creditoModificacion, organo, obligacionNeta, idOrgano, id,
					fecha, concepto, partida, idCapitulo, creditoDefinitivo,
					capitulo, creditoInicial, idArea, pagoNeto,
					gastoComprometido, remanenteDeCredito, area);

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

		return gasto;

	}

	// Obtiene las fechas de las que se tienen registros
	public List<Date> getFechasConGastos(Date fecha) {

		List<Date> fechas = null;

		// TODO

		return fechas;

	}

	// Obtiene los datos de los registros en una fecha determinada
	public List<GastoCorrienteVO> getListadoGastosPorFecha(Date fecha) {

		List<GastoCorrienteVO> gastos = null;

		// TODO

		return gastos;

	}

}
