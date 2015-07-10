package proj7.ex9.taskPriority.main;

import proj7.ex9.taskPriority.operator.Operator;
import proj7.ex9.taskPriority.task.Runny;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Exercicio9 {
    static final int NUM_THREADS = 10;
    public static List<Integer> THREADS_PRIORITIES = new ArrayList<>();

    public static PriorityQueue<Runny> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1.getTaskPriority() > o2.getTaskPriority()) return 1;
        if (o1.getTaskPriority() < o2.getTaskPriority()) return -1;
        if (o1.getTaskOrder() > o2.getTaskOrder()) return 1;
        if (o1.getTaskOrder() < o2.getTaskOrder()) return -1;
        else return 0;
    });

    public static void main(String[] args) {
        Operator operator = new Operator();

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        List<Future> lf = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            Future<?> f = pool.submit(new Runny(operator));
            lf.add(f);
        }

        for (Future f:lf) {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
        System.out.print("Task priorities: \n[ ");
        THREADS_PRIORITIES.stream().forEach(e -> System.out.print(e + ", "));
        System.out.print("]\n");


    }

    public static Integer randomP() {
        Random rd = new Random();
        int min = 1;
        int max = 50;
        return (min + rd.nextInt(max - min + 1));
    }
}
