package es.open4job.ejb3.stateless;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@LocalBean
@Startup
public class ScheduleTimerBean {

	@Resource
	private TimerService timerService;

	@Schedule(second = "13,34,57", minute = "*", hour = "*")
	public void execute(Timer timer) {
		
		System.out.println("Executing ...");
		System.out.println("Execution Time : " + new Date());
		System.out.println("____________________________________________");
	
	}
	
}
