/**
 * Represents a custom exception for my Lintz chatbot.
 */
public class LintzException extends RuntimeException {
    /**
     * Constructs a LintzException with the given error message.
     *
     * @param message The error message.
     */
    public LintzException(String message) {
        super(message);
    }

}
