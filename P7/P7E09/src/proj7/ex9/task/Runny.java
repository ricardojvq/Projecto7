package proj7.ex9.task;

import proj7.ex9.operator.Operator;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Runny implements Runnable {

    private Operator operator;

    public Runny(Operator op) {
        operator = op;
    }

    @Override
    public void run() {
        operator.enter((MyThread) Thread.currentThread());
        try {
            Thread.currentThread().sleep(1000);
            System.out.println("Task with priority " + ((MyThread) (Thread.currentThread())).getMyPriority() + " working...\n");
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        operator.leave();
    }
}
