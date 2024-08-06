package exception;

public class StudentNotFoundException extends RuntimeException{
    String message = "Student not found";

    public StudentNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
