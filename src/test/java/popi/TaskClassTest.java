package popi;

import org.junit.jupiter.api.Test;
import popi.exception.PopiException;
import popi.task.Task;
import popi.task.TaskList;
import popi.task.Todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskClassTest {
    private Task task;
    private TaskList tasklist;

    @Test
    public void testAddTask() {
        task = new Todo("read book");
        tasklist = new TaskList();
        tasklist.publicAddTask(task);
        assertEquals(tasklist.getTask(1), task);
    }

    @Test
    public void testMarkAsDone() throws PopiException {
        task = new Todo("read book");
        tasklist = new TaskList();
        tasklist.publicAddTask(task);
        tasklist.publicMarkTask(1);
        assertEquals(tasklist.getTask(1).getStatusIcon(), "X");
    }

    @Test
    public void testMarkAsUndone() throws PopiException {
        task = new Todo("read book");
        tasklist = new TaskList();
        tasklist.publicAddTask(task);
        tasklist.publicMarkTask(1);
        tasklist.publicUnmarkTask(1);
        assertEquals(tasklist.getTask(1).getStatusIcon(), " ");
    }
}
