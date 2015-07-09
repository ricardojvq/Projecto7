package proj7.ex3.runnables;

import proj7.ex3.main.Exercicio3;

import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Sequential implements Runnable {

    private Double[] vector;
    private CyclicBarrier barrier;

    public Sequential(Double[] v) {
        vector = v;
    }

    public Double getAverage() {
        Double sum = 0.0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
        }

        System.out.println("Média: "+sum/(vector.length));
        return sum;
    }

    public Double getMaximum() {
        Double max = 0.0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) max = vector[i];
        }
        System.out.println("Máximo: "+max);
        return max;
    }

    public Double getMinimum() {
        Double min = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < min) min = vector[i];
        }
        System.out.println("Mínimo: "+min);
        return min;
    }

    @Override
    public void run() {

        try {
            Exercicio3.semaphore.acquire();
            System.out.println("Sequencial: \n");
            long start = System.nanoTime();
            getAverage();
            getMaximum();
            getMinimum();
            long end = System.nanoTime();
            Exercicio3.stats[Exercicio3.globalCount][1] = (end-start)/1000000.0;
            Exercicio3.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
