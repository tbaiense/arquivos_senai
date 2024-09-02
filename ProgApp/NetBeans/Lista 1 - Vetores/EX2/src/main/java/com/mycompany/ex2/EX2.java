package com.mycompany.ex2;

/** ALUNO: Thiago Moura Baiense
 * 2. Escreva um algoritmo que armazene em um vetor todos os números 
 * inteiros de 100 a 1 (em ordem decrescente). Após isso, o algoritmo 
 * deve imprimir todos os valores armazenados.
 */
public class EX2 {

    public static void main(String[] args) {
        int[] numeros = new int[100];
        
        for(int n=100, i=0; i < numeros.length; numeros[i++] = n--);
        
        for(int n : numeros)
            System.out.println(n);
    }
}
