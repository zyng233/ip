package popi.exception;

import popi.exception.PopiException;

public class UnknownCommandException extends PopiException {
    public UnknownCommandException() {
        super("☹ OOPS!!! Please provide a valid command!");
    }
}
