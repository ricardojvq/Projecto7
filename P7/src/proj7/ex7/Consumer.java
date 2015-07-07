package proj7.ex7;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Consumer implements Runnable {

    public Consumer() {
    }

    @Override
    public void run() {
        int s = Main.lista.size();
        for (int i = 0; i < s; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Main.lista.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n\n ***************** COOKIES!! Nom Nom Nom Nom Nom Nom *****************\n\n");
        }
    }
}
