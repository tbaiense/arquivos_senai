package com.mycompany.ex16;

import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
 * 16. Faça um algoritmo para ler dois vetores V1 e V2 de 15 números cada. Calcular e
escrever a quantidade de vezes que V1 e V2 possuem os mesmos números e nas mesmas
posições.
 */

public class EX16 {

    public static void main(String[] args) {
        final int TAM_VET = 15;
        int[] V1 = new int[TAM_VET];
        int[] V2 = new int[TAM_VET];
        int iguais = 0; // Quantidade de vezes que números iguais nas mesmas posições foram inseridos
        
        for (int v=0; v < 2; ++v) {
            System.out.println("\n# VETOR " + (v+1) + " --------------");
            for(int i=0; i < TAM_VET; ++i) {
                System.out.print((i+1) + ". numero: ");
                while (true) {
                    Scanner stdin = new Scanner(System.in);
                    try {
                        switch (v) {
                            case 0 -> V1[i] = stdin.nextInt();
                            case 1 -> V2[i] = stdin.nextInt();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.print("ERRO: NÚMERO INVÁLIDO. Tente novamente: ");
                    }
                }
                
                if (v == 1 && V1[i] == V2[i])
                    ++iguais;
            }   
        }
        
        System.out.println("\nQUANTIDADE DE NÚMEROS IGUAIS NAS MESMAS POSICOES: " + iguais);
    }
}
