package proj7.ex10.operator;

import proj7.ex10.utils.Mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class Operator {

    private static Mutex mutex = new Mutex();

    public Operator() {
    }

    public void enter() {
        mutex.lock();
        System.out.println("[ Threads waiting in the queue... ]");
        mutex.queue();
        System.out.println("\n" + Thread.currentThread().getId() + " is entering the zone...\n");

    }

    public void leave() {
        System.out.println("\n" + Thread.currentThread().getId() + " is leaving the zone...\n");
        mutex.unlock();


    }
}
