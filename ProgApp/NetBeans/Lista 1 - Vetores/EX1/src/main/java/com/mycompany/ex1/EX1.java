package com.mycompany.ex1;

/** ALUNO: Thiago Moura Baiense
 * 1.Escreva um algoritmo que armazene em um vetor todos os números inteiros de 0 a 50. 
 * Após isso, o algoritmo deve imprimir todos os valores armazenados.
 */
public class EX1 {

    public static void main(String[] args) {
        int[] numeros = new int[51];
        
        for(int n=0; n <= 50; numeros[n] = n++);
        
        for(int n : numeros)
            System.out.println(n);
    }
}
