package com.mycompany.ex4;

/** ALUNO: Thiago Moura Baiense
 * 4. Escreva um algoritmo em PORTUGOL que armazene em um vetor o quadrado dos
 * números ímpares no intervalo fechado de 1 a 20. Após isso, o algoritmo deve imprimir todos
 * os valores armazenados.
 */
public class EX4 {

    public static void main(String[] args) {
        final int INICIAL = 1, FINAL = 20;
        int[] quads = new int[(Math.abs(INICIAL - FINAL) + 1) - contarPares(INICIAL, FINAL)]; // Descobre a quantidade de ímpares subtraindo a qnt de pares
        int i=0, n=INICIAL; // Variável de controle
        
        if (INICIAL % 2 != 0) {
            quads[i++] = n;
            n += 2;
        } else
            ++n;

        for (; i < quads.length; n+= 2, i++)
            quads[i] = n * n;
        
        for(int q : quads)
            System.out.printf("%3d (%.0f)\n", q, Math.sqrt(q));
        
    }
    
    private static int contarPares(int ini, int fin) { // Calcula a quantidade de números pares existentes dentro de um intervalo
        int nPares = (Math.abs(ini - fin) + 1) / 2;
        if (ini % 2 == 0)
            ++nPares;
        
        return nPares;
    }
}
