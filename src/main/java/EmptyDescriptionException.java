public class EmptyDescriptionException extends Exception {
    public EmptyDescriptionException(String task) {
        super("☹ OOPS!!! Please provide a description for the " + task + ".");
    }
}
