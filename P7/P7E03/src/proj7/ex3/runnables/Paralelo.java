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
            barrier1 = new CyclicBarrier(1,new Maximum(vector));
            barrier2 = new CyclicBarrier(1,new Minimum(vector));
            getAverage();
            barrier1.await();
            barrier2.await();
            long end = System.nanoTime();
            Exercicio3.stats[Exercicio3.globalCount][2] = (end-start)/1000000.0;
            Exercicio3.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException be) {
            be.printStackTrace();
        }

    }
}
