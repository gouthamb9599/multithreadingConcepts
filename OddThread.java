package concepts.multithreading;

public class OddThread implements Runnable {
	@Override
	
	public void run() {
	System.out.println("I AM ODD THREAD");
	for(int i=1;i<=5;i++) {
		if(i%2!=0) {
			System.out.println("ODD: "+i);
		}
	}
	}
}
