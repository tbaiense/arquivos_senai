package crud;

import java.util.ArrayList;

public class Caderno {
    public int id, paginas;
    public String modelo, gramatura;
    boolean ativo;
    
    public Caderno(int id, String modelo, int paginas, Gramatura gramatura, boolean ativo) throws IllegalArgumentsException {
        IllegalArgumentsException exs = null;
        ArrayList<Throwable> exList = null;
        
        try {
            setId(id);
        } catch (InvalidIdException ex) {
            exs = new IllegalArgumentsException();
            exList = new ArrayList<Throwable>();
            exList.add(ex);
        }
        
        if (modelo == null) {
            if (exs == null) {
                exs = new IllegalArgumentsException();
                exList = new ArrayList<Throwable>();
            }
            
            exList.add(new InvalidModeloException("Modelo não pode ser nulo."));
        }
        modelo = modelo.trim();
        if (modelo.isEmpty()) {
            if (exs == null) {
                exs = new IllegalArgumentsException();
                exList = new ArrayList<Throwable>();
            }
            
            exList.add(new InvalidModeloException("Modelo não pode ser vazio."));
        }
        
        if (paginas < 1) {
            if (exs == null) {
                exs = new IllegalArgumentsException();
                exList = new ArrayList<Throwable>();
            }
            
            exList.add(new InvalidPaginasException("Número de páginas não pode ser inferior a 1."));
        }
        
        if (gramatura == null) {
            if (exs == null) {
                exs = new IllegalArgumentsException();
                exList = new ArrayList<Throwable>();
            }
            
            exList.add(new InvalidGramaturaException("Gramatura não pode ser nula."));
        }
        
        if (exs != null) {
            Throwable[] causes = new Throwable[exList.size()];
            exList.toArray(causes);
            
            exs.initCauses(causes);
            throw exs;
        }
        
        this.modelo = modelo;
        this.paginas = paginas;
        this.gramatura = gramatura.valor;
        this.ativo = ativo;
    }
    
    public Caderno(String modelo, int paginas, Gramatura gramatura, boolean ativo) throws IllegalArgumentsException {
        this(1, modelo, paginas, gramatura, ativo);
        this.id = -1;
    }
    
    private void setId(int id) throws InvalidIdException {
        if (id < 1) {
            throw new InvalidIdException("Id não pode ser inferior a 1.");
        } else {
            this.id = id;
        }
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
