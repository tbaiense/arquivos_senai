package com.thiago.ex1;
import java.util.Scanner;

/** 
 * Escreva um programa que leia dois números inteiros e apresente 
 * na tela sua soma, no seguinte formato:
   Soma de 5 com 7 = 12
 */
public class EX1 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numUm, numDois, resultado;
        System.out.print("Escreva o número um: ");
        numUm = stdin.nextInt();
        System.out.print("Escreva o número dois: ");
        numDois = stdin.nextInt();
        
        resultado = numUm + numDois;
        System.out.printf("Soma de %d com %d = %d", numUm, numDois, resultado);
    }
}
