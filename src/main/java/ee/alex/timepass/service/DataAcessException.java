package ee.alex.timepass.service;

public class DataAcessException extends Exception {
    public DataAcessException() {
        super();
    }

    public DataAcessException(String message) {
        super(message);
    }

    public DataAcessException(String message, Throwable cause) {
        super(message, cause);
    }
}
