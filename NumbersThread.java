package concepts.multithreading;

public class NumbersThread {
public static void main(String[] args) {
	System.out.println("I AM MAIN THREAD");
	
	//new thread (Thread class)
	EvenThread even= new EvenThread();//even thread extends thread class so it is started directly
	//new thread with runnable interface
	OddThread odd= new OddThread();
	
	//pass the runnable object into thread class
	Thread threads=new Thread(odd);// odd thread implements runnable interface so a thread object is used to run it 

	//start threads
	even.start();
//	System.out.println("ID of Current Thread: "+Thread.currentThread().getId());
//	System.out.println("ID of Main Thread: "+Thread.currentThread().getName());
//	System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
	threads.start();
	int num=0;
	 for (int i = 1; i <= 500; i++)         
{ 		  	  
   int counter=0; 	  
   for(num =i; num>=1; num--)
	  {
      if(i%num==0)
	     {
		counter = counter + 1;
	     }
	  }
	  if (counter ==2)
	  {
		  System.out.println("PRIME NUMBER :"+i);
	     //Appended the Prime number to the String
//	     primeNumbers = primeNumbers + i + " ";
	  }	
}
	
	
}
}
