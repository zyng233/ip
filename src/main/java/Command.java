public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, TaskManager taskManager) throws PopiException;

    public boolean isExit() {
        return false;
    }
}
