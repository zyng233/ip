# Popi User Guide

![Popi](../docs/Ui.png)

Popi is a task manager that helps you to organize and keep track of your tasks.
Featuring a futuristic personality, Popi engages users with sophisticated and friendly interactions 
to make task management more enjoyable.
Popi is designed to be simple and easy to use.

## Getting Started

To launch Popi, simply run the following command from the terminal:

```
java -jar popi.jar
```

Popi will greet you with a welcome message and will be ready to take commands.

## Task Management

Popi can helps you:
- [x] Add tasks (Todo, Deadline, Event)
- [x] Mark tasks as done and unmark tasks
- [x] Delete tasks
- [x] List all tasks
- [x] Find tasks by keyword

> **Tip:**
>To view the list of available commands, type `help` and press `Enter`.

## Command Summary

Action | Format                          | Examples
------ |---------------------------------| --------
todo | `todo DESCRIPTION`              | e.g. `todo read book`
deadline | `deadline DESCRIPTION /by DATE` | e.g. `deadline return book /by 2021-09-30 2359`
event | `event DESCRIPTION /at DATE`    | e.g. `event project meeting /from 2021-10-01 1400 /to 2021-10-01 1600`
done | `done INDEX`                    | e.g. `done 1
mark | `mark INDEX`                    | e.g. `mark 1`
unmark | `unmark INDEX`                | e.g. `unmark 1`
delete | `delete INDEX`                | e.g. `delete 1`
list | `list`                          |
find | `find KEYWORD`                  | e.g. `find book`
help | `help`                          |

With Popi, managing your tasks is not only efficient but also enjoyable. 
Get started today and let Popi take your productivity to the next level!



