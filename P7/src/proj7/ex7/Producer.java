package proj7.ex7;

import java.util.Random;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Producer implements Runnable {

    public Producer() {
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 1; i < 10; i++) {
                System.out.println(Thread.currentThread().getId() + " a correr pela "+i+"ª vez!");
            }
        }
    }
}
