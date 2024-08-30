import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Popi {
    static String newline = "\n------------------------------------------";
    private List<Task> list;
    private TaskManager taskManager;
    private boolean start;
    public Popi() {
        this.taskManager = new TaskManager();
        try {
            this.list = this.taskManager.load();
            this.start = true;
        } catch (Exception e) {
            System.out.println("Error loading tasks. Starting with an empty list.");
            this.list = new ArrayList<>();
        }
    }

    private static Popi popiGreet() {
        System.out.println(newline + "\nHello! I'm Popi!");
        System.out.println("What can I do for you?" + newline);
        return new Popi();
    }

    private static void popiBye() {
        System.out.println("Bye. Hope to see you again soon!" + newline);
    }

    private void displayList() throws IOException {
        List<Task> tasks = this.taskManager.load();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println(newline);
    }

    private void saveTask() {
        try {
            this.taskManager.save(this.list);
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void addTask(Task task) throws IOException {
        this.list.add(task);
        saveTask();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + this.list.size() + " tasks in the list.");
        System.out.println(newline);
    }

    private void readInput() {
       Scanner scanner = new Scanner(System.in);
       while (start) {
           String input = scanner.nextLine();
           System.out.println(newline);

           String[] parts = input.split(" ", 2);
           String command = parts[0].toLowerCase();
           String task = parts.length > 1 ? parts[1] : "";
           handleCommand(command, task);
       }
       scanner.close();
    }

    private void deleteTask(int task) throws IOException {
        if (task < 1 || task > this.list.size()) {
            System.out.println("Invalid task number. Please try again.");
            System.out.println(newline);
            return;
        }
        Task deleted = this.list.remove(task - 1);
        saveTask();
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + deleted);
        System.out.println("Now you have " + this.list.size() + " tasks in the list.");
        System.out.println(newline);
    }

    private void handleCommand(String command, String task) {
        try {
            switch (command) {
                case "list":
                    displayList();
                    break;
                case "bye":
                    start = false;
                    break;
                case "mark":
                    Task taskToMark = this.list.get(Integer.parseInt(task) - 1);
                    taskToMark.markAsDone();
                    saveTask();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  [X] " + this.list.get(Integer.parseInt(task) - 1).description);
                    System.out.println(newline);
                    break;
                case "unmark":
                    Task taskToUnmark = this.list.get(Integer.parseInt(task) - 1);
                    taskToUnmark.markAsUndone();
                    saveTask();
                    System.out.println("Ok, I've marked this task as not done yet:");
                    System.out.println("  [ ] " + taskToUnmark.description);
                    System.out.println(newline);
                    break;
                case "todo":
                    if (task.isEmpty()) {
                        throw new EmptyDescriptionException("todo");
                    } else {
                        addTask(new Todo(task));
                    }
                    break;
                case "deadline":
                    String[] due = task.split(" /by ", 2);
                    if (due.length < 2) {
                        throw new EmptyDescriptionException("deadline");
                    }
                    addTask(new Deadline(due[0], due[1]));
                    break;
                case "event":
                    String[] time = task.split(" /from ", 2);
                    if (time.length < 2) {
                        throw new EmptyDescriptionException("event");
                    }
                    String[] startEnd = time[1].split(" /to ", 2);
                    if (startEnd.length < 2) {
                        throw new EmptyDescriptionException("event");
                    }
                    addTask(new Event(time[0], startEnd[0], startEnd[1]));
                    break;
                case "delete":
                    if (task.isEmpty()) {
                        throw new EmptyDescriptionException("delete");
                    } else {
                        deleteTask(Integer.parseInt(task) - 1);
                    }
                    break;
                default:
                    throw new UnknownCommandException();
            }
        } catch (EmptyDescriptionException | UnknownCommandException e) {
            System.out.println(e.getMessage());
            System.out.println(newline);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid task number.");
            System.out.println(newline);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Popi popi = popiGreet();
        popi.readInput();
        popiBye();
    }
}
