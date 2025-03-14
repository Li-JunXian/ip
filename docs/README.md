# Lintz User Guide

```
    ────────────────────────────────────────────────────────────────────────────
     _       _            _                
    | |     |_|  _      _| |_   _ _        
    | |     | | | |__  |_   _| |__  |      
    | |___  | | |  _  |  | |__  /  /       
    |_____| |_| |_| |_|  |___/ /____|      

    ────────────────────────────────────────────────────────────────────────────
     Hello Sir/Ma'am! I'm Lintz
     As always, pleasure to serve you Sir/Ma'am!

    ────────────────────────────────────────────────────────────────────────────
```


## Introduction
Lintz is a simple and efficient task management ChatBot designed to help you keep track of your tasks. Whether it's a to-do, a deadline, or an event, Lintz will help you stay organized and on top of your responsibilities.

---

## Features Overview
Lintz supports the following types of tasks:

1. **Todo**: A basic task with a description.
2. **Deadline**: A task with a description and a deadline.
3. **Event**: A task with a description, start time, and end time.

You can also:
- Mark tasks as done or undone.
- Delete tasks.
- List all tasks.
- Find tasks using keywords.

---

## Features

### 1. Add a Todo Task
Adds a simple to-do task.

**Format**: `todo <TASK_DESCRIPTION>`

**Example**: `todo Borrow books`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     Copy Sir/Ma'am, I've added this task:
       [T][ ] Borrow books
     You have now 1 tasks Sir/Ma'am.

    ────────────────────────────────────────────────────────────────────────────
```
---

## Adding Deadlines
Add a task with a specific deadline using the `deadline` command.

**Format**: `deadline <TASK_DESCRIPTION> /by <DATE_AND/OR_TIME>`

**Example**: `deadline Return books /by 2025-04-02`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     Copy Sir/Ma'am, I've added this task:
       [D][ ] Return books (by: 2025-04-02)
     You have now 2 tasks Sir/Ma'am.

    ────────────────────────────────────────────────────────────────────────────
```
---

### 2. Add an Event Task
Adds a task with a start and end time.

**Format**: `event <TASK_DESCRIPTION> /from <DATE_AND/OR_TIME> /to <DATE_AND/OR_TIME>`

**Example**: `event Supermaket groceries sales /from 2pm /to 4pm`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     Copy Sir/Ma'am, I've added this task:
       [E][ ] Supermarket groceries sales (from: 2pm to: 4pm)
     You have now 3 tasks Sir/Ma'am.

    ────────────────────────────────────────────────────────────────────────────
```
---

### 3. List All Tasks
Displays all tasks in your list.

**Format**: `list`

**Example**: `list`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     Here are the tasks in your list:
     1.[T][ ] Borrow books
     2.[D][ ] Return books (by: 2025-04-02)
     3.[E][ ] Supermarket groceries sales (from: 2pm to: 4pm)

    ────────────────────────────────────────────────────────────────────────────
```
---

### 4. Mark a Task as Done
Marks a task as completed.

**Format**: `mark <TASK_INDEX>`

**Example**: `mark 1`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     Congratulations Sir/Ma'am on completing this task:
       [T][X] Borrow books
    ────────────────────────────────────────────────────────────────────────────
```
---

### 5. Mark a Task as Undone
Marks a task as not completed.

**Format**: `unmark <TASK_INDEX>`

**Example**: `unmark 1`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     No worries Sir/Ma'am, we've got ample of time to complete this task:
       [T][ ] Borrow books
    ────────────────────────────────────────────────────────────────────────────
```
---

### 6. Delete a Task
Deletes a task from the list.

**Format**: `delete <TASK_INDEX>`

**Example**: `delete 1`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     Copy Sir/Ma'am, I've deleted this task:
       [T][ ] Borrow books
     You have now 2 tasks Sir/Ma'am.

    ────────────────────────────────────────────────────────────────────────────
```
---

### 7. Find Tasks
Searches for tasks that match a keyword.

**Format**: `find <KEYWORD>`

**Example**: `find groceries`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     Here are the matching tasks in your list:
     3.[E][ ] Supermarket groceries sales (from: 2pm to: 4pm)

    ────────────────────────────────────────────────────────────────────────────
```
---

### 8. Exit the Application
Exits the Lintz application.

**Format**: `bye`

**Example**: `bye`

**Expected Output**:
```
    ────────────────────────────────────────────────────────────────────────────
     See you Sir/Ma'am! I will be on standby at all times!
    ────────────────────────────────────────────────────────────────────────────
```
---

## Conclusion
Lintz is designed to make task management simple and efficient for your Sirs and Ma'ams. With its intuitive commands and user-friendly interface, you can focus on getting things done without worrying about forgetting important tasks.

Enjoy using my Lintz! 😊