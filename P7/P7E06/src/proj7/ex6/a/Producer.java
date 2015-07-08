package proj7.ex6.a;

import java.util.Random;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Producer implements Runnable {

    public Producer() {
    }

    @Override
    public void run() {
        Random sleeprd = new Random();
        int minSleep = 10;
        int maxSleep = 1000;
        int sleepTime = minSleep + sleeprd.nextInt(maxSleep - minSleep + 1);
        try {
            Thread.currentThread().sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            Random rd = new Random();
            int min = 1;
            int max = 1000;
            Integer r = min + rd.nextInt(max - min + 1);
            try {
                Exercicio6a.nrs.put(r);
                System.out.println("[ PRODUCER ] Número " + r + " adicionado à lista. ("+Thread.currentThread().getName()+")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Exercicio6a.latch.countDown();
    }
}
