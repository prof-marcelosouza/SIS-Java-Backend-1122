package exceptions;

public class ClienteException extends Exception {

    public ClienteException() {
    }

    public ClienteException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
