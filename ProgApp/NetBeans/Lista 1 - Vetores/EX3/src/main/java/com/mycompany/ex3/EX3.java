package com.mycompany.ex3;

/** ALUNO: Thiago Moura Baiense
 * 3. Escreva um algoritmo que armazene em um vetor todos os números pares do intervalo
 * fechado de 1 a 100. Após isso, o algoritmo deve imprimir todos os valores armazenados.
 */
public class EX3 {

    public static void main(String[] args) {
        final int INICIAL = 1, FINAL = 100;
        int[] pares = new int[contarPares(INICIAL, FINAL)];
        int i=0, n=INICIAL; // Variável de controle
        
        if (INICIAL % 2 == 0) {
            pares[i++] = n;
            n += 2;
        } else
            ++n;

        for (; i < pares.length; n+= 2, i++)
            pares[i] = n;
        
        for(int nPar : pares)
            System.out.println(nPar);
        
    }
    
    private static int contarPares(int ini, int fin) { // Calcula a quantidade de números pares existentes dentro de um intervalo
        int nPares = (Math.abs(ini - fin) + 1) / 2;
        if (ini % 2 == 0)
            ++nPares;
        
        return nPares;
    }
}
