package popi.exception;

/**
 * Represents an exception that occurs when a task is not found.
 */
public class TaskNotFoundException extends PopiException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
