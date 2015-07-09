package proj7.ex9.main;

import proj7.ex9.task.MyThread;
import proj7.ex9.operator.Operator;
import proj7.ex9.task.Runny;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by ricardoquirino on 08/07/15.
 */
public class Exercicio9 {

    public static PriorityQueue<MyThread> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1.getMyPriority() > o2.getMyPriority()) return 1;
        if (o1.getMyPriority() < o2.getMyPriority()) return -1;
        else return 0;
    });

    public static void main(String[] args) {
        Operator operator = new Operator();

        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread(new Runny(operator),randomP());
            t.start();

        }


    }

    public static Integer randomP() {
        Random rd = new Random();
        int min = 1;
        int max = 50;
        return (min + rd.nextInt(max - min + 1));
    }
}
