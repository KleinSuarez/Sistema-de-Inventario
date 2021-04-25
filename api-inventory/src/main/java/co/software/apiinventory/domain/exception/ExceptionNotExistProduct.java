package co.software.apiinventory.domain.exception;

public class ExceptionNotExistProduct extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public ExceptionNotExistProduct(String message){
        super(message);
    }
}
