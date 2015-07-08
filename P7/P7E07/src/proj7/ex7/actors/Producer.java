package proj7.ex7.actors;

import proj7.ex7.main.Exercicio7;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Producer implements Runnable {

    private static CyclicBarrier b;
    static Object monitor = new Object();

    public Producer() {
        b = new CyclicBarrier(4, new Consumer());
    }

    public int sleeping() {
        Random rd = new Random();
        int min = 10;
        int max = 1000;
        return min + (max - min + 1);
    }

    @Override
    public void run() {
        try {
            Random rd = new Random();
            int min = 10;
            int max = 1000;
            int sleepTime = min + rd.nextInt(max - min + 1);
            Thread.currentThread().sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Producing cookies... #" + (i + 1) + " batch " + " (" + Thread.currentThread().getId() + ")");
                Random rd = new Random();
                int min = 1;
                int max = 100000000;
                Integer r = min + rd.nextInt(max - min + 1);
                try {
                    Exercicio7.lista.put(r);
                } catch (InterruptedException e) {
                    System.out.println("Cookies' production stoped...");
                }
                synchronized (monitor) {
                    if (b.getNumberWaiting() < 3)
                        System.out.println("Waiting for other Cookies' producers...");
                    if (b.getNumberWaiting() == 3) {
                        System.out.println("(!) Last batch");
                    }
                }

                try {
                    b.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
