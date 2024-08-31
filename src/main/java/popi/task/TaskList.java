package popi.task;

import popi.exception.PopiException;

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

    /**
     * Marks a task as done.
     * @param index Index of the task to be marked as done.
     * @return Task that was marked as done.
     * @throws PopiException If the task index is invalid.
     */
    public Task publicMarkTask(int index) throws PopiException {
        return markTask(index);
    }

    /**
     * Deletes a task.
     * @param index Index of the task to be deleted.
     * @return Task that was deleted.
     * @throws PopiException If the task index is invalid.
     */
    public Task publicDeleteTask(int index) throws PopiException {
        return deleteTask(index);
    }

    /**
     * Unmarks a task as done.
     * @param index Index of the task to be unmarked.
     * @return Task that was unmarked.
     * @throws PopiException If the task index is invalid.
     */
    public Task publicUnmarkTask(int index) throws PopiException {
        return unmarkTask(index);
    }

    /**
     * Adds a task to the task list.
     * @param task Task to be added.
     */
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

    /**
     * Returns the number of tasks in the task list.
     * @return Number of tasks in the task list.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the task at the specified index.
     * @param index Index of the task.
     * @return Task at the specified index.
     */
    public Task getTask(int index) {
        return tasks.get(index - 1);
    }
}
