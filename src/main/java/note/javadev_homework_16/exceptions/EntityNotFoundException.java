package note.javadev_homework_16.exceptions;

public class EntityNotFoundException extends IllegalArgumentException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
