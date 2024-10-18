package crud;

/**
 *
 * @author thiago
 */
public class Teste {
    
    public static void main(String[] args) {
        try {
            Caderno c = new Caderno(-1, "modelo", 123, Gramatura.OFFSET_100G, true);
        } catch (IllegalArgumentException e) {
            if (e.getCause() instanceof Caderno.InvalidIdException) {
                System.out.print("ID INVÁLIDO!");
            }
        }
        
    }
}
