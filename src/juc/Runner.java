package juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * A B C finished before D E F
 * 
 * @author dalongm
 */
public class Runner implements Runnable{
	
	public static ReentrantLock lock = new ReentrantLock();
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Runner run = new Runner();
		Thread t1 = new Thread(run,"A");
		Thread t2 = new Thread(run,"B");
		Thread t3 = new Thread(run,"C");
		Thread t4 = new Thread(run,"D");
		Thread t5 = new Thread(run,"E");
		Thread t6 = new Thread(run,"F");
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		t4.start();
		t5.start();
		t6.start();
	}
}
