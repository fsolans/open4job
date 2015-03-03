package es.open4job.ejb3.stateless;

import javax.ejb.Local;

@Local
public interface HelloWorldLocal {
	
    public String sayHello();

}