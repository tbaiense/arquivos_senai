package com.thiago.ex15;

import java.util.Scanner;
import java.util.InputMismatchException;

/** ALUNO: Thiago Moura Baiense
 * 15. Faça um algoritmo para ler um vetor de 20 números. Após isto, deverá ser lido mais 
 * um número qualquer e verificar se esse número existe no vetor ou não. Se existir, o algoritmo 
 * deve gerar um novo vetor sem esse número. (Considere que não haverão números repetidos 
 * no vetor).
 */
public class EX15 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int[] vet = new int[20];
        for(int i=0; i < vet.length; ++i) {
            System.out.print((i+1) + ". numero: ");
            while (true) {
                try {
                    vet[i] = stdin.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    stdin.nextLine();
                    System.out.print("ERRO: NÚMERO INVÁLIDO. Tente novamente: ");
                }
            }
        }
        System.out.print("\nInsira um número para procurar: ");
        int procurado;
        while (true) {
            try {
                procurado = stdin.nextInt();
                break;
            } catch (InputMismatchException e) {
                stdin.nextLine();
                System.out.print("ERRO: NÚMERO INVÁLIDO. Tente novamente: ");
            }
        }
        
        boolean existente = false;
        for(int n : vet) {
            if (n == procurado) {
                existente = true;
                break;
            }
        }
        
        if (existente) {
            // TODO: gerar um novo vetor sem esse número e sem números repetidos 
        } else {
            System.out.println("NÚMERO NÃO ENCONTRADO");
        }
    }
}
