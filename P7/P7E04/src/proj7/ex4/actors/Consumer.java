package proj7.ex4.actors;

import proj7.ex4.main.Exercicio4;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Consumer implements Runnable {

    private ArrayBlockingQueue<Double> queue;

    public Consumer(ArrayBlockingQueue<Double> q) {
        queue = q;
    }

    public int sleeping() {
        Random rd = new Random();
        int min = 50;
        int max = 200;
        return min + rd.nextInt(max - min + 1);
    }

    @Override
    public void run() {
        while (true) {
            if (queue.remainingCapacity() == 10 && Exercicio4.flag == 1) break;
            try {
                Double d = Exercicio4.queue.take();
                Double r = Math.sqrt(d);
                System.out.println("Raíz: " + r + " (do número "+ d + "), obtida pela Thread: " + Thread.currentThread().getName());
                Thread.sleep(sleeping());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
