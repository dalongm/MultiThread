package juc;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();

	private int value;

	public Object handleRead(Lock lock) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(1000);
			return value;
		} finally {
			System.out.println(Thread.currentThread().getId()+" read.");
			lock.unlock();
		}
	}
	
	public void handleWrite(Lock lock, int index) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(1000);
			value = index;
		} finally {
			System.out.println(Thread.currentThread().getId()+" write.");
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					demo.handleRead(readLock);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable writeRunnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					demo.handleWrite(writeLock, new Random().nextInt());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		for(int i=0;i<18;i++) {
			new Thread(readRunnable).start();
		}
		
		for(int i=18;i<20;i++) {
			new Thread(writeRunnable).start();
		}
	}
	
}
