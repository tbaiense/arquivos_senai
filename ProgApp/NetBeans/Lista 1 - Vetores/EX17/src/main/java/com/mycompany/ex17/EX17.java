package com.mycompany.ex17;

import java.util.InputMismatchException;
import java.util.Scanner;

/** 
17. Faça um algoritmo para ler um vetor de 30 números. Após isto, ler mais um número
qualquer, calcular e escrever quantas vezes esse número aparece no vetor.
 */
public class EX17 {

    public static void main(String[] args) {
        int[] vet = new int[30];
        int vezes = 0; // Quantidade que o número procurado foi encontrado
        
        for(int i=0; i < vet.length; ++i) {
            
            System.out.print((i+1) + ". numero: ");
            while (true) {
                Scanner stdin = new Scanner(System.in);
                try {
                    vet[i] = stdin.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.print("ERRO: NÚMERO INVÁLIDO. Tente novamente: ");
                }
            }
        }
        System.out.print("\nInsira um número para procurar: ");
        int procurado;
        while (true) {
            Scanner stdin = new Scanner(System.in);
            try {
                procurado = stdin.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("ERRO: NÚMERO INVÁLIDO. Tente novamente: ");
            }
        }
        
        for (int num : vet)
            if (num == procurado)
                ++vezes;
        
        System.out.println("QUANTIDADE DE VEZES ENCONTRADO: " + vezes);
    }
}
