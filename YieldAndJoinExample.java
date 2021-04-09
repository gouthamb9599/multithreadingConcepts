package concepts.multithreading;
class OddThreads implements Runnable {
	@Override
	
	public void run() {
	System.out.println("I AM ODD THREAD");
	for(int i=1;i<=500;i++) {
		if(i%2!=0) {
			if(i==201) {
				System.out.println("Yield called");
				Thread.yield();//in-order to provide cpu processing to both the process this transfer the cpu usage to another but some times while transfering the same thread might continue 
			}
			System.out.println("ODD: "+i);
		}
	}
	}
}
class EvenThreads extends Thread{
	public void run() {
		System.out.println("I AM EVEN THREAD");
		for(int i=1;i<=500;i++) {
			if(i%2==0) {
				System.out.println("EVEN: "+i);
			}
		}
	}
}

public class YieldAndJoinExample {
	public static void main(String[] args) {
		Thread thread1=new Thread(new OddThreads());
		EvenThreads thread2= new EvenThreads();
		thread1.start();
		thread2.start();
		
		//wait for the threads to join
		try {
			System.out.println("Odd Thread State: "+thread1.getState());
			System.out.println("Even Thread State: "+thread2.getState());
			thread1.join();
			thread2.join();//joins both the threads while completion one waits until the other one ends to end at the same time
			//Thread.currentThread().join(); current application will be joined so the execution will end completely 
			System.out.println("Odd Thread State: "+thread1.getState());
			System.out.println("Even Thread State: "+thread2.getState());
		}catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	

}
