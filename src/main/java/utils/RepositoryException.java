package utils;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RepositoryException(String msg) {
        super(msg);
    }
}
