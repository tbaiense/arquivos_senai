package crud;

public class Caderno {
    public int id, paginas;
    public String modelo, gramatura;
    boolean ativo;
    
    public Caderno(int id, String modelo, int paginas, Gramatura gramatura, boolean ativo) {
        this(modelo, paginas, gramatura, ativo);
        
        if (id < 1) {
            throw new IllegalArgumentException();
        }
        
        this.id = id;
    }
    
    public Caderno(String modelo, int paginas, Gramatura gramatura, boolean ativo) {
        modelo = modelo.trim();
        
        if (paginas < 1 || modelo.isEmpty()) {
            throw new IllegalArgumentException();
        }
        
        if (modelo == null) {
            throw new NullPointerException();
        }
        
        this.modelo = modelo;
        this.paginas = paginas;
        this.gramatura = gramatura.valor;
        this.ativo = ativo;
    }
}
