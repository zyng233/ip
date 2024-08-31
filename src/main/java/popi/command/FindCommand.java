package popi.command;

import popi.exception.EmptyDescriptionException;
import popi.exception.PopiException;
import popi.task.TaskList;
import popi.task.TaskManager;
import popi.ui.Ui;

/**
 * Represents a command to find tasks that match a keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructor for FindCommand.
     *
     * @param command The command string that was entered by the user.
     * @throws EmptyDescriptionException If the keyword is empty.
     */
    public FindCommand(String command) throws EmptyDescriptionException {
        String[] parts = command.split(" ", 2);

        if (parts.length < 2) {
            throw new EmptyDescriptionException("The keyword cannot be empty.");
        }

        this.keyword = parts[1];
    }

    @Override
    public void execute(TaskList tasks, Ui ui, TaskManager taskManager) throws PopiException {
        TaskList matchingTasks = tasks.findTasks(keyword);

        if (matchingTasks.isEmpty()) {
            throw new PopiException("No matching tasks found.");
        }
        ui.showMatchingTasks(matchingTasks);
    }
}
