package proj7.ex7;

import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Main {
    public static void main(String[] args) {
        Runnable b1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("\n\n****** Primeira Barreira ******");
            }
        };

        Runnable b2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("\n\n****** Segunda Barreira ******");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(4,b1);
        CyclicBarrier barrier2 = new CyclicBarrier(4,b2);





    }
}
