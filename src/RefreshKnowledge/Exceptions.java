package RefreshKnowledge;

import java.util.InputMismatchException;

public class Exceptions {
    public static void main(String[] args) throws Exception {
        int x = 3;

        if(x==0){
            throw new TemplateException();
        }
        if(x==1){
            throw new TemplateException("prøv igen");
        }
        if(x==2){
            throw new TemplateException("You typed the wrong number");
        }
        if(x==3){
            throw new TemplateException("You did not write a number", new InputMismatchException());
        }

    }
}
class TemplateException extends Exception{
    public TemplateException(String message, Throwable cause) {
        super(message, cause);
    }
    public TemplateException(String message) {
        super(message);
    }
    public TemplateException(Throwable cause) {
        super(cause);
    }
    TemplateException(){

    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }


}
