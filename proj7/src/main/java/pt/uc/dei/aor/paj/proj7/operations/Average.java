package pt.uc.dei.aor.paj.proj7.operations;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Average implements Runnable {

    private int[] array;

    public Average(int[] v) {
        array = v;
    }

    public void getAverage() {
        int sum = 0;
        for (int i:array) {
            sum += i;
        }

        System.out.println("");
    }

    @Override
    public void run() {

    }
}
