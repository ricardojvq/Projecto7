package proj7.ex1.main;

import proj7.ex1.tasks.*;

import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Exercicio1 {

    public static ArrayBlockingQueue<Integer> count = new ArrayBlockingQueue<Integer>(8);

    public static void main(String[] args) {
        ExecutorService single = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 8; i++) {
            int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Exercicio1.count.put(num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            single.submit(runnable);
        }
        single.shutdown();
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 8; i++) {
            fixedPool.submit(new GenericTask());
        }

        fixedPool.shutdown();
    }
}
