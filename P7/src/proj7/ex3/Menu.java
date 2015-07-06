package proj7.ex3;

import java.util.Scanner;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stop = 0;
        double[] valores = new double[10];
        int size = 0;
        while (stop == 0) {
            if (size == valores.length) break;
            else {
                System.out.println("[1] Introduzir\n" +
                        "[2] Sair\n");
                if (stop == 1) {
                    System.out.print("\nIntroduza um número (1, 2.5, 10, 100.51, etc..\n");
                    sc.nextDouble();
                    sc.nextLine();
                } else {
                    sc.close();
                }

            }
        }

        double average = 0;
        for (double d:valores) {
            average += d;
        }

        average = average/(valores.length);


    }
}
