package proj7.ex8.main;

import proj7.ex8.monitor.Specialist;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Exercicio8 {
    public static void main(String[] args) {
        final int numThreads = 10;
        /*ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            pool.submit(new Specialist());
        }

        pool.shutdown();*/

        for (int i = 0; i < numThreads; i++) {
            new Thread(new Specialist(),Integer.toString(i)).start();
        }

    }
}
