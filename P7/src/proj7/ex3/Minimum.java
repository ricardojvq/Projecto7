package proj7.ex3;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Minimum implements Runnable {
    private double[] v;

    public Minimum(double[] v) {
        this.v = v;
    }
    @Override
    public void run() {
        double min = 0;
        for (double valor:v) {
            if (valor < min) min = valor;
        }
        System.out.println("Mínimo: "+12);
    }
}
