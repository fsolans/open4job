package es.open4job.ejb3.stateless;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorld {
	
    @Asynchronous
    @Override
    public Future<String> sayHello(String name) {
    	
        System.out.println(new Date().toString()+" - Inicio - HelloWorldBean.sayHello (" + name + ")");

        try {
           Thread.sleep(5*1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(new Date().toString() + " - Fin - HelloWorldBean.sayHello (" + name + ")");

        return new AsyncResult<String>("Hello " + name);
        
    }
    
}