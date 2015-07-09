package proj7.ex8.monitor;

import proj7.ex8.target.Target;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Specialist implements Runnable {
    static Object monitor = new Object();
    static Integer count = 0;
    static PriorityQueue<Thread> queue = new PriorityQueue<>();

    public Specialist() {
    }

    private void enter(int priority) {

        System.out.println("\nSoldier #1" + Thread.currentThread().getName() + " entering the critical zone... Wait until I get out.");
        Target.criticalZone();
    }

    private synchronized void leave() {
        System.out.println("Soldier #1" + Thread.currentThread().getName() + " exiting the critical zone...");
        count++;
        monitor.notifyAll();
    }

    private synchronized int priority() {
        Random rd = new Random();
        int min = 1;
        int max = 20;
        return (min + rd.nextInt(max - min + 1));
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
            enter(1);
            leave();
        }
    }
}
