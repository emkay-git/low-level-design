package mohit.learn.java.lock;

public class CustomReentrant {
    private boolean flag = false;
    private Thread lockedBy;
    private int count = 0;

    public void getLock() throws InterruptedException {
        synchronized (this) {

            while(flag&&lockedBy!=null&&!lockedBy.equals(Thread.currentThread())) {
                this.wait();
            }

            System.out.println("Reentrant Lock acquired by "+Thread.currentThread().getName());
            flag = true;
            count++;
            lockedBy = Thread.currentThread();
        }
    }

    public void releaseLock() {
        synchronized (this) {
            this.flag = false;
            if(lockedBy == Thread.currentThread()) count--;
            if(count==0) {
                lockedBy = null;
                this.notifyAll();
            }
        }
    }
}
