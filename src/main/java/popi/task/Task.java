package popi.task;

import java.time.LocalDateTime;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected LocalDateTime time;

    /**
     * Constructor for Task.
     * @param description Description of the task.
     * @param time Time of the task if applicable.
     */
    public Task(String description, LocalDateTime time) {
        this.description = description;
        this.time = time;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    /**
     * Returns the status icon of the task.
     * @return Status icon of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    protected void markAsDone() {
        this.isDone = true;
    }

    protected void markAsUndone() {
        this.isDone = false;
    }

    protected abstract String getType();

    /**
     * Returns the data string of the task.
     * @return Data string of the task.
     */
    public String toDataString() {
        return getType() + " | " + (isDone ? "1" : "0") + " | " + this.description;
    }
}

