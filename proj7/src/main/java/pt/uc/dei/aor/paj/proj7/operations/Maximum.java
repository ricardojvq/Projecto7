package pt.uc.dei.aor.paj.proj7.operations;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Maximum implements Runnable {
    private Double[] vector;

    public Maximum(Double[] vector) {
        this.vector = vector;
    }
    @Override
    public void run() {
        Double max = 0.0;
        for (double valor:vector) {
            if (valor > max) max = valor;
        }
        System.out.println("Máximo: "+max);
    }
}
