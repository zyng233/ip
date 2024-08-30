package popi.command;

import popi.exception.PopiException;
import popi.task.Task;
import popi.task.TaskList;
import popi.task.TaskManager;
import popi.ui.Ui;

public class DeleteCommand extends Command {
    private final int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, TaskManager taskManager) throws PopiException {
        Task task = tasks.publicDeleteTask(taskNumber);
        taskManager.publicSaveTask(tasks);
        ui.showTaskDeleted(task, tasks);
    }
}
