package crud;

import java.util.ArrayList;

public class Caderno {
    public int id, paginas;
    public String modelo, gramatura;
    boolean ativo;
    
    public Caderno(int id, String modelo, int paginas, Gramatura gramatura, boolean ativo) throws IllegalArgumentsException {
        this(modelo, paginas, gramatura, ativo);
        
        if (id < 1) {
            throw new IllegalArgumentsException(new InvalidIdException("Id não pode ser inferior a 1."));
        }
        
        this.id = id;
    }
    
    public Caderno(String modelo, int paginas, Gramatura gramatura, boolean ativo) throws IllegalArgumentsException {
        IllegalArgumentsException ex = null;
        ArrayList<Throwable> exList = null;
        
        if (modelo == null) {
            if (ex == null) {
                ex = new IllegalArgumentsException();
                exList = new ArrayList<Throwable>();
            }
            
            exList.add(new NullPointerException("Modelo não pode ser nulo."));
        }
        modelo = modelo.trim();
        if (modelo.isEmpty()) {
            if (ex == null) {
                ex = new IllegalArgumentsException();
                exList = new ArrayList<Throwable>();
            }
            
            exList.add(new InvalidModeloException("Modelo não pode ser vazio."));
        }
        
        if (paginas < 1) {
            if (ex == null) {
                ex = new IllegalArgumentsException();
                exList = new ArrayList<Throwable>();
            }
            
            exList.add(new InvalidPaginasException("Número de páginas não pode ser inferior a 1."));
        }
        
        if (ex != null) {
            Throwable[] causes = new Throwable[exList.size()];
            exList.toArray(causes);
            
            ex.initCauses(causes);
            throw ex;
        }
        
        this.modelo = modelo;
        this.paginas = paginas;
        this.gramatura = gramatura.valor;
        this.ativo = ativo;
    }
    
    static public class InvalidIdException extends Exception {
    
        public InvalidIdException() {
            
        }
        
        public InvalidIdException(String message) {
            super(message);
        }
    }
    
    static public class InvalidModeloException extends Exception {
    
        public InvalidModeloException() {
            
        }
        
        public InvalidModeloException(String message) {
            super(message);
        }
    }
    
    static public class InvalidPaginasException extends Exception {
    
        public InvalidPaginasException() {
            
        }
        
        public InvalidPaginasException(String message) {
            super(message);
        }
    }
    
    static public class InvalidGramaturaException extends Exception {
    
        public InvalidGramaturaException() {
            
        }
        
        public InvalidGramaturaException(String message) {
            super(message);
        }
    }
}
