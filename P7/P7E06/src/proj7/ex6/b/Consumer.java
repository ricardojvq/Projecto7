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
            System.out.println("[ CONSUMER ] A preparar para dar permissão para produzir...\n");
            Exercicio6b.firstLatch.countDown();
            System.out.println("[ CONSUMER ] Permissão garantida!\n");
            Exercicio6b.secondLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n[ CONSUMER ] Showing the numbers: \n");
        for (int i = 0; i < 40; i++) {
            try {

                Integer itg = Exercicio6b.nrs.take();
                System.out.print(itg+", ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println();

    }
}
