package proj7.ex7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class CyclicBarrierRunnable implements Runnable {
    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            this.barrier1.await();
            System.out.println(Thread.currentThread().getId() + " à esperra na primeira barreira");
            Thread.sleep(1*1000);

            this.barrier2.await();
            System.out.println(Thread.currentThread().getId() + " à esperra na segunda barreira");
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }
}
