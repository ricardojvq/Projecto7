package proj7.ex10.utils;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Mutex {
    private static MyAQS sync = new MyAQS();

    public Mutex() {
    }

    public void lock() {
        sync.acquire(0);
    }


    public void unlock() {
        sync.release(0);
    }

    public void queue() {
        System.out.print("[ ");
        sync.getQueuedThreads().stream().forEach(e -> System.out.print(e.getId()+", "));
        System.out.print(" HEAD ]\n");
    }
}
