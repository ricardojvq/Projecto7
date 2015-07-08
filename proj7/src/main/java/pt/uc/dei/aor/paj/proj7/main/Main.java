package pt.uc.dei.aor.paj.proj7.main;

import pt.uc.dei.aor.paj.proj7.runnables.Paralelo;
import pt.uc.dei.aor.paj.proj7.runnables.Sequential;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class Main {
    public static Double[][] stats = new Double[1][3];
    public static int globalCount = 0;
    public static Semaphore semaphore = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException {

        if (args.length == 2 && args[0].equals("-n")) {
            if (isNumber(args[1])) {
                int s = Integer.parseInt(args[1]);
                int count = 0;
                Thread.sleep(1000);
                stats[globalCount][0] = s * 1.0;
                Double[] vector = new Double[s];
                System.out.println("Tamanho do Array: " + vector.length + "\n");

                for (int j = 0; j < vector.length; j++) {
                    Random dRd = new Random();
                    Double min = 100.0;
                    Double max = 10000000.0;
                    Double r = min + dRd.nextDouble() * (max - min);
                    vector[j] = r;
                }
                // Sequencial
                Thread ts = new Thread(new Sequential(vector));
                // Paralelo
                Thread tp = new Thread(new Paralelo(vector));
                ts.start();
                tp.start();
                while (ts.isAlive() && tp.isAlive()) {
                    // do Nothing
                }
                Thread.sleep(2000);
                globalCount++;
                System.out.println("\n\n ************************************** \n\n");

                System.out.println("\n***************\nEstatísticas\n***************\n");
                System.out.print("[ ");
                System.out.format("%-14s", "Tam. Array");
                System.out.print(" ]\t");
                System.out.print("[ ");
                System.out.format("%-14s", "Sequenc. (ms)");
                System.out.print(" ]\t");
                System.out.print("[ ");
                System.out.format("%-14s", "Paralelo (ms)");
                System.out.print(" ]");
                System.out.println();
                for (int row = 0; row < stats.length; row++) {

                    for (int column = 0; column < stats[row].length; column++) {
                        System.out.print("[ ");
                        System.out.format("%-14s", Double.toString(stats[row][column]));
                        System.out.print(" ]\t");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Parâmetro introduzido como número não é valido.\n" +
                        "Correcto: 'java -jar ficheiro.jar -n 12'");
            }
        } else {
            System.out.println("\n\n## Como usar: \n" +
                    "'java -jar ficheiro.jar -n <quantidade_de_numeros>\n" +
                    "Por exemplo: 'java -jar ficheiro.jar -n 10'");
        }






    }

    public static int getRandom() {
        Random rd = new Random();
        int min = 10;
        int max = 1000000;
        return min + rd.nextInt(max - min + 1);

    }

    public static boolean isNumber(String s) {
        try {
            int n = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
