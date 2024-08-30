public class Popi {
    private TaskList list;
    private TaskManager taskManager;
    private Ui ui;
    public Popi() {
        ui = new Ui();
        taskManager = new TaskManager();
        try {
            list = taskManager.load();
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
            } catch (InvalidTimeFormat | EmptyDescriptionException | UnknownCommandException e) {
                ui.showError(e.getMessage());
            } catch (PopiException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Popi().run();
    }
}
