package concepts.multithreading;

public class ThreadProperties {

//	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//property of the current thread...
		System.out.println("ID of Current Thread: "+Thread.currentThread().getId());
		System.out.println("Name of Main Thread: "+Thread.currentThread().getName());
		System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
//		System.out.println("Current Thread Status: "+Thread.currentThread().isAlive());
		System.out.println("Current Thread Daemon Status: "+Thread.currentThread().isDaemon());
//		Thread.currentThread().stop();
		System.out.println("Current Thread Status: "+Thread.currentThread().isAlive());
		}
}
