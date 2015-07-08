package proj7.ex5.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class PPRun implements Runnable {
    private Exchanger<String> exchanger;
    private String message;

    public PPRun(Exchanger<String> ex, String msg) {
        exchanger = ex;
        message = msg;
    }

    @Override
    public void run() {
        try {
            System.out.println(message);
            message = exchanger.exchange(message);
            System.out.println(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
