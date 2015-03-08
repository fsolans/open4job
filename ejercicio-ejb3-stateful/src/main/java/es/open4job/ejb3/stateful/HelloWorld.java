package es.open4job.ejb3.stateful;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
	
    public String sayHello();

}