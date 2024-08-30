package popi.command;

import popi.task.TaskList;
import popi.task.TaskManager;
import popi.ui.Ui;

public class ListCommand extends Command {
    public ListCommand() {
    }

    @Override
    public void execute(TaskList tasks, Ui ui, TaskManager taskManager) {
        ui.showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + tasks.getTasks().get(i));
        }
        ui.showLine();
    }
}
