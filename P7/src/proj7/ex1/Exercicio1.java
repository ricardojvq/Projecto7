package proj7.ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Exercicio1 {
    public static void main(String[] args) {

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        Runnable task1 = new TaskOne();
        Runnable task2 = new TaskTwo();
        Runnable task3 = new TaskThree();
        Runnable task4 = new TaskFour();
        Runnable task5 = new TaskFive();
        Runnable task6 = new TaskSix();
        Runnable task7 = new TaskSeven();
        Runnable task8 = new TaskEight();


        Future<?> taskOne = fixedPool.submit(task1);
        Future<?> taskTwo = fixedPool.submit(task2);
        Future<?> taskThree = fixedPool.submit(task3);
        Future<?> taskFour = fixedPool.submit(task4);
        Future<?> taskFive = fixedPool.submit(task5);
        Future<?> taskSix = fixedPool.submit(task6);
        Future<?> taskSeven = fixedPool.submit(task7);
        Future<?> taskEight = fixedPool.submit(task8);

        fixedPool.shutdown();
    }
}
