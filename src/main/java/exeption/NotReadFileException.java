package exeption;

public class NotReadFileException extends Exception{
    public NotReadFileException(){
    }
    public  NotReadFileException(String message){
        super(message);
    }
    public NotReadFileException(Throwable cause){
        super(cause);
    }
    public NotReadFileException(String message, Throwable cause){
        super(message,cause);
    }

}
