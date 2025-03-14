/**
 * Represents a Deadline task, which is a type of Task with an explicit deadline.
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Constructs a Deadline task with the given description and deadline.
     *
     * @param description The description of the Deadline task.
     * @param by          The deadline of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the string representation of the Deadline task.
     *
     * @return The string representation of the Deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

}
