package es.open4job.ejb3.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorld {
	
	public HelloWorldBean() {
	}

	public String sayHello() {
		return "Hello World !!!";
	}
	   
    @PostConstruct
    public void init() {
        // Los objetos inicializados aquí serán usados por los beans de sesión
    	System.out.println("HelloWorldBean @PostConstruct.");
    }
 
     @PreDestroy
    public void destroy() {
    	// Liberar los recursos adquiridos por el bean de sesión
    	System.out.println("HelloWorldBean @PreDestroy.");
    } 
     
}
