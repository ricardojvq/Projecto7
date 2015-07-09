package proj7.ex9.task;

/**
 * Created by ricardoquirino on 09/07/15.
 */
public class MyThread extends Thread {
    private Integer myPriority;

    public MyThread(Integer myPriority) {
        this.myPriority = myPriority;
    }

    public MyThread(Runnable target, Integer myPriority) {
        super(target);
        this.myPriority = myPriority;
    }

    public Integer getMyPriority() {
        return myPriority;
    }

    public void setMyPriority(Integer myPriority) {
        this.myPriority = myPriority;
    }

    @Override
    public String toString() {
        return "Prioridade: "+myPriority;
    }
}
