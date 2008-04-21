/*
 * Created Apr 21, 2008 at 2:29:17 PM
 */
package jetbrains.mps.closures.runtime;


/**
 * This exception and its subclasses, if thrown from <code>next ()</code> method of an iterator,
 * will be re-thrown on the next call to <code>hasNext ()</code>.
 * @author fyodor
 */
public class DelayedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    public DelayedException() {
    }
    
    public DelayedException(String message) {
        super (message);
    }

    public DelayedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DelayedException(Throwable cause) {
        super(cause);
    }
    

}
