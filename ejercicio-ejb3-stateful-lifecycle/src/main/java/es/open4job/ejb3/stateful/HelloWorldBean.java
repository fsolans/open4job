package es.open4job.ejb3.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class HelloWorldBean implements HelloWorld {

	public HelloWorldBean() {
	}

	public String sayHello() {
		return "Hello World !!!";
	}

	@PostConstruct
	public void initialize() {
		// Invocado antes de que una instancia de bean sea instanciada.
    	System.out.println("HelloWorldBean @PostConstruct.");
	}

	@PreDestroy
	public void destroy() {
		// Invocado antes de que el contenedor destruya una instancia de bean.
    	System.out.println("HelloWorldBean @PreDestroy.");

	}

	@PrePassivate
	public void beforePassivate() {
		// Invocado antes de que SFSB sea pasivado.
    	System.out.println("HelloWorldBean @PrePassivate.");
	}

	@PostActivate
	public void afterActivation() {
		// Invocado antes que SFSB sea restaurado.
    	System.out.println("HelloWorldBean @PostActivate.");
	}

	@Init
	public void init() {
		// Invocado para inicializar el SFSB
    	System.out.println("HelloWorldBean @Init.");
	}

	@Remove
	public void stopSession() {
		// Invocado al eliminar la instancia del bean.
    	System.out.println("HelloWorldBean @Remove.");
	}

}