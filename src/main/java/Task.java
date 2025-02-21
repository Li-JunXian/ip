
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("\t" + "Congratulations Sir/Ma'am on completing this task:");
        System.out.println("\t" + "  " + this + "\n");
    }

    public void markAsUndone() {
        this.isDone = false;
        System.out.println("\t" + "No worries Sir/Ma'am, we've got ample of time to complete this task:");
        System.out.println("\t" + " " + this + "\n");
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
