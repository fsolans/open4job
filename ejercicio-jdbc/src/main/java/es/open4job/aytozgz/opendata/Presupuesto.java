package es.open4job.aytozgz.opendata;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import es.open4job.aytozgz.opendata.model.dao.presupuesto.GastoCorrienteDAO;
import es.open4job.aytozgz.opendata.model.dao.presupuesto.IngresoCorrienteDAO;
import es.open4job.aytozgz.opendata.model.vo.presupuesto.GastoCorrienteVO;

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
		
	}

}
