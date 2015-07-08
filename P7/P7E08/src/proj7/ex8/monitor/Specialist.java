package proj7.ex8.monitor;

import proj7.ex8.target.Target;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Specialist implements Runnable {
    static Object monitor = new Object();
    static Integer count = 0;

    public Specialist() {
    }

    private void enter() {
        System.out.println("\nSoldier #1" + Thread.currentThread().getName() + " entering the critical zone... Wait until I get out.");
        Target.criticalZone();
    }

    private synchronized void leave() {
        System.out.println("Soldier #1" + Thread.currentThread().getName() + " exiting the critical zone...");
        count++;
        monitor.notifyAll();
    }

    @Override
    public void run() {
        synchronized (monitor) {
            while (!Thread.currentThread().getName().equals(count.toString())) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.currentThread().sleep(1000*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enter();
            leave();
        }
    }
}
