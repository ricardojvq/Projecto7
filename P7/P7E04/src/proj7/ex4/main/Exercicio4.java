package proj7.ex4.main;

        import proj7.ex4.Consumer;
        import proj7.ex4.Producer;

        import java.util.Random;
        import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Exercicio4 {
    static ArrayBlockingQueue<Double> queue = new ArrayBlockingQueue<Double>(10);
    public static void main(String[] args) {
        final int numThreads = 8;
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        for (int i = 0; i < numThreads; i++) {
            pool.submit(consumer);
        }


    }
}
