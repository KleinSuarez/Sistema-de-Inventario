package co.software.apiinventory.domain.exception;

public class ExeptionAlreadyExitsReference extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ExeptionAlreadyExitsReference(String message){
        super(message);
    }
}
