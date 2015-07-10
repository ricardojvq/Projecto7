package proj7.ex9.taskPriority.task;

import proj7.ex9.taskPriority.operator.Operator;
import proj7.ex9.taskPriority.main.Exercicio9;

import java.util.Random;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Runny implements Runnable {

    private Operator operator;
    private int taskPriority;
    public static int totalTasks = 0;
    private int taskOrder;

    public Runny(Operator op) {
        operator = op;
        getPriority();
    }

    public void setTaskOrder(int taskOrder) {
        this.taskOrder = taskOrder;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public int getTaskOrder() {
        return taskOrder;
    }

    @Override
    public void run() {
        Exercicio9.THREADS_PRIORITIES.add(taskPriority);
        operator.enter(this);
        try {
            Thread.currentThread().sleep(1000);
            System.out.println("Task with priority " + taskPriority + " working...\n");
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        operator.leave();
    }

    private void getPriority() {
        Random rd = new Random();
        int min = 1;
        int max = 50;
        this.taskPriority = (min + rd.nextInt(max - min + 1));
    }
}
