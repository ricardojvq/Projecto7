package proj7.ex10.task;

import proj7.ex10.operator.Operator;

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
        operator.enter();
        System.out.println("Thread " + Thread.currentThread().getId() + " is working...");
        try {
            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        operator.leave();


    }
}
