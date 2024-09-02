package com.mycompany.ex10;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
 * 10. O mesmo exercício anterior, mas agora deve escrever o menor elemento do vetor e a
 * respectiva posição dele nesse vetor.
 */
public class EX10 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int posMenor = 0;
        
        int[] Q = new int[20];
        
        for(int n = 0; n < Q.length; ++n) {
            System.out.print("Insira o " + (n+1) + " número: ");
            int entrada;
            do {
                // Validação de entrada
                try {
                    entrada = stdin.nextInt();
                    if (entrada >= 0)
                        break;
                    else
                        throw new Exception();
                } catch (Exception e) {
                    stdin.nextLine();
                    System.out.print("\nERRO: entrada inválida. Digite um número positivo inteiro (ex. 10).\n>>> ");
                }
            } while (true);
            
            Q[n] = entrada;
            
            if (entrada < Q[posMenor])
                posMenor = n;
        }
        
        System.out.printf("""
            \n# RESULTADOS -----------------------------------------------------------
            Menor número: %d (índice %d)
            """, Q[posMenor], posMenor);
    }
}
