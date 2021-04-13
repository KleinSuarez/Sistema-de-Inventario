package co.software.apiinventory.aplication;

public class CommandResponse <T> {
    private T value;

    public CommandResponse (T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }
}
