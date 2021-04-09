package concepts.multithreading;

import java.util.Scanner;

class Table1 extends Thread{
	int table;
	Table1(int table){
		this.table=table;
	}
	public void run() {
		for(int i=1;i<=30;i++) {
//			Thread.join()
			System.out.println(+table+" * "+i+" = "+(table*1));
		}
	}
}
class Table2 implements Runnable{
	int table;
	Table2(int table){
		this.table=table;
	}
	public void run() {
		
		for(int i=1;i<=30;i++) {
			if(i==10) {
				System.out.println("getting ready to sleep with yield");
//				Thread.join(3000)
//				Thread.yield();
		try {
			Thread.sleep(30000);
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Thread is sleeping...");
		}
		}
			System.out.println(+table+" * "+i+" = "+(table*1));
		}
	}
}
public class ThreadLifeCycleMethods {
	static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		System.out.println("Enter a number for table 1");
		int table1=input.nextInt();
		Table1 thread1= new Table1(table1);
		System.out.println("Enter a number for table 2");
		int table2=input.nextInt();
		Thread thread2= new Thread(new Table2(table2));
		thread1.start();
		thread2.start();
	}
}
