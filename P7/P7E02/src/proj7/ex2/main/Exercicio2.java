package proj7.ex2.main;

import proj7.ex2.other.Order;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Exercicio2 {
    public static void main(String[] args) {
        final int nrTotal = 8;

        for (int i = 0; i < 8; i++) {
            Order.semaphores[i] = new Semaphore(0);
        }
        for (int i = 1; i <= nrTotal; i++) {
            new Thread(new Order(),Integer.toString(i)).start();
        }



    }
}
