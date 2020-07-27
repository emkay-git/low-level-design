package mohit.learn.java.lock;

public class Resources {

    int val = 0;
    CustomMutex cm = new CustomMutex();
    CustomReentrant cr = new CustomReentrant();

    CustomReadWrite crw = new CustomReadWrite();

    public int getResources() throws InterruptedException {
        return val;
    }

    public void setResources(int val) throws InterruptedException {
        cm.getLock();
        Thread.sleep(3000);
        this.val = val;
        cm.releaseLock();
    }

    public void printResource() {
        System.out.println(val);
    }

    public void recursiveResource(int t) throws InterruptedException {
        if(t==0) return;

        cr.getLock();
        System.out.println("Test "+t);
        recursiveResource(t-1);
        cr.releaseLock();
    }

    public void frequentReadResource() throws  InterruptedException {
        crw.getReadLock();
        System.out.println("I am read resource and called by "+Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println("I am read resource and ended by "+Thread.currentThread().getName());
        crw.releaseReadLock();
    }

    public void writeResource() throws InterruptedException {
        crw.getWriteLock();
        System.out.println("I am write resource and called by "+Thread.currentThread().getName());
        Thread.sleep(10000);
        System.out.println("I am read resource and ended by "+Thread.currentThread().getName());
        crw.releaseWriteLock();

    }
}
