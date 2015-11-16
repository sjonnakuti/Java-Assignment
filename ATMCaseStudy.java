package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//ATMCaseStudy.java
//Driver program for the ATM case study

public class ATMCaseStudy
{

	public static void runThread()
	{
		BankDatabase bankDB = new BankDatabase();
		
		
//		for(int i = 0; i< bankDB.accounts.length;i++)
//		List<Thread> threads = new ArrayList<>();
		for(int i = 0; i< 3;i++)
		{
			ATM atm = new ATM(bankDB.accounts[i]);
			Thread thread = new Thread(atm);
			atm.setThreadId(thread.getId());
//			threads.add(thread);
			thread.run();
			try{
				Thread.sleep(10000);
			}catch(InterruptedException e)
			{
				
			}
			System.out.println(thread.getId());
		}
	}
	public static void main(String[] args)
	{
		ATMCaseStudy.runThread();
	}
}

