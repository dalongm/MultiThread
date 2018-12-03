package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class HeavySocketClient {
    private static ExecutorService tp = Executors.newCachedThreadPool();
    private static final int SLEEPTIME = 1000 * 1000 * 1000;

    public static class EchoClent implements Runnable {


        @Override
        public void run() {
            Socket client = null;
            PrintWriter writer = null;
            BufferedReader reader = null;
            client = new Socket();
            try {
                client.connect(new InetSocketAddress("localhost", 8000));
                writer = new PrintWriter(client.getOutputStream(), true);
                writer.print("H");
                LockSupport.parkNanos(SLEEPTIME);
                writer.print("e");
                LockSupport.parkNanos(SLEEPTIME);
                writer.print("l");
                LockSupport.parkNanos(SLEEPTIME);
                writer.print("l");
                LockSupport.parkNanos(SLEEPTIME);
                writer.print("o");
                LockSupport.parkNanos(SLEEPTIME);
                writer.print("!");
                LockSupport.parkNanos(SLEEPTIME);
                writer.println();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
