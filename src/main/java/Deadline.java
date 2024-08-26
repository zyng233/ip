public class Deadline extends Task {
    protected String end;
    public Deadline(String description, String end) {
        super(description);
        this.end = end;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.end + ")";
    }
}
