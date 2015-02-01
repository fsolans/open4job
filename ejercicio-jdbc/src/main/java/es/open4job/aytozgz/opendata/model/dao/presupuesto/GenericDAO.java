package es.open4job.aytozgz.opendata.model.dao.presupuesto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericDAO {

	public static final Logger logger = Logger.getLogger(GenericDAO.class.getName());

	private String driver;

	private String url;

	private String user;

	private String password;

	protected Connection connection = null;

	public GenericDAO(String driver, String url, String user, String password) {

		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;

	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void abrirConexion() throws SQLException, ClassNotFoundException {

		try {

			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, "Exception : " + e.getMessage() );
			throw e;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Exception : " + e.getMessage() );
			throw e;
		}

	}

	public void cerrarConexion() {

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {
			}

		}
		
	}

}
