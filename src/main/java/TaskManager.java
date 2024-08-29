import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final String path = "./data/popi.txt";

    protected List<Task> load() throws IOException {
        List<Task> tasks = new ArrayList<>();
        File f = new File(path);

        if (!f.exists()) {
            boolean directoryCreated = f.getParentFile().mkdirs();
            if (!directoryCreated) {
                throw new IOException("Error creating directory");
            }

            boolean fileCreated = f.createNewFile();
            if (!fileCreated) {
                throw new IOException("Error creating file");
            }
            return tasks;
        }

        List<String> lines = Files.readAllLines(java.nio.file.Paths.get(path));
        for (String line : lines) {
            String[] parts = line.split(" \\| ");
            Task t = switch (parts[0]) {
                case "T" -> new Todo(parts[2]);
                case "D" -> new Deadline(parts[2], parts[3]);
                case "E" -> new Event(parts[2], parts[3], parts[4]);
                default -> throw new IOException("Invalid task type");
            };
            if (parts[1].equals("1")) {
                t.markAsDone();
            }
            tasks.add(t);
        }
        return tasks;
    }

    protected void save(List<Task> task) throws IOException {
        FileWriter writer = new FileWriter(path);
        for (Task t : task) {
            writer.write(t.toDataString() + "\n");
        }
        writer.close();
    }
}
