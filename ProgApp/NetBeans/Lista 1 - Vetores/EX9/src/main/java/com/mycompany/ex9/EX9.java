package com.mycompany.ex9;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
 * 9. Ler um vetor Q de 20 posições (aceitar somente números positivos). Escrever a seguir
 * o valor do maior elemento de Q e a respectiva posição que ele ocupa no vetor.
 */
public class EX9 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int posMaior = 0;
        
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
            
            if (entrada > Q[posMaior])
                posMaior = n;
        }
        
        System.out.printf("""
            \n# RESULTADOS -----------------------------------------------------------
            Maior número: %d (índice %d)
            """, Q[posMaior], posMaior);
    }
}
