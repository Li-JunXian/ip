/**
 * Parses and interpret user input and task strings into commands and tasks to be executed.
 */
public class Parser {
    /**
     * Parses a task string into a Task object.
     *
     * @param taskString The string representation of the task.
     * @return The parsed Task object.
     */
    public static Task parseTask(String taskString) {
        char type = taskString.charAt(1);
        boolean isDone = taskString.charAt(4) == 'X';
        String details = taskString.substring(7);

        Task task;
        if (type == 'T') {
            task = new Todo(details);
        } else if (type == 'D') {
            String[] parts = details.split("\\(by: ");
            task = new Deadline(parts[0].trim(), parts[1].replace(")", ""));
        } else { // type == 'E'
            String[] parts = details.split("\\(from: ");
            String[] times = parts[1].split(" to: ");
            task = new Event(parts[0].trim(), times[0], times[1].replace(")", ""));
        }

        if (isDone) {
            task.isDone = true;
        }
        return task;
    }

    /**
     * Parses a user input string into a Command object.
     *
     * @param input The user's input string.
     * @return The parsed Command object.
     */
    public static Command parseCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toUpperCase();
        String arguments = parts.length > 1 ? parts[1] : "";

        return new Command(command, arguments);
    }

}
