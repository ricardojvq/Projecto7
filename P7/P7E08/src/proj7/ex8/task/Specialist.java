package proj7.ex8.task;

import proj7.ex8.operator.Target;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Specialist implements Runnable {
    private Target target;
    private int order;

    public Specialist(Target target, int order) {
        this.target = target;
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public void run() {
        target.enter();
        try {
            Thread.sleep(500);
            System.out.println("\nSpecialist " + (order + 1) + " is doing some work...\n");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        target.leave();
    }
}
