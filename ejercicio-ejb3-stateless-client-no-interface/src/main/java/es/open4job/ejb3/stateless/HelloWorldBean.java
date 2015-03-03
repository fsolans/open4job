package es.open4job.ejb3.stateless;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HelloWorldBean {
	
	public HelloWorldBean() {
	}

	public String sayHello() {
		return "Hello World !!!";
	}
	
}