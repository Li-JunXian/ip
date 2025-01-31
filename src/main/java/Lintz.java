import java.util.Scanner;

public class Lintz {

    private static String logo = " _       _            _                \n"
            + "    | |     |_|  _      _| |_   _ _        \n"
            + "    | |     | | | |__  |_   _| |__  |      \n"
            + "    | |___  | | |  _  |  | |__  /  /       \n"
            + "    |_____| |_| |_| |_|  |___/ /____|      \n";
    private static String horiLine = "\u2500".repeat(100);
    private static String[] taskList = new String[100];
    private static int taskCount = 0;

    public static void greet(){
        System.out.println("\t" + horiLine);
        System.out.println("\t" + logo);
        System.out.println("\t" + horiLine);

        System.out.println("\t" + "Hello! I'm Lintz");
        System.out.println("\t" + "What can I do for you?\n");
        System.out.println("\t" + horiLine);
    }

    public static void echo(String input) {
        System.out.println("\t" + input);
    }

    public static void taskListManager(String input) {
        if (!input.equalsIgnoreCase("list")){
            taskList[taskCount] = input;
            System.out.println("\t" + horiLine);
            System.out.print("\t" + "added: ");
            echo(input);
            System.out.println("\t" + horiLine);
            taskCount += 1;
        } else {
            System.out.println("\t" + horiLine);
            for (int i = 0; i < taskCount; i++) {
                System.out.println("\t" + (i + 1) + ". " + taskList[i]);
            }
            System.out.println("\t" + horiLine);
        }
    }

    public static void main(String[] args) {
        greet();

        while (true) {
            String line;
            Scanner input = new Scanner(System.in);
            line = input.nextLine();

            if (line.equalsIgnoreCase("bye")) {
                System.out.println("\t" + horiLine);
                System.out.println("\t" + "Bye. Hope to see you again soon!");
                System.out.println("\t" + horiLine);
                break;
            }
            taskListManager(line);
        }
    }
}
