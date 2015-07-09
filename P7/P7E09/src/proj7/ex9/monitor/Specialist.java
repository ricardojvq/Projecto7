package proj7.ex9.monitor;

import proj7.ex9.target.Target;

import java.util.PriorityQueue;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Specialist implements Runnable {
    static PriorityQueue<Thread> queue = new PriorityQueue<>()

    public Specialist() {
    }

    private void enter() {
        System.out.println("\nSoldier #1" + Thread.currentThread().getName() + " entering the critical zone... Wait until I get out.");
        Target.criticalZone();
    }

    private synchronized void leave() {
        System.out.println("Soldier #1" + Thread.currentThread().getName() + " exiting the critical zone...");
    }

    @Override
    public void run() {
        enter();
        leave();
    }
}
