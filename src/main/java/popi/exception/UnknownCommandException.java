package popi.exception;

/**
 * Represents an exception thrown when an unknown command is provided.
 */
public class UnknownCommandException extends PopiException {
    public UnknownCommandException() {
        super("Popi does not understand this command. Please try again.");
    }
}
