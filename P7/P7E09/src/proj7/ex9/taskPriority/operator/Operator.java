package proj7.ex9.taskPriority.operator;

import proj7.ex9.taskPriority.main.Exercicio9;
import proj7.ex9.taskPriority.task.Runny;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Operator {
    static Integer runningThreads = 0;
    static Object monitor = new Object();

    public Operator() {
    }

    public synchronized void enter(Runny r) {
        Exercicio9.queue.offer(r);
        Runny.totalTasks++;
        r.setTaskOrder(Runny.totalTasks);
        if (runningThreads > 0) System.out.println("Task with priority "+r.getTaskPriority()+" is waiting for permission... \n");
        while (runningThreads > 0 || r != Exercicio9.queue.peek()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Exercicio9.queue.poll();
        runningThreads = 1;
        System.out.println("Entering the zone... (Priority: " + r.getTaskPriority() + ")\n" +
                "(Order: "+r.getTaskOrder()+")\n");
    }

    public synchronized void leave() {
        System.out.println("Leaving the zone...\n");
        runningThreads = 0;
        notifyAll();

    }
}
