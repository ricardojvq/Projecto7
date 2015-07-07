package proj7.ex6.a;

import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Main {
    static ArrayBlockingQueue<Integer> nrs = new ArrayBlockingQueue<Integer>(40);
    static CountDownLatch latch = new CountDownLatch(4);
    public static void main(String[] args) {
        new Thread(new Consumer()).start();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            pool.submit(new Producer());
        }

        pool.shutdown();



    }
}
