import java.io.*;
import java.util.ArrayList;

public class FileWrite {

    public static final String FILE_PATH = "./taskList/LintzTaskList.txt";

    public static void ensureFileExists() {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("\tError ensuring file exists: " + e.getMessage());
        }
    }

    public static void saveTasks(ArrayList<Task> tasks) {
        ensureFileExists();
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (Task task : tasks) {
                fw.write(task.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("\tError saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks() {
        ensureFileExists();
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(parseTask(line));
            }
        } catch (IOException e) {
            System.out.println("\tError loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    private static Task parseTask(String taskString) {
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
}