import java.util.Scanner;
import java.util.ArrayList;

public class Ui {
    private static final String logo =
            "\t" + " _       _            _                \n"
                    + "    | |     |_|  _      _| |_   _ _        \n"
                    + "    | |     | | | |__  |_   _| |__  |      \n"
                    + "    | |___  | | |  _  |  | |__  /  /       \n"
                    + "    |_____| |_| |_| |_|  |___/ /____|      \n";
    private static final String horiLine = "\t" + "\u2500".repeat(150);

    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void greet() {
        System.out.println(horiLine);
        System.out.println(logo);
        System.out.println(horiLine);

        System.out.println("\t " + "Hello Sir/Ma'am! I'm Lintz");
        System.out.println("\t " + "As always, pleasure to serve you Sir/Ma'am!\n");
        System.out.println(horiLine + "\n");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void displayTaskAdded(Task task, int taskCount) {
        System.out.println(horiLine);
        System.out.println("\t " + "Copy Sir/Ma'am, I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\t " + "You have now " + taskCount + " tasks Sir/Ma'am." + "\n");
        System.out.println(horiLine + "\n");
    }

    public void displayTaskDeleted(Task task, int taskCount) {
        System.out.println(horiLine);
        System.out.println("\t " + "Copy Sir/Ma'am, I've deleted this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\t " + "You have now " + taskCount + " tasks Sir/Ma'am." + "\n");
        System.out.println(horiLine + "\n");
    }

    public void displayTaskList(ArrayList<Task> tasks) {
        System.out.println(horiLine);
        System.out.println("\t " + "Here are the tasks in your list:");
        int idx = 0;
        for (Task task : tasks) {
            System.out.println("\t " + (idx + 1) + "." + task.toString());
            idx++;
        }
        System.out.println("\n" + horiLine + "\n");
    }

    public void displayError(String message) {
        System.out.println(horiLine);
        System.out.println("\t " + message + "\n");
    }

    public void displayCorrectInputTemplate() {
        System.out.println("\t Please input the correct input template shown:\n" +
                "\t \t1. todo <TASKS_DESCRIPTION>\n" +
                "\t \t2. deadline <TASK_DESCRIPTION> /by <DATE_AND/OR_TIME>\n" +
                "\t \t3. event <TASKS_DESCRIPTION> /from <DATE_AND/OR_TIME> /to <DATE_AND/OR_TIME>\n" +
                "\t \t4. list\n" +
                "\t \t5. mark <INDEX_OF_TASK>\n" +
                "\t \t6. unmark <INDEX_OF_TASK>\n" +
                "\t \t7. delete <INDEX_OF_TASK>\n" +
                "\t \t8. find <KEYWORD>\n");
        System.out.println(horiLine + "\n");
    }

    public void displayNoTasksMessage() {
        System.out.println(horiLine);
        System.out.println("\t " + "Hi Sir/Ma'am, rest assured, you have currently no tasks at all");
        System.out.println(horiLine + "\n");
    }

    public void displayTaskMarked(Task task) {
        System.out.println(horiLine);
        System.out.println("\tCongratulations Sir/Ma'am on completing this task:");
        System.out.println("\t  " + task.toString());
        System.out.println(horiLine + "\n");
    }

    public void displayTaskUnmarked(Task task) {
        System.out.println(horiLine);
        System.out.println("\tNo worries Sir/Ma'am, we've got ample of time to complete this task:");
        System.out.println("\t " + task.toString());
        System.out.println(horiLine + "\n");
    }

    /**
     * Displays the list of tasks that match the given keyword.
     *
     * @param matchingTasks The list of tasks that match the keyword.
     */
    public void displayMatchingTasks(ArrayList<Task> matchingTasks) {
        System.out.println(horiLine);
        if (matchingTasks.isEmpty()) {
            System.out.println("\t " + "No tasks found matching your search, Sir/Ma'am.");
        } else {
            System.out.println("\t " + "Here are the matching tasks in your list, Sir/Ma'am:");
            int idx = 0;
            for (Task task : matchingTasks) {
                System.out.println("\t " + (idx + 1) + "." + task.toString());
                idx++;
            }
        }
        System.out.println("\n" + horiLine + "\n");
    }

    public void exit() {
        System.out.println(horiLine);
        System.out.println("\t " + "See you Sir/Ma'am! I will be on standby at all times!");
        System.out.println(horiLine + "\n");
    }

}