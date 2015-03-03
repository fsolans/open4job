package es.open4job.ejb3.stateless;

import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class TimerBean implements TimerRemote {

	@Resource
	TimerService service;

	@Override
	public void startTimer() {

		Timer timer = service.createTimer(1000, 24 * 60 * 60 * 1000, null);
		System.out.println("Timers set");

	}

	@Timeout
	public void handleTimeout(Timer timer) {
		System.out.println("Handle timeout event here...");
	}

	@Override
	public String checkTimerStatus() {

		Timer timer = null;
		Collection<Timer> timers = service.getTimers();
		Iterator<Timer> iterator = timers.iterator();
		while (iterator.hasNext()) {
			timer = iterator.next();
			return ("Timer will expire after " + timer.getTimeRemaining() + " milliseconds.");
		}

		return ("No timer found");

	}

}
