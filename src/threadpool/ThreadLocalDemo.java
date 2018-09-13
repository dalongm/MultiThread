package threadpool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
//    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
//                Date t = simpleDateFormat.parse("2018-09-13 19:26:" + i % 60);

                if(tl.get()==null){
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = tl.get().parse("2018-09-13 19:26:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
