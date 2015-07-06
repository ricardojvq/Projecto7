package proj7.ex3;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Sequential {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stop = 0;
        Vector<Double> valores = new Vector<>();
        while (stop == 0) {
            System.out.println("[1] Introduzir\n" +
                    "[2] Sair\n");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1) {
                System.out.print("\nIntroduza um número (1, 2,5, 10, 100,51, etc..\n");
                Double temp = sc.nextDouble();
                sc.nextLine();
                valores.add(temp);
            } else {
                sc.close();
                break;
            }
        }
        long start = System.nanoTime();
        Double average = 0.0;
        for (double d:valores) {
            average += d;
        }

        average = average/(valores.size());
        System.out.println("Média: "+average);
        Double min = valores.get(0);
        Double max = 0.0;
        for (Double v:valores) {
            if (v > max) {
                max = v;
            } else if (v < min) min = v;
        }

        System.out.println("Mínimo: "+min);
        System.out.println("Máximo: "+max);
        long end = System.nanoTime();
        System.out.println("Tempo: "+(end-start)/1000000.0+" ms");

    }
}
