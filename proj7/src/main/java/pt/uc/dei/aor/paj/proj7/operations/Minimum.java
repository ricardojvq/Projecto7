package pt.uc.dei.aor.paj.proj7.operations;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Minimum implements Runnable {
    private Double[] vector;

    public Minimum(Double[] v) {
        this.vector = v;
    }
    @Override
    public void run() {
        Double min = vector[0];
        for (double valor:vector) {
            if (valor < min) min = valor;
        }
        System.out.println("Mínimo: "+min);
    }
}
