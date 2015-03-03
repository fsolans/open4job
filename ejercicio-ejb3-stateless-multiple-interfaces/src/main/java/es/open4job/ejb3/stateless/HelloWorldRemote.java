package es.open4job.ejb3.stateless;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote {
	
    public String sayHello();

}