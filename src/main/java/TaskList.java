import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    protected void addTask(Task task) {
        tasks.add(task);
    }

    protected Task unmarkTask(int index) throws IndexOutOfBoundsException {
        int taskIndex = index - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid task index");
        }
        Task task = tasks.get(taskIndex);
        task.markAsUndone();
        return task;
    }

    protected Task markTask(int index) throws PopiException {
        int taskIndex = index - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new PopiException("Invalid task number");
        }
        Task task = tasks.get(taskIndex);
        task.markAsDone();
        return task;
    }

    protected Task deleteTask(int index) throws PopiException {
        int taskIndex = index - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new PopiException("Invalid task number");
        }
        Task task = tasks.get(taskIndex);
        tasks.remove(taskIndex);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
