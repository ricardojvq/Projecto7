package proj7.ex7.actors;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Producer implements Runnable {

    public Producer() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 2; j++) {
                System.out.println("Producing cookies..." + " (" + Thread.currentThread().getId() + ")");
                Random rd = new Random();
                int min = 1;
                int max = 100000000;
                Integer r = min + rd.nextInt(max - min + 1);
                try {
                    Main.lista.put(r);
                } catch (InterruptedException e) {
                    System.out.println("Cookies' production stoped...");
                }
            }

            System.out.println("Waiting for other Cookies' producers...");

            try {
                Main.barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("No more cookies... Restarting production!");
        }

    }
}
