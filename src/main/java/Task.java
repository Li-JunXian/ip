
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
        System.out.println("\t" + "Nice! I've marked this task as done:");
        System.out.println("\t" + "  [" + this.getStatusIcon() + "] " + this.description);

    }

    public void markAsUndone() {
        this.isDone = false;
        System.out.println("\t" + "OK, I've marked this task as not done yet:");
        System.out.println("\t" + "  [" + this.getStatusIcon() + "] " + this.description);

    }
}
