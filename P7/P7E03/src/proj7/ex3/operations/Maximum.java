package proj7.ex3.operations;

import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Maximum implements Callable<Double> {
    private Double[] vector;

    public Maximum(Double[] vector) {
        this.vector = vector;
    }

    @Override
    public Double call() throws Exception {
        Double max = 0.0;
        for (double valor:vector) {
            if (valor > max) max = valor;
        }
        System.out.println("Máximo: "+max);
        return max;
    }
}
