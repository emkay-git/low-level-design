package mohit.learn.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LoggerImpl implements Logger {

    private Map<String, Process> processMap;
    private PriorityBlockingQueue<Process> processTimeQueue;
    private Comparator<Process> processComparator = (Process p1, Process p2) -> (p1.getStartTime().longValue() - p2.getStartTime().longValue()) > 0 ? 1 : -1;

    private ReentrantLock lock;
    private Condition isQueueEmpty;
    private Condition hasItemRemoved;

    LoggerImpl() {
        lock = new ReentrantLock();

        processMap = new HashMap<>();
        processTimeQueue = new PriorityBlockingQueue<Process>(10, processComparator);
        isQueueEmpty = lock.newCondition();
    }

    @Override
    public void addProcess(String processId) {
        Process currentProcess = new Process();
        currentProcess.setStartTime(System.currentTimeMillis());
        currentProcess.setProcessId(processId);
        processMap.put(processId, currentProcess);
        processTimeQueue.add(currentProcess);
        isQueueEmpty.signal();
    }

    @Override
    public void endProcess(String processId) {

        Process currentProcess = processMap.get(processId);
        currentProcess.setEndTime(System.currentTimeMillis());
        processMap.remove(processId);
        hasItemRemoved.signal();
    }




    @Override
    public void pollProcess() throws InterruptedException {
        try {
            lock.lock();
            while (processTimeQueue.size() == 0) isQueueEmpty.await();

            while(processTimeQueue.size()>0) {
                Process currentProcess = processTimeQueue.peek();
                if (currentProcess.getEndTime() != null) {
                    System.out.println(currentProcess.getProcessId());
                    processTimeQueue.take();
                    System.out.println(
                            "Process id is " + currentProcess.getProcessId() +
                                    " starts at " + currentProcess.getStartTime() +
                                    "ends at " + currentProcess.getEndTime());
                } else {
                    hasItemRemoved.await();
                }
            }


        } finally {
            lock.unlock();
        }


    }
}
