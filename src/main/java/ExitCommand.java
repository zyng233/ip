public class ExitCommand extends Command {
    public ExitCommand() {
    }
    @Override
    public void execute(TaskList tasks, Ui ui, TaskManager taskManager) {
        ui.showGoodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
