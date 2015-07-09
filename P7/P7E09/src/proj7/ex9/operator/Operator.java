package proj7.ex9.operator;

import proj7.ex9.task.MyThread;
import proj7.ex9.main.Exercicio9;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Operator {
    static Integer runningThreads = 0;
    static Object monitor = new Object();

    public Operator() {
    }

    public synchronized void enter(MyThread t) {
        Exercicio9.queue.offer(t);
        if (runningThreads > 0) System.out.println("Waiting for permission: "+t.getMyPriority()+"\n");
        while (runningThreads > 0 || t != Exercicio9.queue.peek()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Exercicio9.queue.poll();
        runningThreads = 1;
        System.out.println("Entering the zone... (Priority: " + t.getMyPriority() + ")\n");
    }

    public synchronized void leave() {
        System.out.println("Leaving the zone...\n");
        runningThreads = 0;
        notifyAll();

    }
}
