package tech.mehdi.employeemanager.Service.Exception;

public class userNotFoundException extends RuntimeException{
    public userNotFoundException(String message) {
        super(message);
    }
}
