package proj7.ex4;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Consumer implements Runnable {

    private ArrayBlockingQueue<Double> queue;

    public Consumer(ArrayBlockingQueue<Double> q) {
        queue = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Double d = queue.take();
                Double r = Math.sqrt(d);
                System.out.println("Raíz: " + r + ", obtida pela Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
