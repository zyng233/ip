package popi.command;

import popi.exception.PopiException;
import popi.task.TaskList;
import popi.task.TaskManager;
import popi.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, TaskManager taskManager) throws PopiException;

    public boolean isExit() {
        return false;
    }
}
