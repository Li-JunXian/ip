public class Parser {
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

    public static Command parseCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toUpperCase();
        String arguments = parts.length > 1 ? parts[1] : "";

        return new Command(command, arguments);
    }

}
