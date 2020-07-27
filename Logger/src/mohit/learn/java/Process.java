package mohit.learn.java;

import java.util.Objects;

public class Process {

    private String processId;
    private Long startTime;
    private Long endTime;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Process)) return false;
        Process process = (Process) o;
        return processId.equals(process.processId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processId);
    }
}
