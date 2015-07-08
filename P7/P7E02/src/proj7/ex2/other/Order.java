package proj7.ex2.other;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Order implements Runnable {
    public static Semaphore[] semaphores = new Semaphore[8];

    public Order() {
    }

    @Override
    public void run() {
        int threadid = Integer.parseInt(Thread.currentThread().getName());
        if (threadid == 2) {

            System.out.println("Thread #" + threadid);
            semaphores[threadid-1].release();
        } else if (threadid % 2 == 0) {
            try {
                semaphores[threadid-3-1].acquire();
                System.out.println("Thread #" + threadid);
                semaphores[threadid-1].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            try {
                semaphores[threadid].acquire();
                System.out.println("Thread #" + threadid);
                semaphores[threadid-1].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
