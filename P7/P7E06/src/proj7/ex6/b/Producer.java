package proj7.ex6.b;

import java.util.Random;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Producer implements Runnable {

    public Producer() {
    }

    @Override
    public void run() {
        try {
            Exercicio6b.firstLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            Random rd = new Random();
            int min = 1;
            int max = 1000;
            Integer r = min + rd.nextInt(max - min + 1);
            try {
                Exercicio6b.nrs.put(r);
                System.out.println("[ PRODUCER ] Número " + r + " adicionado à lista. ("+Thread.currentThread().getName()+")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Exercicio6b.secondLatch.countDown();
    }
}
