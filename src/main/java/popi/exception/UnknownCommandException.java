package popi.exception;

/**
 * Represents an exception thrown when an unknown command is provided.
 */
public class UnknownCommandException extends PopiException {
    public UnknownCommandException() {
        super("☹ OOPS!!! Please provide a valid command!");
    }
}
