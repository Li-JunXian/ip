import java.io.*;
import java.util.ArrayList;

public class Storage {
    public static final String FILE_PATH = "./taskList/LintzTaskList.txt";

    public void ensureFileExists() {
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

    public void saveTasks(ArrayList<Task> tasks) {
        ensureFileExists();
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (Task task : tasks) {
                fw.write(task.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("\tError saving tasks: " + e.getMessage());
        }
    }

    public ArrayList<Task> loadTasks() {
        ensureFileExists();
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(Parser.parseTask(line));
            }
        } catch (IOException e) {
            System.out.println("\tError loading tasks: " + e.getMessage());
        }
        return tasks;
    }

}
