package threadParelTest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SheculderTaskTest {
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(10);  
		Runnable task = new Runnable() {  
		    @Override  
		    public void run() {  
		        System.out.println("task over");  
		    }  
		};  
		executor.execute(task);  
		  
		executor = Executors.newScheduledThreadPool(10);  
		ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;  
		scheduler.scheduleAtFixedRate(task, 1, 10, TimeUnit.SECONDS); 
	}
	 
}
