package proj7.ex9.main;

import proj7.ex9.monitor.Specialist;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Exercicio9 {
    public static void main(String[] args) {
        final int numThreads = 10;

        for (int i = 0; i < numThreads; i++) {
            new Thread(new Specialist(),Integer.toString(i)).start();
        }

    }
}
