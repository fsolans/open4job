package es.open4job.ejb3.stateless;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@LocalBean
@Startup
public class IntervalTimerBean {

	@Resource
	private TimerService timerService;

	@PostConstruct
	private void init() {
		timerService.createTimer(1000, 2000, "IntervalTimerBean");
	}

	@Timeout
	public void execute(Timer timer) {
		
		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Current Time : " + new Date());
		System.out.println("Next Timeout : " + timer.getNextTimeout());
		System.out.println("Time Remaining : " + timer.getTimeRemaining());
		System.out.println("____________________________________________");
	
	}

}
