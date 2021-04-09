package concepts.multithreading;

public class UserThreadProperties {

	public static void main(String[] args) {
		EvenThread even = new EvenThread();
		even.setName("Even thread");
		even.setPriority(8);
		even.setDaemon(true);
		
		
		OddThread odd = new OddThread();
		Thread oddThread = new Thread(odd);
		oddThread.setPriority(9);
		
		
		
		even.start();
		oddThread.start();
		
		
		System.out.println("ID of even Thread: "+even.getId()+" ID of Odd Thread "+oddThread.getId());
		System.out.println("Name of even Thread: "+even.getName()+" Name of Odd Thread "+oddThread.getName());
		System.out.println("Thread Priority(even): "+even.getPriority()+" Thread Priority(odd): "+oddThread.getPriority());
		System.out.println("Interrupted :"+even.isInterrupted());
		System.out.println("State:  "+even.getState());
		System.out.println("Current even Daemon Status: "+even.isDaemon());
//		Thread.currentThread().stop();
		System.out.println("State:  "+even.getState());
//		System.out.println("Current Thread Status: "+Thread.currentThread().isAlive());
		System.out.println("even Thread Status: "+even.isAlive());
	}
}
