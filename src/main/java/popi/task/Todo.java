package popi.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description, null);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    protected String getType() {
        return "T";
    }
}
