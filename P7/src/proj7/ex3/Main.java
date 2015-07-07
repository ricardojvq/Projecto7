package proj7.ex3;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Main {
    public static void main(String[] args) {

        Double[] vector = new Double[getRandom()];
        System.out.println("Tamanho do Array: "+vector.length);
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < vector.length; i++) {
            Random dRd = new Random();
            Double min = 1.0;
            Double max = 10000000.0;
            Double r = min + dRd.nextDouble()*(max - min);
            vector[i] = r;
        }

        // Sequencial
        new Thread(new Sequential(vector,semaphore)).start();

        // Paralelo
        new Thread(new Paralelo(vector,semaphore)).start();
        





    }

    public static int getRandom() {
        Random rd = new Random();
        int min = 10;
        int max = 1000000;
        return min + rd.nextInt(max - min + 1);

    }
}
