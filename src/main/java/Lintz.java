import java.util.Scanner;
import java.util.ArrayList;

public class Lintz {

    private static final String logo =
            "\t" + " _       _            _                \n"
                    + "    | |     |_|  _      _| |_   _ _        \n"
                    + "    | |     | | | |__  |_   _| |__  |      \n"
                    + "    | |___  | | |  _  |  | |__  /  /       \n"
                    + "    |_____| |_| |_| |_|  |___/ /____|      \n";
    private static final String horiLine = "\t" + "\u2500".repeat(150);

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void greet() {
        System.out.println(horiLine);
        System.out.println(logo);
        System.out.println(horiLine);

        System.out.println("\t " + "Hello Sir/Ma'am! I'm Lintz");
        System.out.println("\t " + "As always, pleasure to serve you Sir/Ma'am!\n");
        System.out.println(horiLine + "\n");
    }

    public static void exit() {
        System.out.println(horiLine);
        System.out.println("\t " + "See you Sir/Ma'am! I will be on standby at all times!");
        System.out.println(horiLine + "\n");
    }

    public static void displayTaskAdded(int taskCount) {
        System.out.println(horiLine);
        System.out.println("\t " + "Copy Sir/Ma'am, I've added this task: ");
        System.out.println("\t   " + tasks.get(tasks.size() - 1).toString());
        System.out.println("\t " + "You have now " + (taskCount + 1) + " tasks Sir/Ma'am." + "\n");
        System.out.println(horiLine + "\n");
    }

    public static void taskManager(String input) throws IllegalInputException {
        String firstWord = input.split(" ")[0].toUpperCase();
        String[] sentenceComponents = input.split("/");

        try {
            switch (firstWord) {
            case "LIST":
                System.out.println(horiLine);
                System.out.println("\t " + "Here are the tasks in your list:");
                int idx = 1;
                for (Task task : tasks) {
                    System.out.println("\t " + idx + "." + tasks.get(idx - 1).toString());
                    idx++;
                }
                System.out.println("\n" + horiLine + "\n");
                break;
            case "MARK":
                System.out.println(horiLine);
                tasks.get(Integer.parseInt(input.substring(5)) - 1).markAsDone();
                FileWrite.saveTasks(tasks);
                System.out.println(horiLine + "\n");
                break;
            case "UNMARK":
                System.out.println(horiLine);
                tasks.get(Integer.parseInt(input.substring(7)) - 1).markAsUndone();
                FileWrite.saveTasks(tasks);
                System.out.println(horiLine + "\n");
                break;
            case "TODO":
                tasks.add(new Todo(input.substring(5)));
                FileWrite.saveTasks(tasks);
                displayTaskAdded(tasks.size() - 1);
                break;
            case "DEADLINE":
                tasks.add(new Deadline(sentenceComponents[0].substring(9), sentenceComponents[1].substring(3)));
                FileWrite.saveTasks(tasks);
                displayTaskAdded(tasks.size() - 1);
                break;
            case "EVENT":
                tasks.add(new Event(sentenceComponents[0].substring(6), sentenceComponents[1].substring(5), sentenceComponents[2].substring(3)));
                FileWrite.saveTasks(tasks);
                displayTaskAdded(tasks.size() - 1);
                break;
            case "DELETE":
                System.out.println(horiLine);
                System.out.println("\t " + "Copy Sir/Ma'am, I've delete this task: ");
                System.out.println("\t   " + tasks.get(Integer.parseInt(input.substring(7)) - 1).toString());
                System.out.println("\t " + "You have now " + (tasks.size() - 1) + " tasks Sir/Ma'am." + "\n");
                System.out.println(horiLine + "\n");
                tasks.remove(Integer.parseInt(input.substring(7)) - 1);
                FileWrite.saveTasks(tasks);
                break;
            default:
                throw new IllegalInputException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(horiLine);
            System.out.println("\t Hi Sir/Ma'am, I've captured incomplete command, please be so kind to elaborate ;-)");
            System.out.println(horiLine + "\n");
        } catch (IllegalInputException e) {
            System.out.println(horiLine);
            System.out.println("\t Apologies Sir/Ma'am, might I trouble you to input your command again for clarification? Thank you Sir/Ma'am ;-D");
            System.out.println(horiLine + "\n");
        }
    }

    public static void main(String[] args) throws IllegalInputException {
        greet();

        while (true) {
            tasks = FileWrite.loadTasks();
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
