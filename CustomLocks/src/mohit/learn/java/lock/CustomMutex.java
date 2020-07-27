package mohit.learn.java.lock;

public class CustomMutex {
    boolean flag = false;
    public void getLock() throws InterruptedException {
        synchronized (this) {
            while(flag) {
               this.wait();
            }
            System.out.println(Thread.currentThread().getName());
            flag = true;
        }
    }

    public void releaseLock() {
        synchronized (this) {
            this.flag = false;
            this.notifyAll();
        }
    }
}
