package concepts.multithreading;

class Tables extends Thread{
	public void getTable(int table) {
		for(int i=1;i<=5;i++) {
//			Thread.join()
			System.out.println(+table+" * "+i+" = "+(table*1));
			try{
				Thread.sleep(400);
				
			}catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
		}
	}
}
class MyThread1 extends Thread{
	Tables t;
	public MyThread1(Tables t) {
		// TODO Auto-generated constructor stub
		this.t=t;
	}
	public void run() {
		t.getTable(5);
	}
	
	
}

class MyThread2 extends Thread{
	Tables t;
	public MyThread2(Tables t) {
		this.t=t;
	}
	public void run() {
		t.getTable(20);
	}
	
}
public class RaceCondition {
	public static void main(String[] args) {
		Tables t=new Tables();
		MyThread1 thread1= new MyThread1(t);
		MyThread2 thread2= new MyThread2(t);
		thread1.run();
		thread2.run();
	}

}
