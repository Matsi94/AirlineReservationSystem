package pl.matsi94.ara.exception;

public class PassengerAlreadyExistsException extends RuntimeException {
    public PassengerAlreadyExistsException(String message){
        super(message);
    }
}
