package proj7.ex4.main;

        import proj7.ex4.actors.Consumer;
        import proj7.ex4.actors.Producer;

        import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Exercicio4 {
    public static ArrayBlockingQueue<Double> queue = new ArrayBlockingQueue<Double>(10);
    public static int flag = 0;
    public static void main(String[] args) {
        final int numThreads = 8;
        ExecutorService single = Executors.newSingleThreadExecutor();
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        single.submit(new Producer(queue));
        for (int i = 0; i < numThreads; i++) {
            pool.submit(new Consumer(queue));
        }

        pool.shutdown();
        single.shutdown();

    }
}
