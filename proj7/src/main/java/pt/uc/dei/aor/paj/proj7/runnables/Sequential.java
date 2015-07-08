package pt.uc.dei.aor.paj.proj7.runnables;

import pt.uc.dei.aor.paj.proj7.main.Main;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Sequential implements Runnable {

    private Double[] vector;
    private CyclicBarrier barrier;

    public Sequential(Double[] v) {
        vector = v;
    }

    public void getAverage() {
        Double sum = 0.0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
        }

        System.out.println("Média: "+sum/(vector.length));
    }

    public void getMaximum() {
        Double max = 0.0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) max = vector[i];
        }
        System.out.println("Máximo: "+max);
    }

    public void getMinimum() {
        Double min = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < min) min = vector[i];
        }
        System.out.println("Mínimo: "+min);
    }

    @Override
    public void run() {

        try {
            Main.semaphore.acquire();
            System.out.println("Sequencial: \n");
            ExecutorService executor = Executors.newSingleThreadExecutor();
            long start = System.nanoTime();
            barrier = new CyclicBarrier(1,new Runnable() {
                @Override
                public void run() {
                    getAverage();
                    getMaximum();
                    getMinimum();
                }
            });
            barrier.await();
            long end = System.nanoTime();
            Main.stats[Main.globalCount][1] = (end-start)/1000000.0;
            Main.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException be) {
            be.printStackTrace();
        }
    }
}
