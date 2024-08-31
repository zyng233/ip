package popi.command;

import popi.command.*;
import popi.exception.PopiException;
import popi.exception.UnknownCommandException;

public class Parser {
    public static Command parse(String input) throws PopiException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        return switch (command) {
            case "bye" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(input);
            case "unmark" -> new UnmarkCommand(input);
            case "delete" -> new DeleteCommand(input);
            case "todo", "deadline", "event" -> new AddCommand(input);
            case "find" -> new FindCommand(input);
            default -> throw new UnknownCommandException();
        };
    }
}
