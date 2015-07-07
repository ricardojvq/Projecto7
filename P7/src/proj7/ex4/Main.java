package proj7.ex4;

        import java.util.Random;
        import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Main {
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
