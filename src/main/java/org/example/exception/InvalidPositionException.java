package org.example.exception;

/**
 * The `InvalidPositionException` class is an exception that is thrown when an invalid position is encountered.
 * It extends the `Exception` class.
 */
public class InvalidPositionException extends Exception{

    /**
     * Constructs a new `InvalidPositionException` object with the specified error message.
     *
     * @param message the error message
     */
    public InvalidPositionException(String message) {
        super(message);
    }
}
