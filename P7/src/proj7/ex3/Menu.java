package proj7.ex3;

import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Menu {
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
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Runnable r1 = new Minimum(valores);
        Runnable r2 = new Maximum(valores);
        Future<?> f1 = pool.submit(r1);
        Future<?> f2 = pool.submit(r2);
        long end = System.nanoTime();
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Tempo: "+(end-start)/1000000.0+" ms");
            }
        };
        Future<?> f3 = pool.submit(r3);
        pool.shutdown();

    }
}
