package co.software.apiinventory.domain.exception;

public class ExceptionInsufficientStock extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public ExceptionInsufficientStock(String message){
        super(message);
    }
}
