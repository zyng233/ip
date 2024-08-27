import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Popi {
    static String newline = "\n------------------------------------------";
    private List<Task> list;
    private boolean start;
    public Popi() {
        this.start = true;
        this.list = new ArrayList<>();
    }

    private static Popi popiGreet() {
        System.out.println(newline + "\nHello! I'm Popi!");
        System.out.println("What can I do for you?" + newline);
        return new Popi();
    }

    private static void popiBye() {
        System.out.println("Bye. Hope to see you again soon!" + newline);
    }
    private void addToList(Task item) {
        this.list.add(item);
        System.out.println("added: " + item + newline);
    }

    private void displayList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println((i + 1) + ". " + this.list.get(i));
        }
        System.out.println(newline);
    }

    private void addTask(Task task) {
        this.list.add(task);
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
                    this.list.get(Integer.parseInt(task) - 1).markAsDone();
                    System.out.println(newline);
                    break;
                case "unmark":
                    this.list.get(Integer.parseInt(task) - 1).markAsUndone();
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
                    } else {
                        addTask(new Deadline(due[0], due[1]));
                    }
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
                default:
                    throw new UnknownCommandException();
            }
        } catch (EmptyDescriptionException | UnknownCommandException e) {
            System.out.println(e.getMessage());
            System.out.println(newline);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid task number. Please try again.");
            System.out.println(newline);
        }
    }

    public static void main(String[] args) {
        Popi popi = popiGreet();
        popi.readInput();
        popiBye();
    }
}
