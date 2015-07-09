package proj7.ex5.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Cyc {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Pong!\n");
            }
        });

        new Thread(() -> {
            while (true) {
                System.out.println("Ping!\n");
                try {
                    barrier.await();
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }
}
