package com.thiago.ex13;
import java.util.InputMismatchException;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
 *  13. Faça um algoritmo para ler um valor N qualquer (que será o tamanho dos vetores). 
 *  Após, ler dois vetores A e B (de tamanho N cada um) e depois armazenar em um terceiro vetor 
 *  Soma a soma dos elementos do vetor A com os do vetor B (respeitando as mesmas posições) e 
 *  escrever o vetor Soma.
 */

public class EX13 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N;
        
        System.out.print("Insira o tamanho do vetor: ");
        while (true) {
            // Validação de entrada
            try {
                N = stdin.nextInt();
                if (N <=0) // Garante que número não seja negativo
                    throw new Exception();
                break;
            } catch (Exception e) {
                stdin.nextLine();
                System.out.print("\nERRO: entrada inválida. Digite um número inteiro (ex. 10).\n>>> ");
            }
        }
        System.out.println("\n# VETOR A ------------------------------");
        int[] A = preencherVetor(N);
        
        System.out.println("\n# VETOR B ------------------------------");
        int[] B = preencherVetor(N);
        
        int[] Soma = new int[N];
        for(int i=0; i < N; ++i)
            Soma[i] = A[i] + B[i];
        
        System.out.println("\n# VETOR SOMA ------------------------------");
        for(int numero : Soma)
            System.out.println(numero);
    }
    
    private static int[] preencherVetor(int tam) {
        Scanner stdin = new Scanner(System.in);
        int[] vetor = new int[tam];
        
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
        return vetor;
    }
}
