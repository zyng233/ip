package popi.task;

import java.util.ArrayList;
import java.util.List;

import popi.exception.InvalidTaskNumberException;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private final List<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task Task to be added.
     */
    public void addTask(Task task) {
        assert task != null : "Task cannot be null";
        tasks.add(task);
    }

    /**
     * Unmark a task as done.
     *
     * @param index of the task to be unmarked
     * @return the task that was unmarked
     * @throws InvalidTaskNumberException
     */
    public Task unmarkTask(int index) throws InvalidTaskNumberException {
        validateTaskIndex(index - 1);
        Task task = tasks.get(index);
        task.markAsUndone();
        return task;
    }

    /**
     * Marks a task as done.
     *
     * @param index of the task to be marked
     * @return the task that was marked
     * @throws InvalidTaskNumberException
     */
    public Task markTask(int index) throws InvalidTaskNumberException {
        validateTaskIndex(index - 1);
        Task task = tasks.get(index);
        task.markAsDone();
        return task;
    }

    /**
     * Deletes a task from the task list.
     *
     * @param index Index of the task to be deleted.
     * @return Task that was deleted.
     * @throws InvalidTaskNumberException If the index is invalid.
     */
    public Task deleteTask(int index) throws InvalidTaskNumberException {
        validateTaskIndex(index - 1);
        Task task = tasks.get(index);
        tasks.remove(index);
        return task;
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return Number of tasks in the task list.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the task at the specified index.
     *
     * @param index Index of the task.
     * @return Task at the specified index.
     */
    public Task getTask(int index) throws InvalidTaskNumberException {
        validateTaskIndex(index - 1);
        return tasks.get(index - 1);
    }

    /**
     * Returns the number of tasks in the task list.
     *
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
     *
     * @return True if the task list is empty.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    private void validateTaskIndex(int index) throws InvalidTaskNumberException {
        if (index < 1 || index > tasks.size()) {
            throw new InvalidTaskNumberException("Invalid task number");
        }
    }
}
