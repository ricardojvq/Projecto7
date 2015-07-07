package proj7.ex4;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Producer implements Runnable {

    private ArrayBlockingQueue<Double> queue;

    public Producer(ArrayBlockingQueue<Double> q) {
        queue = q;
    }

    public Double add() throws InterruptedException {
        Random rd = new Random();
        Double min = 1.0;
        Double max = 1000.0;
        Double r = min + (max-min)*rd.nextDouble();
        queue.put(r);
        return r;
    }

    public int sleeping() {
        Random rd = new Random();
        int min = 1;
        int max = 50;
        return min + (max - min + 1);
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (queue.remainingCapacity() == 0) {
                    System.out.println("\n******************* FILA CHEIA *******************\n");
                    break;
                }
                for (int i = 0; i <= queue.remainingCapacity(); i++) {
                    Double d = add();
                    System.out.println("Valor: " + d + ", adicionado à queue através da Thread: " + Thread.currentThread().getName());
                }
                Thread.sleep(sleeping() * 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
