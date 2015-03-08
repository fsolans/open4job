package es.open4job.ejb3.client;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.NamingException;

import es.open4job.ejb3.stateless.HelloWorld;

public class Client {

	public static void main(String[] args) {

		String respuesta = null;

		try {

			HelloWorld bean = doLookup();
			Future future = bean.sayHello("Open4Job");

			while (!future.isDone()) {

				Thread.sleep(1000);

				System.out.println(new Date().toString()
						+ " - I do other things ...");

			}

			respuesta = (String) future.get();

			System.out.println(new Date().toString() + " - Respuesta : " + respuesta);

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	private static HelloWorld doLookup() {

		Context context = null;
		HelloWorld bean = null;

		try {

			// 1. Obtaining Context
			context = ClientUtility.getInitialContext();

			// 2. Generate JNDI Lookup name
			String lookupName = getLookupName();

			// 3. Lookup and cast
			bean = (HelloWorld) context.lookup(lookupName);

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

		/*
		 * The module name is the JAR name of the deployed EJB without the .jar
		 * suffix.
		 */
		String moduleName = "ejercicio-ejb3-asynchronous";

		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This
		 * can be an empty string if distinct name is not specified.
		 */
		String distinctName = "";

		// The EJB bean implementation class name
		String beanName = "HelloWorldBean";

		// Fully qualified remote interface name
		final String interfaceName = "es.open4job.ejb3.stateless.HelloWorld";

		// Create a look up string name
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + interfaceName;

		return name;

	}

}
