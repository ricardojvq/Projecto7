package proj7.ex7.main;

import proj7.ex7.actors.Consumer;
import proj7.ex7.actors.Producer;

import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Exercicio7 {
    public static ArrayBlockingQueue<Integer> lista = new ArrayBlockingQueue<Integer>(8);
    public static void main(String[] args) {
        final int numThreads = 4;

        for (int i = 0; i < numThreads; i++) {
            new Thread(new Producer()).start();
        }


    }
}
