package es.open4job.ejb3.stateless;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@LocalBean
@Startup
public class ActionTimerBean {

	@Resource
	private TimerService timerService;

	@PostConstruct
	private void init() {

		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setInfo("ActionTimerBean");
		timerService.createSingleActionTimer(5000, timerConfig); // after 5 seconds
		System.out.println("INIT Time : " + new Date());

	}

	@Timeout
	public void execute(Timer timer) {

		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Execution Time : " + new Date());
		System.out.println("____________________________________________");

	}

}
