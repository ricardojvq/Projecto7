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
            System.out.println("\n[ CONSUMER ] Waiting for the numbers...\n");
            Exercicio6a.latch.await();
            System.out.println("\n[ CONSUMER ] Showing the numbers: \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 40; i++) {
            try {
                Integer itg = Exercicio6a.nrs.take();
                System.out.print(itg+", ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("\n");

    }
}
