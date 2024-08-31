package popi.task;

import popi.exception.InvalidTaskNumberException;
import popi.exception.PopiException;
import popi.task.Task;

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

    public Task publicMarkTask(int index) throws PopiException {
        return markTask(index);
    }

    public Task publicDeleteTask(int index) throws PopiException {
        return deleteTask(index);
    }

    public Task publicUnmarkTask(int index) throws PopiException {
        return unmarkTask(index);
    }

    public void publicAddTask(Task task) {
        addTask(task);
    }

    protected Task unmarkTask(int index) throws InvalidTaskNumberException {
        index -= 1;
        if (index < 0 || index >= tasks.size()) {
            throw new InvalidTaskNumberException("Invalid task number");
        }
        Task task = tasks.get(index);
        task.markAsUndone();
        return task;
    }

    protected Task markTask(int index) throws InvalidTaskNumberException {
        index -= 1;
        if (index < 0 || index >= tasks.size()) {
            throw new InvalidTaskNumberException("Invalid task number");
        }
        Task task = tasks.get(index);
        task.markAsDone();
        return task;
    }

    protected Task deleteTask(int index) throws InvalidTaskNumberException {
        index -= 1;
        if (index < 0 || index >= tasks.size()) {
            throw new InvalidTaskNumberException("Invalid task number");
        }
        Task task = tasks.get(index);
        tasks.remove(index);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        return tasks.get(index - 1);
    }

    public TaskList findTasks(String keyword) {
        TaskList matchingTasks = new TaskList();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.addTask(task);
            }
        }
        return matchingTasks;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
