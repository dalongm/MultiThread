package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition example
 * 
 * @author dalongm
 */
public class ReenterLockCondition implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	
	@Override
	public void run() {
		try {
			lock.lock();
			condition.await(); // 释放锁
			System.out.println("thread is going on");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLockCondition tl = new ReenterLockCondition();
		Thread t1 = new Thread(tl);
		t1.start();
		Thread.sleep(2000);
		lock.lock();
		condition.signal(); 
		System.out.println("signal lock");
		lock.unlock(); // 显式释放锁
	}
	
}
