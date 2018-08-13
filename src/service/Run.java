package service;

public class Run {
	public static void main(String[] args) {
		MyService service = new MyService();
		Thread threadA = new MyThreadA(service);
		threadA.start();
		Thread threadB = new MyThreadB(service);
		threadB.start();
	}
}
