package thread;

import java.util.concurrent.Callable;

public class MyTask implements Callable {

    private int upperBounds;

    public MyTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= upperBounds; i++) {
            sum+=i;
        }
        return sum;
    }
}
