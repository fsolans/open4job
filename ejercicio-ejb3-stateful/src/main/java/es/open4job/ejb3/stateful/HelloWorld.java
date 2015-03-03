package es.open4job.ejb3.stateful;

import javax.ejb.Remote;
// Elegir local o remoto
//import javax.ejb.Local;

//@Local
@Remote
public interface HelloWorld {
	
    public String sayHello();

}