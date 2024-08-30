package popi.task;

import popi.exception.PopiException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

public class TaskManager {
    private final String path = "./data/popi.txt";

    public TaskList loadTasks() throws PopiException {
        return load();
    }

    protected TaskList load() throws PopiException {
        TaskList tasks = new TaskList();
        File f = new File(path);

        if (!f.exists()) {
            try {
                boolean directoryCreated = f.getParentFile().mkdirs();
                if (!directoryCreated) {
                    throw new IOException("Error creating directory");
                }

                boolean fileCreated = f.createNewFile();
                if (!fileCreated) {
                    throw new IOException("Error creating file");
                }
            } catch (IOException e) {
                throw new PopiException("Error creating file");
            }
            return tasks;
        }

        try {
            List<String> lines = Files.readAllLines(java.nio.file.Paths.get(path));
            for (String line : lines) {
                Task t = getTask(line);
                tasks.addTask(t);
            }
        } catch (IOException e) {
            throw new PopiException("Error reading file");
        }
        return tasks;
    }

    private static Task getTask(String line) throws PopiException {
        String[] parts = line.split(" \\| ");
        Task t = switch (parts[0]) {
            case "T" -> new Todo(parts[2]);
            case "D" -> new Deadline(parts[2], LocalDateTime.parse(parts[3]));
            case "E" -> new Event(parts[2], LocalDateTime.parse(parts[3]), LocalDateTime.parse(parts[4]));
            default -> throw new PopiException("Invalid task type");
        };
        if (parts[1].equals("1")) {
            t.markAsDone();
        }
        return t;
    }

    public void publicSaveTask(TaskList tasks) throws PopiException {
        save(tasks);
    }

    protected void save(TaskList task) throws PopiException {
        try {
            FileWriter writer = new FileWriter(path);
            for (Task t : task.getTasks()) {
                writer.write(t.toDataString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new PopiException("Error saving tasks");
        }
    }
}
