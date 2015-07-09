package proj7.ex3.runnables;

import proj7.ex3.operations.Maximum;
import proj7.ex3.operations.Minimum;
import proj7.ex3.main.Exercicio3;

import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Paralelo implements Runnable {
    private Double[] vector;
    private CyclicBarrier barrier1;
    private CyclicBarrier barrier2;
    public Paralelo(Double[] v) {
        vector = v;
    }

    public void getAverage() {
        Double sum = 0.0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
        }

        System.out.println("Média: " + sum / (vector.length));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Exercicio3.semaphore.acquire();
            System.out.println("\nParalelo: \n");
            long start = System.nanoTime();
            ExecutorService pool = Executors.newFixedThreadPool(2);
            Future<Double> max = pool.submit(new Maximum(vector));
            Future<Double> min = pool.submit(new Minimum(vector));
            try {
                max.get();
                min.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            pool.shutdown();
            getAverage();
            long end = System.nanoTime();
            Exercicio3.stats[Exercicio3.globalCount][2] = (end-start)/1000000.0;
            Exercicio3.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
