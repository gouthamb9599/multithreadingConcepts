package concepts.multithreading;
//wait,notify and synchornized usage
//account class is the resource
class Account{
	int balance;
	public static final int min_amount=1000;
	public Account(int balance) {
		this.balance=balance;
		System.out.println("Initial Balance: "+balance);
		
	}
	public synchronized void transaction(String s) {
		System.out.println("Notified All:A "+s+" Transaction has begin ");
		notifyAll();
	}
	public synchronized void deposit(int deposit_amt) {
		transaction("Deposit");
		if(deposit_amt<=500) {
			try {
				System.out.println("Waiting.....: Deposit");
				wait();
				System.out.println("Invalid Deposit amount");
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		else {
			balance=this.balance+deposit_amt;
			notify();
			System.out.println("Notified: Deposit done");
			System.out.println("Current Balance: Rs."+balance);
		}
		}		
		
	public synchronized void  FundsTransfer(int amt,int id) {
		transaction("Funds Transfer");
		System.out.println("the current balance :Rs."+balance);
		int temp_balance=this.balance-amt;
		if(temp_balance<min_amount) {
			
			try {
				System.out.println("Waiting.....: Funds Transfer");
				wait();
				System.out.println("Should Maintain Minimum balance: Rs."+min_amount+" Funds Transfer Issue");
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		else {
			this.balance=temp_balance;
			notify();
			System.out.println("Notified: Funds Transfer done");
			System.out.println("Current Balance: Rs."+balance);
		}
		
	}
	//withdraw operation
	public synchronized void withDraw(int withdraw_amt) {
		transaction("Withdrawal");
		int temp_balance=this.balance-withdraw_amt;
//		synchronized (this) {
//			System.out.println("Waiting.....: Withdraw");
//			System.out.println("Should Maintain Minimum balance: Rs."+min_amount+" Withdraw Issue");
//		}
//		this.balance=temp_balance;
//		notify();
//		System.out.println("Notified: Withdrawal done");
//		System.out.println("Current Balance: Rs."+balance);
		if(temp_balance<min_amount) {
			
			try {
				System.out.println("Waiting.....: Withdraw");
				wait();
				System.out.println("Should Maintain Minimum balance: Rs."+min_amount+" Withdraw Issue");
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
				
	}
		}
		else {
			this.balance=temp_balance;
			notify();
			System.out.println("Notified: Withdrawal done");
			System.out.println("Current Balance: Rs."+balance);
		}
		
	}
}
class FundsTransferThread extends Thread{
	Account account;
	int amount;
	int id;
	public FundsTransferThread(Account account,int amount,int id) {
		this.account=account;
		this.amount=amount;
		this.id=id;
	}
	public void run() {
		account.FundsTransfer(amount, id);
	}
}
class DepositThread extends Thread{
	Account account;
	int deposit_amt;
	public DepositThread(Account account,int deposit_amt) {
		this.account=account;
		this.deposit_amt=deposit_amt;
		// TODO Auto-generated constructor stub
		
	}
	public void run() {
		account.deposit(deposit_amt);
	}
}
class WithdrawalThread extends Thread{
	Account account;
	int withdraw_amt;
	public WithdrawalThread(Account account,int withdraw_amt) {
		this.account=account;
		this.withdraw_amt=withdraw_amt;
		// TODO Auto-generated constructor stub
		
	}
	public void run() {
		account.withDraw(withdraw_amt);
	}
}
public class BankAccount {
	public static void main(String[] args) {
		Account account = new Account(80000);
//		DepositThread deposit= new DepositThread(account, 100);
		WithdrawalThread withdraw = new WithdrawalThread(account, 785000);
//		WithdrawalThread withdraw = new WithdrawalThread(account, 75000);
		DepositThread deposit= new DepositThread(account, 1000);
		FundsTransferThread transfer = new FundsTransferThread(account, 1000, 2);
//		deposit.start();
		withdraw.start();
		deposit.start();
		transfer.start();
		
	}

}
