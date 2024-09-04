package popi.ui;

import java.util.Scanner;

import popi.task.Task;
import popi.task.TaskList;

/**
 * Represents the user interface of the application.
 */
public class Ui {
    private final Scanner scanner;
    private String response;

    /**
     * Constructor for the Ui.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
        this.response = "";
    }

    /**
     * Reads the next line of input from the user.
     * @return The next line of input from the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Shows the welcome message.
     */
    public void showWelcome() {
        setResponse("Hello! I'm Popi\nWhat can I do for you?");
    }

    /**
     * Shows the goodbye message.
     */
    public void showGoodbye() {
        setResponse("Bye. Hope to see you again soon!");
    }

    /**
     * Shows the error message.
     * @param message Error message to be shown.
     */
    public void showError(String message) {
        setResponse(message);
    }

    /**
     * Shows the added task and number of tasks in the task list.
     * @param task Task added to be shown.
     * @param tasks List of tasks to be calculated.
     */
    public void showTaskAdded(Task task, TaskList tasks) {
        setResponse("Got it. I've added this task:\n  " + task + "\nNow you have "
                + tasks.getTasks().size() + " tasks in the list.");
    }

    /**
     * Shows the deleted task and number of tasks in the task list.
     * @param task Task deleted to be shown.
     * @param tasks List of tasks to be calculated.
     */
    public void showTaskDeleted(Task task, TaskList tasks) {
        setResponse("Noted. I've removed this task:\n  " + task + "\nNow you have "
                + tasks.getTasks().size() + " tasks in the list.");
    }

    /**
     * Shows the new marked task.
     * @param task Task to be marked.
     */
    public void showTaskMarked(Task task) {
        setResponse("Nice! I've marked this task as done:\n  " + task);
    }

    /**
     * Shows the new unmarked task.
     * @param task Task to be unmarked.
     */
    public void showTaskUnmarked(Task task) {
        setResponse("Nice! I've unmarked this task as undone:\n  " + task);
    }

    /**
     * Shows the list of tasks found.
     * @param tasks List of tasks to be shown.
     */
    public void showMatchingTasks(TaskList tasks) {
        StringBuilder matchingTasks = new StringBuilder("Here are the matching tasks in your list:\n");
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            matchingTasks.append(i + 1).append(". ")
                    .append(tasks.getTasks().get(i)).append("\n");
        }
        setResponse(matchingTasks.toString());
    }

    /**
     * Sets the response to be shown to the user.
     *
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the response to be shown to the user.
     * @param response Response to be shown to the user.
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * Shows the list of tasks.
     * @param tasks List of tasks to be shown.
     */
    public void showTasks(TaskList tasks) {
        StringBuilder taskList = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            taskList.append(i + 1).append(". ")
                    .append(tasks.getTasks().get(i)).append("\n");
        }
        setResponse(taskList.toString());
    }
}
