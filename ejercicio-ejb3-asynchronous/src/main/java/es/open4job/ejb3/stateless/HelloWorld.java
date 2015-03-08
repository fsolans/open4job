package es.open4job.ejb3.stateless;

import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
	
	public Future<String> sayHello(String name);
	  
}