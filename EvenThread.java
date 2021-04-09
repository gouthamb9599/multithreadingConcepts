package concepts.multithreading;

public class EvenThread extends Thread{
	public void run() {
		System.out.println("I AM EVEN THREAD");
		for(int i=1;i<=5;i++) {
			if(i%2==0) {
				System.out.println("EVEN: "+i);
			}
		}
	}
}
