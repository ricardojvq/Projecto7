package proj7.ex3;

import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Paralelo implements Runnable {
    private Double[] vector;
    private Semaphore semaphores;

    public Paralelo(Double[] v, Semaphore s) {
        vector = v;
        semaphores = s;
    }

    public void getAverage() {
        Double sum = 0.0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
        }

        System.out.println("Média: "+sum/(vector.length));
    }

    @Override
    public void run() {
        try {
            semaphores.acquire();
            System.out.println("\nParalelo: \n");
            long start = System.nanoTime();
            new Thread(new Maximum(vector)).start();
            new Thread(new Minimum(vector)).start();
            getAverage();
            long end = System.nanoTime();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Tempo: " + (end - start) / 1000000.0 + " ms");
                }
            }).start();
            semaphores.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
