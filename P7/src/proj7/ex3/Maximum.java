package proj7.ex3;

import java.util.Vector;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Maximum implements Runnable {
    private Vector<Double> v;

    public Maximum(Vector<Double> v) {
        this.v = v;
    }
    @Override
    public void run() {
        Double max = 0.0;
        for (double valor:v) {
            if (valor > max) max = valor;
        }
        System.out.println("Máximo: "+max);
    }
}
