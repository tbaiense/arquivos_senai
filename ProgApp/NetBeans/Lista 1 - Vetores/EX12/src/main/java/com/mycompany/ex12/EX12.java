package com.mycompany.ex12;
import java.util.Scanner;
import java.util.InputMismatchException;

/** ALUNO: Thiago Moura Baiense
 * 12. Faça um algoritmo para ler 20 números e armazenar em um vetor. Após a leitura total
 * dos 20 números, o algoritmo deve escrever esses 20 números lidos na ordem inversa.
 */
public class EX12 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int[] vetor = new int[2];
        
        for(int n = 0; n < vetor.length; ++n) {
            System.out.print("Insira o " + (n+1) + " número: ");
            do {
                // Validação de entrada
                try {
                    vetor[n] = stdin.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    stdin.nextLine();
                    System.out.print("\nERRO: entrada inválida. Digite um número inteiro (ex. 10).\n>>> ");
                }
            } while (true);
        }
        String inverso = "\n# Vetor invertido -------------------------------\n";
        for(int i=vetor.length-1; i >= 0; --i)
            inverso += vetor[i] + "\n";
        
        System.out.println(inverso);
    }
}
