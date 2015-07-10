package proj7.ex10.main;

import proj7.ex10.operator.Operator;
import proj7.ex10.task.Runny;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Exercicio10 {

    public static void main(String[] args) {
        Operator operator = new Operator();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runny(operator));
            t.start();

        }

    }
}
