import java.util.Scanner;
import java.util.ArrayList;

/**
 * Interact with all user interactions, including displaying messages and reading input.
 */
public class Ui {
    private static final String logo =
            "\t" + " _       _            _                \n"
                    + "    | |     |_|  _      _| |_   _ _        \n"
                    + "    | |     | | | |__  |_   _| |__  |      \n"
                    + "    | |___  | | |  _  |  | |__  /  /       \n"
                    + "    |_____| |_| |_| |_|  |___/ /____|      \n";
    private static final String horiLine = "\t" + "\u2500".repeat(150);

    private Scanner scanner;

    /**
     * Constructs a Ui instance and initializes the scanner for taking in user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the greeting message and logo when the chatbot starts.
     */
    public void greet() {
        System.out.println(horiLine);
        System.out.println(logo);
        System.out.println(horiLine);

        System.out.println("\t " + "Hello Sir/Ma'am! I'm Lintz");
        System.out.println("\t " + "As always, pleasure to serve you Sir/Ma'am!\n");
        System.out.println(horiLine + "\n");
    }

    /**
     * Reads a command from the user.
     *
     * @return The user's input as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays confirmation message when a task is successfully added to the task list.
     *
     * @param task      The task that was added.
     * @param taskCount The total number of tasks after adding the new task.
     */
    public void displayTaskAdded(Task task, int taskCount) {
        System.out.println(horiLine);
        System.out.println("\t " + "Copy Sir/Ma'am, I've added this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\t " + "You have now " + taskCount + " tasks Sir/Ma'am." + "\n");
        System.out.println(horiLine + "\n");
    }

    /**
     * Displays confirmation message when a task is successfully deleted from the task list.
     *
     * @param task      The task that was deleted.
     * @param taskCount The total number of tasks after deleting the task.
     */
    public void displayTaskDeleted(Task task, int taskCount) {
        System.out.println(horiLine);
        System.out.println("\t " + "Copy Sir/Ma'am, I've deleted this task: ");
        System.out.println("\t   " + task.toString());
        System.out.println("\t " + "You have now " + taskCount + " tasks Sir/Ma'am." + "\n");
        System.out.println(horiLine + "\n");
    }

    /**
     * Displays the list of tasks in the tasks list.
     *
     * @param tasks The list of tasks to display.
     */
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

    /**
     * Displays a message with the "[X]" representing "marked" when a task is marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void displayTaskMarked(Task task) {
        System.out.println(horiLine);
        System.out.println("\tCongratulations Sir/Ma'am on completing this task:");
        System.out.println("\t  " + task.toString());
        System.out.println(horiLine + "\n");
    }

    /**
     * Displays a message with the "[ ]" representing "unmarked" when a task is marked as undone.
     *
     * @param task The task that was marked as undone.
     */
    public void displayTaskUnmarked(Task task) {
        System.out.println(horiLine);
        System.out.println("\tNo worries Sir/Ma'am, we've got ample of time to complete this task:");
        System.out.println("\t " + task.toString());
        System.out.println(horiLine + "\n");
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    public void displayError(String message) {
        System.out.println(horiLine);
        System.out.println("\t " + message + "\n");
    }

    /**
     * Displays the correct input template to guide the user (only displays when the previous user input is invalid or incomplete).
     */
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

    /**
     * Displays a message when there are no tasks in the task list.
     */
    public void displayNoTasksMessage() {
        System.out.println(horiLine);
        System.out.println("\t " + "Hi Sir/Ma'am, rest assured, you have currently no tasks at all");
        System.out.println(horiLine + "\n");
    }


    /**
     * Displays a confirmation message displaying "[X]" when a task is marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void displayTaskMarked(Task task) {
        System.out.println(horiLine);
        System.out.println("\tCongratulations Sir/Ma'am on completing this task:");
        System.out.println("\t  " + task.toString());
        System.out.println(horiLine + "\n");
    }

    /**
     * Displays a confirmation message displaying "[ ]" when a task is marked as undone.
     *
     * @param task The task that was marked as undone.
     */
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

    /**
     * Displays the exit message when the user wishes to leave the application.
     */
    public void exit() {
        System.out.println(horiLine);
        System.out.println("\t " + "See you Sir/Ma'am! I will be on standby at all times!");
        System.out.println(horiLine + "\n");
    }

}