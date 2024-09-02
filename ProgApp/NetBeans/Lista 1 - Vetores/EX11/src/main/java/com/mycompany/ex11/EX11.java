package com.mycompany.ex11;

import java.util.Scanner;
import java.util.InputMismatchException;

/** ALUNO: Thiago Moura Baiense
 * 11. Ler um vetor A de 10 números. Após, ler mais um número e guardar em uma variável
 * X. Armazenar em um vetor M o resultado de cada elemento de A multiplicado pelo valor X.
 * Logo após, imprimir o vetor M.
 */
public class EX11 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int X = 0;
        int[] A = new int[10];
        int[] M = new int[10];
        
        for(int n = 0; n < A.length; ++n) {
            System.out.print("Insira o " + (n+1) + " número: ");
            do {
                // Validação de entrada
                try {
                    A[n] = stdin.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    stdin.nextLine();
                    System.out.print("\nERRO: entrada inválida. Digite um número inteiro (ex. 10).\n>>> ");
                }
            } while (true);
        }
        
        System.out.print("Agora, digite o multiplicador: ");
        do {
            // Validação de entrada
            try {
                X = stdin.nextInt();
                break;
            } catch (InputMismatchException e) {
                stdin.nextLine();
                System.out.print("\nERRO: entrada inválida. Digite um número inteiro (ex. 10).\n>>> ");
            }
        } while (true);
        
        System.out.println("\n# Vetor M ------------------------------------");
        for(int numero = 0; numero < M.length && numero < A.length; ++numero) {
            M[numero] = A[numero] * X;
            System.out.println(M[numero]);
        }
    }
}
