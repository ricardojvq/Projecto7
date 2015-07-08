package proj7.ex6.a;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Consumer implements Runnable {

    public Consumer() {
    }

    @Override
    public void run() {
        try {
            Main.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 40; i++) {
            try {
                Integer itg = Main.nrs.take();
                System.out.print(itg+", ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
