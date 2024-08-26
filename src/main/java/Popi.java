import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Popi {

    static String newline = "\n------------------------------------------";
    private boolean start;
    public Popi() {
        this.start = true;
    }

    private boolean getStarted() {
        return this.start;
    }
    private static Popi popiGreet() {
        System.out.println(newline + "\nHello! I'm Popi!");
        System.out.println("What can I do for you?" + newline);
        return new Popi();
    }

    private static void popiBye() {
        System.out.println("Bye. Hope to see you again soon!" + newline);
    }

    private void readInput() {
       Scanner scanner = new Scanner(System.in);
       while (start) {
           String input = scanner.nextLine();
           System.out.println(newline);

           if (input.equals("bye")) {
               start = false;
           } else {
               System.out.println(input + newline);
           }
       }
       scanner.close();
    }

    public static void main(String[] args) {
        Popi popi = popiGreet();
        popi.readInput();
        popiBye();
    }
}
