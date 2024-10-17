package crud;

import java.util.Arrays;

public class PROJETO_17_THIAGO {

    public static void main(String[] args) {
        Caderno[] cadernos = BD.Caderno.selectAll();
        
        cadernos[0].modelo = "SOnic";
        
        BD.Caderno.update(cadernos[0]);
    }
}
