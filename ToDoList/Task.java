package todolist;

public class Task {

    private String task;
    private PriorityLevel priority;

    public enum PriorityLevel {
        LOW, NORMAL, HIGH
    }

    public Task(String task, PriorityLevel priority) {
        this.task = task;
        this.priority = priority;
    }

    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return getTask();

    }
}
