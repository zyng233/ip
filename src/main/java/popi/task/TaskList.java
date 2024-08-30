package popi.task;

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

    public Task getTask(int index) {
        return tasks.get(index - 1);
    }
}
