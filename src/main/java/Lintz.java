import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Lintz {

    private static final String logo = "\t" + " _       _            _                \n"
            + "    | |     |_|  _      _| |_   _ _        \n"
            + "    | |     | | | |__  |_   _| |__  |      \n"
            + "    | |___  | | |  _  |  | |__  /  /       \n"
            + "    |_____| |_| |_| |_|  |___/ /____|      \n";
    private static final String horiLine = "\t" + "\u2500".repeat(150);

    private static final Task[] taskList = new Task[100];
    private static int taskCount = 0;

    public static void greet() {
        System.out.println(horiLine);
        System.out.println(logo);
        System.out.println(horiLine);

        System.out.println("\t " + "Hello Sir/Ma'am! I'm Lintz");
        System.out.println("\t " + "As always, pleasure to serve you Sir/Ma'am?\n");
        System.out.println(horiLine);
    }

    public static void exit() {
        System.out.println(horiLine);
        System.out.println("\t " + "See you Sir/Ma'am! I will be on standby at all times!");
        System.out.println(horiLine);
    }

    public static void displayTaskAdded(int taskCount) {
        System.out.println(horiLine);
        System.out.println("\t " + "Copy Sir/Ma'am, I've added this task: ");
        System.out.println("\t   " + taskList[taskCount].toString());
        System.out.println("\t " + "You have now " + (taskCount + 1) + " tasks Sir/Ma'am." + "\n");
        System.out.println(horiLine);
    }

    public static void taskManager(String input) {
        String firstWord = input.split(" ")[0].toUpperCase();
        String[] sentenceComponents = input.split("/");

        try {
            switch (firstWord) {
            case "LIST":
                System.out.println(horiLine);
                System.out.println("\t " + "Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("\t " + (i + 1) + "." + taskList[i].toString());
                }
                System.out.println(horiLine);
                break;
            case "MARK":
                System.out.println(horiLine);
                taskList[Integer.parseInt(input.substring(5)) - 1].markAsDone();
                System.out.println(horiLine);
                break;
            case "UNMARK":
                System.out.println(horiLine);
                taskList[Integer.parseInt(input.substring(7)) - 1].markAsUndone();
                System.out.println(horiLine);
                break;
            case "TODO":
                taskList[taskCount] = new Todo(input.substring(5));
                displayTaskAdded(taskCount);
                taskCount++;
                break;
            case "DEADLINE":
                taskList[taskCount] = new Deadline(sentenceComponents[0].substring(9), sentenceComponents[1].substring(3));
                displayTaskAdded(taskCount);
                taskCount++;
                break;
            case "EVENT":
                taskList[taskCount] = new Event(sentenceComponents[0].substring(6), sentenceComponents[1].substring(5), sentenceComponents[2].substring(3));
                displayTaskAdded(taskCount);
                taskCount++;
                break;
            default:
                throw new IllegalInputException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(horiLine);
            System.out.println("\t Sir/Ma'am, I've captured incomplete command, please be so kind to elaborate ;-)");
            System.out.println(horiLine);
        } catch (IllegalInputException e) {
            System.out.println(horiLine);
            System.out.println("\t Apologies Sir/Ma'am, might I trouble you to input your command again for clarification? Thank you Sir/Ma'am ;-D");
            System.out.println(horiLine);
        }
    }

    public static void main(String[] args) {
        greet();

        while (true) {
            String line;
            Scanner input = new Scanner(System.in);
            line = input.nextLine();

            if (line.equalsIgnoreCase("bye")) {
                exit();
                break;
            }

            taskManager(line);
        }
    }
}
