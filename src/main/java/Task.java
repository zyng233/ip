import java.time.LocalDateTime;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected LocalDateTime time;

    public Task(String description, LocalDateTime time) {
        this.description = description;
        this.time = time;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

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

    public String toDataString() {
        return getType() + " | " + (isDone ? "1" : "0") + " | " + this.description;
    }
}

