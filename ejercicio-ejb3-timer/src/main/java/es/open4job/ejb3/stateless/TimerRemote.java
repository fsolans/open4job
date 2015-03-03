package es.open4job.ejb3.stateless;

import javax.ejb.Remote;

@Remote
public interface TimerRemote {
	
	public String checkTimerStatus();

	public void startTimer();

}