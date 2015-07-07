package proj7.ex6.b;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Consumer implements Runnable {

    public Consumer() {
    }

    @Override
    public void run() {
        try {
            System.out.println("À espera de permissão...\n\n");
            Main.firstLatch.countDown();
            System.out.println("Permissão garantida!\n\n");
            Main.secondLatch.await();
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
