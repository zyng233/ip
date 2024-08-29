public class Deadline extends Task {
    protected String end;
    public Deadline(String description, String end) {
        super(description);
        this.end = end;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.end + ")";
    }

    @Override
    protected String getType() {
        return "D";
    }

    @Override
    public String toDataString() {
        return getType() + " | " + (isDone ? "1" : "0") + " | " + this.description + " | " + this.end;
    }
}
