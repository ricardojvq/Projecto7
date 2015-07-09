package proj7.ex3.operations;

import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Minimum implements Callable<Double> {
    private Double[] vector;

    public Minimum(Double[] v) {
        this.vector = v;
    }

    @Override
    public Double call() throws Exception {
        Double min = vector[0];
        for (double valor:vector) {
            if (valor < min) min = valor;
        }
        System.out.println("Mínimo: "+min);
        return min;
    }
}
