package mohit.learn.java;

public interface Logger {

    void addProcess(String processId);

    void endProcess(String processId);

    void pollProcess() throws InterruptedException;
}
