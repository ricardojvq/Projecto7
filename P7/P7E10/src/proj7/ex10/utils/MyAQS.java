package proj7.ex10.utils;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class MyAQS extends AbstractQueuedSynchronizer {

    protected MyAQS() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        if (hasQueuedPredecessors()) {
            return false;
        } else if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }
}
