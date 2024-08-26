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

    private void readInput() {
       Scanner scanner = new Scanner(System.in);
       while (start) {
           String input = scanner.nextLine();
           System.out.println(newline);

           String[] parts = input.split(" ");
           String command = parts[0].toLowerCase();
           String taskNumber = parts.length > 1 ? parts[1] : "";

           switch (command) {
               case "list":
                   displayList();
                   break;
               case "bye":
                   start = false;
                   break;
               case "mark":
                   try {

                       this.list.get(Integer.parseInt(taskNumber) - 1).markAsDone();
                   } catch (IndexOutOfBoundsException | NumberFormatException e) {
                       System.out.println("Invalid task number. Please try again.");
                       System.out.println(newline);
                   }
                   break;
               case "unmark":
                   try {
                       this.list.get(Integer.parseInt(taskNumber) - 1).markAsUndone();
                   } catch (IndexOutOfBoundsException | NumberFormatException e) {
                       System.out.println("Invalid task number. Please try again.");
                       System.out.println(newline);
                   }
                   break;
               default:
                   addToList(new Task(input));
                   break;
           }
       }
       scanner.close();
    }

    private class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String toString() {
            return "[" + getStatusIcon() + "] " + this.description;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " ");
        }

        private void markAsDone() {
            this.isDone = true;
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  [X] " + this.description);
            System.out.println(newline);
        }

        private void markAsUndone() {
            this.isDone = false;
            System.out.println("Ok, I've marked this task as not done yet:");
            System.out.println("  [ ] " + this.description);
            System.out.println(newline);
        }
    }

    public static void main(String[] args) {
        Popi popi = popiGreet();
        popi.readInput();
        popiBye();
    }
}
