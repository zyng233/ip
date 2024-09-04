package popi.core;

import popi.command.Command;
import popi.command.Parser;
import popi.exception.PopiException;
import popi.task.TaskList;
import popi.task.TaskManager;
import popi.ui.Ui;

/**
 * Main class for the Popi program.
 */
public class Popi {
    private TaskList list;
    private final TaskManager taskManager;
    private Ui ui;

    /**
     * Constructor for Popi.
     */
    public Popi() {
        ui = new Ui();
        taskManager = new TaskManager();
        try {
            list = taskManager.loadTasks();
        } catch (PopiException e) {
            ui.showError(e.getMessage());
            list = new TaskList();
        }
        ui.showWelcome();
    }

    /**
     * Runs the main program loop.
     */
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

    /**
     * Sets the Ui object for the Popi program.
     *
     * @param ui The Ui object to be set.
     */
    public void setUi(Ui ui) {
        this.ui = ui;
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        if (input.equals("bye")) {
            ui.showGoodbye();
            return ui.getResponse();
        }

        try {
            Command command = Parser.parse(input);
            command.execute(list, ui, taskManager);
            return ui.getResponse();
        } catch (PopiException e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Main method to start the program.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new Popi().run();
    }
}
