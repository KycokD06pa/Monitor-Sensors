package task.agsrTest.exception;

public class ValueException extends Exception{
    public ValueException(){
        super("cause: from > to");
    }
}
