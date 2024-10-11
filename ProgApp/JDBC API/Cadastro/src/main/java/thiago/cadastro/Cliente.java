package thiago.cadastro;

/**
 *
 * @author thiago
 */
public class Cliente {
    private int id;
    public String nome, sexo, telefone;
    
    
    public Cliente(String nome, String sexo, String telefone) {
        if (nome == null || sexo == null || telefone == null) {
            throw new NullPointerException();
        }
        
        this.id = -1;
        this.nome = nome.trim();
        this.sexo = sexo.trim().substring(0, 1).toUpperCase();
        this.telefone = telefone.trim();
    }
    
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        
        if(this.id != -1) {
            throw new IllegalStateException();
        }
        
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
}
