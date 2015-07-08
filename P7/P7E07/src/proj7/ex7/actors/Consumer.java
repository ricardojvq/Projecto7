package proj7.ex7.actors;

import proj7.ex7.main.Exercicio7;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Consumer implements Runnable {

    public Consumer() {
    }

    @Override
    public void run() {
        int s = Exercicio7.lista.size();
        for (int i = 0; i < s; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("\n ***************** "+Exercicio7.lista.take()+" COOKIES!! Nom Nom Nom Nom Nom Nom *****************\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n No more cookies... Restarting production!\n");
    }
}
