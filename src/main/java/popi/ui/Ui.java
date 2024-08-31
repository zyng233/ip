package popi.ui;

import popi.task.Task;
import popi.task.TaskList;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads the next line of input from the user.
     * @return The next line of input from the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showWelcome() {
        showLine();
        System.out.println("Hello! I'm Popi");
        System.out.println("What can I do for you?");
        showLine();
    }

    public void showGoodbye() {
        showLine();
        System.out.println("Bye. Hope to see you again soon!");
        showLine();
    }

    /**
     * Shows the error message.
     * @param message Error message to be shown.
     */
    public void showError(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    /**
     * Shows the added task and number of tasks in the task list.
     * @param task Task added to be shown.
     * @param tasks List of tasks to be calculated.
     */
    public void showTaskAdded(Task task, TaskList tasks) {
        showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        showLine();
    }

    /**
     * Shows the deleted task and number of tasks in the task list.
     * @param task Task deleted to be shown.
     * @param tasks List of tasks to be calculated.
     */
    public void showTaskDeleted(Task task, TaskList tasks) {
        showLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + tasks.getTasks().size() + " tasks in the list.");
        showLine();
    }

    /**
     * Shows the new marked task.
     * @param task Task to be marked.
     */
    public void showTaskMarked(Task task) {
        showLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
        showLine();
    }

    /**
     * Shows the new unmarked task.
     * @param task Task to be unmarked.
     */
    public void showTaskUnmarked(Task task) {
        showLine();
        System.out.println("Nice! I've marked this task as undone:");
        System.out.println("  " + task);
        showLine();
    }

    public void showMatchingTasks(TaskList tasks) {
        showLine();
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + tasks.getTasks().get(i));
        }
        showLine();
    }
}
