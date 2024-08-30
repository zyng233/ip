package popi.command;

import popi.exception.PopiException;
import popi.task.Task;
import popi.task.TaskList;
import popi.task.TaskManager;
import popi.ui.Ui;

public class MarkCommand extends Command {
    private final int taskNumber;

    public MarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, TaskManager taskManager) throws PopiException {
        Task task = tasks.publicMarkTask(taskNumber);
        taskManager.publicSaveTask(tasks);
        ui.showTaskMarked(task);
    }
}
