package proj7.ex3;

import java.util.Vector;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Minimum implements Runnable {
    private Vector<Double> v;

    public Minimum(Vector<Double> v) {
        this.v = v;
    }
    @Override
    public void run() {
        Double min = v.get(0);
        for (double valor:v) {
            if (valor < min) min = valor;
        }
        System.out.println("Mínimo: "+min);
    }
}
