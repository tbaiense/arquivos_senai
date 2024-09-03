package com.thiago.ex2;
import java.util.Scanner;
/**
Escreva um programa que leia dois números inteiros e apresente na tela sua soma apenas se ambos forem
positivos. Use o mesmo formato do exercício anterior e, caso algum dos números fornecidos seja negativo
o programa deve escrever na tela que os "Dados de Entrada são Inválidos".
 */
public class EX2 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int num[], resultado;
        num = new int[2];
        
        for (int i=0; i < num.length; ++i) {
            System.out.printf("Escreva o %d. número: ", i+1);
            num[i] = stdin.nextInt();
        }
        
        resultado = numUm + numDois;
        System.out.printf("Soma de %d com %d = %d", numUm, numDois, resultado);
    }
}
