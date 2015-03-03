package es.open4job.ejb3.stateful;

import javax.ejb.Stateful;

@Stateful
public class HelloWorldBean implements HelloWorld {
	
	public HelloWorldBean() {
	}

	public String sayHello() {
		return "Hello World !!!";
	}
	
}