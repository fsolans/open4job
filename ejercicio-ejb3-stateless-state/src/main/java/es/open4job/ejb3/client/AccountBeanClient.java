package es.open4job.ejb3.client;

import javax.naming.Context;
import javax.naming.NamingException;

import es.open4job.ejb3.stateless.Account;
import es.open4job.ejb3.stateless.AccountBean;
import es.open4job.ejb3.client.JNDILookupClass;

public class AccountBeanClient implements Runnable {
	
	public static void main(String[] args) {
	
		AccountBeanClient obj1 = new AccountBeanClient();
		for (int i = 0; i < 50; i++) {
			Thread t1 = new Thread(obj1, "T" + i);
			t1.start();
		}
		
	}

	public void run() {
		
		Account bean = doLookup();
		
		// 1. Setting name and balance
		bean.setName(Thread.currentThread().getName());
		bean.setBalance(Math.ceil(Math.random() * 10000));

		// 1. Reading the state of the bean for the first time
		System.out.println(Thread.currentThread().getName()
				+ " -> Reading Name : " + bean.getName());
		System.out.println(Thread.currentThread().getName()
				+ " -> Reading Balance : " + bean.getBalance());
		System.out.println(Thread.currentThread().getName() + " "
				+ bean.printAccountDetails());
	
	}

	private static Account doLookup() {
	
		Context context = null;
		Account bean = null;
		
		try {
			
			// 1. Obtaining Context
			context = JNDILookupClass.getInitialContext();
		
			// 2. Generate JNDI Lookup name
			String lookupName = getLookupName();
			
			// 3. Lookup and cast
			bean = (Account) context.lookup(lookupName);

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
		String moduleName = "ejercicio-ejb3-stateless-state";

		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This
		 * can be an empty string if distinct name is not specified.
		 */
		String distinctName = "";

		// The EJB bean implementation class name
		String beanName = AccountBean.class.getSimpleName();

		// Fully qualified remote interface name
		final String interfaceName = Account.class.getName();

		// Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
                + "/" + beanName + "!" + interfaceName;
 
		return name;

	}

}
