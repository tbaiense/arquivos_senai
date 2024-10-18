package crud;

public class IllegalArgumentsException extends Exception {
    
    private Throwable[] causes;
    private int nextCause;
    
    public IllegalArgumentsException() {}
    
    public IllegalArgumentsException(String message) {
        super(message);
    }
    
    public IllegalArgumentsException(Throwable cause) {
        this.initCause(cause);
    }
    
    public IllegalArgumentsException(Throwable... causes) {
        this.initCauses(causes);
    }
    
    public IllegalArgumentsException(String message, Throwable cause) {
        super(message);
        this.initCause(cause);
    }
    
     public IllegalArgumentsException(String message, Throwable... causes) {
        super(message);
        this.initCauses(causes);
    }
    
    public Throwable initCause(Throwable cause) {
        causes = new Throwable[1];
        causes[0] = cause;
        
        return this;
    }
    
    public Throwable initCauses(Throwable... causes) {
        if (causes == null) {
            return this;
        }
        
        this.causes = causes;
        
        return this;
    }
    
    @Override
    public Throwable getCause() {
        if (causes == null) {
            return null;
        }
        
        if (causes.length == 1) {
            return causes[0];
        } else if (this.nextCause < causes.length) {
            return causes[nextCause++];
        } else {
            return null;
        }
    }
    
    public Throwable[] getCauses() {
        return this.causes;
    }
}
