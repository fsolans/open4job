package es.open4job.ejb3.stateless;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@LocalBean
public class CalendarTimerBean {

	@Resource
	private TimerService timerService;

	@PostConstruct
	private void init() {

		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setInfo("CalendarTimerBean");
		ScheduleExpression schedule = new ScheduleExpression();
		schedule.hour("*").minute("*").second("13,34,57");
		timerService.createCalendarTimer(schedule, timerConfig);

	}

	@Timeout
	public void execute(Timer timer) {
		
		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Execution Time : " + new Date());
		System.out.println("____________________________________________");
	
	}

}
