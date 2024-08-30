package popi.command;

import popi.exception.EmptyDescriptionException;
import popi.exception.InvalidTimeFormatException;
import popi.exception.PopiException;
import popi.exception.UnknownCommandException;
import popi.task.*;
import popi.ui.Ui;
import popi.utils.DateTimeUtils;

import java.time.LocalDateTime;

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(String command) throws EmptyDescriptionException, InvalidTimeFormatException, UnknownCommandException {
        if (command == null || command.trim().isEmpty()) {
            throw new UnknownCommandException();
        }

        String[] parts = command.split(" ", 2);
        if (parts.length < 2) {
            throw new EmptyDescriptionException("The description of a task cannot be empty.");
        }
        String type = parts[0];
        String description = parts[1];

        switch (type) {
        case "todo":
            if (description.isBlank()) {
                throw new EmptyDescriptionException("The description of a todo cannot be empty.");
            }
            task = new Todo(description);
            break;
        case "deadline":
            String[] deadline = description.split(" /by ", 2);
            if (deadline.length < 2) {
                throw new EmptyDescriptionException("The description and due date of a deadline cannot be empty.");
            }
            LocalDateTime due = DateTimeUtils.parseDataTime(deadline[1]);
            task = new Deadline(deadline[0], due);
            break;
        case "event":
            String[] event = description.split(" /from | /to ");
            if (event.length < 3) {
                throw new EmptyDescriptionException("The description and time of an event cannot be empty.");
            }

            LocalDateTime start = DateTimeUtils.parseDataTime(event[1]);
            LocalDateTime end = DateTimeUtils.parseDataTime(event[2]);
            task = new Event(event[0], start, end);
            break;
        default:
            throw new UnknownCommandException();
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, TaskManager taskManager) throws PopiException {
        tasks.publicAddTask(task);
        taskManager.publicSaveTask(tasks);
        ui.showTaskAdded(task, tasks);
    }
}
