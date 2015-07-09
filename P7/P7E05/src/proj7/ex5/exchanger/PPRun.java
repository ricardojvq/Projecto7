package proj7.ex5.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by ricardoquirino on 07/07/15.
 */
public class PPRun implements Runnable {
    private Exchanger<Boolean> exchanger;
    private String message;
    private boolean write = true;

    public PPRun(Exchanger<Boolean> ex, String msg, boolean write) {
        exchanger = ex;
        message = msg;
        this.write = write;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                if (write) System.out.println(message+" ("+Thread.currentThread().getId()+")");
                write = exchanger.exchange(write);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
