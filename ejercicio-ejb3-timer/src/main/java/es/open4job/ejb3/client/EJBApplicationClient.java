package es.open4job.ejb3.client;

import javax.naming.Context;
import javax.naming.NamingException;

import es.open4job.ejb3.stateless.TimerRemote;
import es.open4job.ejb3.stateless.TimerBean;
import es.open4job.ejb3.client.JNDILookupClass;

public class EJBApplicationClient {

	public static void main(String[] args) {
		
		// 1. Creating bean instance through lookup
		TimerRemote bean = doLookup();

		// 5. Call bean methods
		// starts the timer
		bean.startTimer();
		System.out.println(bean.checkTimerStatus());
	
	}

	private static TimerRemote doLookup() {
		Context context = null;
		TimerRemote bean = null;
		try {
			// 2. Obtaining Context
			context = JNDILookupClass.getInitialContext();
			// 3. Generate JNDI Lookup name
			String lookupName = getLookupName();
			// 4. Lookup and cast
			bean = (TimerRemote) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return bean;
	
	}

	private static String getLookupName() {
		
		/*
		 * The app name is the EAR name of the deployed EJB without .ear suffix.
		 * Since we haven't deployed the application as a .ear, the app name for
		 * us will be an empty string
		 */
		String appName = "";

		// The module name is the JAR name of the deployed EJB without the .jar
		// suffix.
		String moduleName = "ejercicio-ejb3-timer";

		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This
		 * can be an empty string if distinct name is not specified.
		 */
		String distinctName = "";

		// The EJB bean implementation class name
		String beanName = TimerBean.class.getSimpleName();

		// Fully qualified remote interface name
		final String interfaceName = TimerRemote.class.getName();

		// Create a look up string name
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + interfaceName;

		return name;
	}

}
