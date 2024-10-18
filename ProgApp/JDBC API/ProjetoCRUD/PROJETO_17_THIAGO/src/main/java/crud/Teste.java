package crud;

import java.util.Arrays;

/**
 *
 * @author thiago
 */
public class Teste {
    
    public static void main(String[] args) {
        try {
            Caderno c = new Caderno("", -2, Gramatura.OFFSET_100G, true);
        } catch (IllegalArgumentsException exs) {
            Throwable cause;
            
            while ((cause = exs.getCause()) != null) {
                System.out.println(cause.getMessage());
            }
        }
    }
}
