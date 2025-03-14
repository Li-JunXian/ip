import java.util.ArrayList;

public class Command {
    private String command;
    private String arguments;

    public Command(String command, String arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public String getArguments() {
        return arguments;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws IllegalInputException, IndexOutOfBoundsException {
        switch (this.command) {
        case "LIST":
            if (taskList.getTaskCount() == 0) {
                ui.displayNoTasksMessage();
            } else {
                ui.displayTaskList(taskList.getTasks());
            }
            break;
        case "MARK":
            if (arguments.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            int markIndex = Integer.parseInt(this.arguments) - 1;
            taskList.markTaskAsDone(markIndex);
            ui.displayTaskMarked(taskList.getTasks().get(markIndex));
            storage.saveTasks(taskList.getTasks());
            break;
        case "UNMARK":
            if (arguments.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            int unmarkIndex = Integer.parseInt(this.arguments) - 1;
            taskList.markTaskAsUndone(unmarkIndex);
            ui.displayTaskUnmarked(taskList.getTasks().get(unmarkIndex));
            storage.saveTasks(taskList.getTasks());
            break;
        case "TODO":
            if (arguments.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            Task todo = new Todo(this.arguments);
            taskList.addTask(todo);
            ui.displayTaskAdded(todo, taskList.getTaskCount());
            storage.saveTasks(taskList.getTasks());
            break;
        case "DEADLINE":
            if (arguments.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            String[] deadlineParts = this.arguments.split("/by ");
            if (deadlineParts.length < 2) {
                throw new IndexOutOfBoundsException();
            }
            Task deadline = new Deadline(deadlineParts[0], deadlineParts[1]);
            taskList.addTask(deadline);
            ui.displayTaskAdded(deadline, taskList.getTaskCount());
            storage.saveTasks(taskList.getTasks());
            break;
        case "EVENT":
            if (arguments.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            String[] eventParts = this.arguments.split("/from | /to ");
            if (eventParts.length < 3) {
                throw new IndexOutOfBoundsException();
            }
            Task event = new Event(eventParts[0], eventParts[1], eventParts[2]);
            taskList.addTask(event);
            ui.displayTaskAdded(event, taskList.getTaskCount());
            storage.saveTasks(taskList.getTasks());
            break;
        case "DELETE":
            if (taskList.getTaskCount() == 0) {
                ui.displayNoTasksMessage();
            } else {
                if (arguments.isEmpty()) {
                    throw new IndexOutOfBoundsException();
                }
                try {
                    int deleteIndex = Integer.parseInt(this.arguments) - 1;
                    Task deletedTask = taskList.getTasks().get(deleteIndex);
                    taskList.deleteTask(deleteIndex);
                    ui.displayTaskDeleted(deletedTask, taskList.getTaskCount());
                    storage.saveTasks(taskList.getTasks());
                } catch (IndexOutOfBoundsException e) {
                    ui.displayNoTasksMessage();
                }
            }
            break;
        case "FIND":
            if (arguments.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            String keyword = this.arguments;
            ArrayList<Task> matchingTasks = taskList.findTasks(keyword);
            ui.displayMatchingTasks(matchingTasks);
            break;
        default:
            throw new IllegalInputException();
        }
    }

}