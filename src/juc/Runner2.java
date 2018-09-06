package juc;

import java.util.concurrent.CountDownLatch;

/**
 * A B C finished before D E F
 * 
 * @author dalongm
 */
public class Runner2 implements Runnable{
	
	private static CountDownLatch end;
	
	public Runner2(int count) {
		end = new CountDownLatch(count);
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" is running");
		end.countDown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Runner2 run = new Runner2(3);
		Thread t1 = new Thread(run,"A");
		Thread t2 = new Thread(run,"B");
		Thread t3 = new Thread(run,"C");
		Thread t4 = new Thread(run,"D");
		Thread t5 = new Thread(run,"E");
		Thread t6 = new Thread(run,"F");
		t1.start();
		t2.start();
		t3.start();
		
		end.await();
		
		t4.start();
		t5.start();
		t6.start();
	}
}
