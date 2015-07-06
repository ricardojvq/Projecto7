package proj7.ex1;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class TaskThree implements Runnable {

    public TaskThree() {}

    @Override
    public void run() {
        System.out.println("Hello World, I am thread "+Thread.currentThread().getId()+" running Task Three");
    }
}
