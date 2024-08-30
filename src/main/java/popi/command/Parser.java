package popi.command;

import popi.command.*;
import popi.exception.PopiException;
import popi.exception.UnknownCommandException;

public class Parser {

    /**
     * Parses the input and returns the corresponding Command object.
     * @param input The input to be parsed.
     * @return The Command object corresponding to the input.
     * @throws PopiException If the input is invalid.
     */
    public static Command parse(String input) throws PopiException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        return switch (command) {
            case "bye" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(Integer.parseInt(parts[1]));
            case "unmark" -> new UnmarkCommand(Integer.parseInt(parts[1]));
            case "delete" -> new DeleteCommand(Integer.parseInt(parts[1]));
            case "todo", "deadline", "event" -> new AddCommand(input);
            default -> throw new UnknownCommandException();
        };
    }
}
