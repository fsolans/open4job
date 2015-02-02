package es.open4job.aytozgz.opendata;

import java.util.Iterator;
import java.util.List;

import es.open4job.aytozgz.opendata.model.dao.presupuesto.GastoCorrienteDAO;
import es.open4job.aytozgz.opendata.model.dao.presupuesto.IngresoCorrienteDAO;
import es.open4job.aytozgz.opendata.model.vo.presupuesto.GastoCorrienteVO;
import es.open4job.aytozgz.opendata.model.vo.presupuesto.IngresoCorrienteVO;

public class Presupuesto {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";

		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";

		String user = "open4job";
		String password = "open4job";

		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;

		// Obtener el listado de todos los gastos corrientes
		GastoCorrienteDAO gastoCorrienteDAO = new GastoCorrienteDAO(driver,
				url, user, password);

		List<GastoCorrienteVO> gastos = gastoCorrienteDAO.getListadoGastos();

		if (gastos != null) {

			Iterator<GastoCorrienteVO> iterator = gastos.iterator();

			while (iterator.hasNext()) {

				GastoCorrienteVO gasto = iterator.next();
				System.out.println(gasto.toString());

			}

		}

		// Obtener el gasto corriente dado el id
		String idGasto = "20140930-14CAF--011--913734";
		GastoCorrienteVO gasto = gastoCorrienteDAO.getDatosGasto(idGasto);
		System.out.println(gasto.toString());

		// Obtener el listado de todos los ingresos corrientes
		IngresoCorrienteDAO ingresoCorrienteDAO = new IngresoCorrienteDAO(
				driver, url, user, password);

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
		String idIngreso = "20140930-42030";
		IngresoCorrienteVO ingreso = ingresoCorrienteDAO
				.getDatosIngreso(idIngreso);
		System.out.println(ingreso.toString());

	}

}
