package proj7.ex8.main;

import proj7.ex8.task.Specialist;
import proj7.ex8.operator.Target;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Exercicio8 {
    public static void main(String[] args) {
        final int numThreads = 10;
        Target target = new Target();

        for (int i = 0; i < numThreads; i++) {
            new Thread(new Specialist(target,i)).start();
        }

    }
}
