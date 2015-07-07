package proj7.ex3;

import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Sequential implements Runnable {

    private Double[] vector;
    private Semaphore semaphores;

    public Sequential(Double[] v, Semaphore semaphore) {
        vector = v;
        semaphores = semaphore;
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
            semaphores.acquire();
            System.out.println("Sequencial: \n");
            long start = System.nanoTime();
            getAverage();
            getMaximum();
            getMinimum();
            long end = System.nanoTime();
            new Thread(() -> {
                System.out.println("Tempo: "+(end-start)/1000000.0+" ms");
            }).start();
            semaphores.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
