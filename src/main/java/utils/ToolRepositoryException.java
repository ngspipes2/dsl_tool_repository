package utils;

public class ToolRepositoryException extends RuntimeException {

    public ToolRepositoryException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ToolRepositoryException(String msg) {
        super(msg);
    }
}
