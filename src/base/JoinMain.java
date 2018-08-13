package base;

/**
 * 一个简单的Join实例
 * join的本质是让调用线程wait()在当前线程对象实例上
 * 
 * yield()当前线程让出CPU，再和其他线程竞争CPU
 * 
 * @author dalongm
 */
public class JoinMain {
	public volatile static int i = 0;
	public static class AddThread extends Thread{
		@Override
		public void run() {
			for(i=0;i<1000000;i++);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AddThread at = new AddThread();
		at.start();
		at.join();
		System.out.println(i);
	}
}
