package proj7.ex8.operator;

import java.util.Random;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Target {

    private int order = 1;
    private int increment = 0;
    private boolean activeThread = false;

    public Target() {
    }

    public void enter() {
        int myTime = ++increment;
        synchronized (this) {
            System.out.println("[ Specialist " + myTime + " is waiting for its turn.. ]");
            while (order != myTime || activeThread) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        activeThread = true;
        try {
            Thread.sleep(5 * (new Random().nextInt(100)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSpecialist is entering the critical zone... (Order: " + myTime + ")\n");
    }

    public void leave() {
        synchronized (this) {
            System.out.println("\nSpecialist is leaving the critical zone...\n" +
                    "\n################\n");

            order++;
            activeThread = false;
            notifyAll();
        }
    }


}
