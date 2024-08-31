package popi.task;

import java.util.ArrayList;
import java.util.List;

import popi.exception.InvalidTaskNumberException;
import popi.exception.PopiException;

/**
 * Represents a list of tasks.
 */
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

    /**
     * Returns the number of tasks in the task list.
     * @return Number of tasks in the task list.
     */
    public TaskList findTasks(String keyword) {
        TaskList matchingTasks = new TaskList();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.addTask(task);
            }
        }
        return matchingTasks;
    }

    /**
     * Check if the task list is empty.
     * @return True if the task list is empty.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
