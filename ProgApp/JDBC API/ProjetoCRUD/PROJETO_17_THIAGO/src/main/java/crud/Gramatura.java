package crud;

/**
 *
 * @author thiago
 */
public enum Gramatura {
    OFFSET_70G ("70g"),
    OFFSET_100G ("100g");
    
    public final String valor;
    
    private Gramatura(String valor) {
        this.valor = valor;
    }
}
