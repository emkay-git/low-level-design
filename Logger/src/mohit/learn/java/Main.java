package mohit.learn.java;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LoggerImpl logger = new LoggerImpl();

        logger.addProcess("1");
        Thread.sleep(1000);
        logger.addProcess("2");
        logger.endProcess("2");
        Thread.sleep(1000);
        logger.addProcess("3");
        logger.endProcess("1");
        logger.endProcess("3");

        new Thread(() -> {
            while(true) {
                try {
                    logger.pollProcess();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Logger").start();

    }
}
