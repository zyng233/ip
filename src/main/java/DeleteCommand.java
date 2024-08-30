public class DeleteCommand extends Command {
    private final int taskNumber;
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, TaskManager taskManager) throws PopiException {
        Task task = tasks.deleteTask(taskNumber);
        taskManager.save(tasks);
        ui.showTaskDeleted(task, tasks);
    }
}
