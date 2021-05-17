package co.software.apiinventory.domain.exception;

public class ExceptionInvalidValue extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public ExceptionInvalidValue(String message){
        super(message);
    }
}
