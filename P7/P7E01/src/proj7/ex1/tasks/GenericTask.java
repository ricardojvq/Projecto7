package proj7.ex1.tasks;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class GenericTask implements Runnable {

    public GenericTask() {}

    @Override
    public void run() {
        System.out.println("Hello World, I am thread "+Thread.currentThread().getId()+" running Task Eight");
    }
}
