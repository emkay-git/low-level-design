package mohit.learn.java.lock;


public class CustomReadWrite {

    private boolean readLock = false;
    private boolean writeLock = false;
    private int readCount = 0;
    public void getReadLock() throws InterruptedException {
        synchronized (this) {
            while (writeLock) {
                this.wait();
            }
            readCount++;
//            writeLock = true;
            readLock = true;
        }
    }

    public void getWriteLock() throws InterruptedException {
       synchronized (this) {
           while(readLock||writeLock) {
               this.wait();
           }

           readLock = true;
           writeLock = true;

       }
    }

    public void releaseReadLock() {
       synchronized (this) {
           readCount--;
           if(readCount==0) {
               readLock = false;
               writeLock = false;
           }
           this.notifyAll();
       }
    }

    public void releaseWriteLock() {
        synchronized (this) {
            readLock = false;
            writeLock = false;
            this.notifyAll();
        }
    }
}
