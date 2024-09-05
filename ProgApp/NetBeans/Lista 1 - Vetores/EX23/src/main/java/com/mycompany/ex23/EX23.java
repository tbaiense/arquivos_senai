package com.mycompany.ex23;
import java.io.DataInputStream;
import java.io.IOException;
/**
23. Obter, via teclado, nome e capital de 3 estados quaisquer. Todas as informações
devem ser armazenadas em uma matriz. Um exemplo de matriz pode ser observada abaixo:
Piauí Teresina Ceará Fortaleza Maranhão São Luís Depois disso, mostrar os elementos da
matriz na mesma disposição do exemplo acima.
 */
public class EX23 {

    public static void main(String[] args) throws IOException {
        String[][] estados = new String[3][2];
        
        for(int e=0; e < estados.length; e++) {
            System.out.printf("Nome do estado %d:", e+1);
            DataInputStream in = new DataInputStream(System.in);
            estados[e][0] = in.readLine();
            
            System.out.printf("Capital do estado %d:", e+1);
            in = new DataInputStream(System.in);
            estados[e][1] = in.readLine();
        }
        System.out.println("# Estados ------------");
        for(String[] l : estados)
            for (String c : l)
                System.out.print(c + " ");
    }
}
