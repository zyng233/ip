package popi.core;

import popi.command.Command;
import popi.command.Parser;
import popi.exception.PopiException;
import popi.task.TaskList;
import popi.task.TaskManager;
import popi.ui.Ui;

public class Popi {
    private TaskList list;
    private final TaskManager taskManager;
    private final Ui ui;

    public Popi() {
        ui = new Ui();
        taskManager = new TaskManager();
        try {
            list = taskManager.loadTasks();
        } catch (PopiException e) {
            ui.showError(e.getMessage());
            list = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(list, ui, taskManager);
                isExit = c.isExit();
            } catch (PopiException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Popi().run();
    }
}
