package proj7.ex6.b;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Exercicio6b {
    static ArrayBlockingQueue<Integer> nrs = new ArrayBlockingQueue<Integer>(40);
    static CountDownLatch firstLatch = new CountDownLatch(1);
    static CountDownLatch secondLatch = new CountDownLatch(4);
    public static void main(String[] args) {
        new Thread(new Consumer()).start();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            pool.submit(new Producer());
        }

        pool.shutdown();



    }
}
