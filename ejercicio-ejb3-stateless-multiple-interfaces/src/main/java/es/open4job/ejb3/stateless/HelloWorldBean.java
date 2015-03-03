package es.open4job.ejb3.stateless;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorldLocal, HelloWorldRemote {
	
	public HelloWorldBean() {
	}

	public String sayHello() {
		return "Hello World !!!";
	}
	
}