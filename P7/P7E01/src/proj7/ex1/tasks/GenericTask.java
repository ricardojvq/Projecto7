package proj7.ex1.tasks;

import proj7.ex1.main.Exercicio1;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class GenericTask implements Runnable {

    public GenericTask() {}

    @Override
    public synchronized void run() {
        try {
            System.out.println("Hello World, I am thread "+Thread.currentThread().getId()+" running Task "+ Exercicio1.count.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
