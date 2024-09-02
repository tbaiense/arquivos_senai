package com.mycompany.ex6;
/** ALUNO: Thiago Moura Baiense
 * 6. Dado o seguinte vetor:
        V = { 5, 1, 4, 2, 7, 8, 3, 6 }

 *   Qual será o conteúdo do vetor V depois de executado o algoritmo abaixo?
      Para i de 8 até 5 passo -1 faca
        aux <- v [i]
        v [i] <- v [8 - i + 1]
        v [8 - i + 1] <- aux
      Fim_Para
        v [3] <- v [1]
        v [v [3]] <- v [v [2]]
        * 
     QUESTÃO ERRADA?
 */
public class EX6 {

    public static void main(String[] args) {
        int[] vetor = { 5, 1, 4, 2, 7, 8, 3, 6 };
        int aux;
        
        for (int i = 8; i >= 5; --i) {
            aux = vetor[i];
            vetor[i] = vetor[8 - i + 1];
            vetor[8 - i + 1] = aux;
        }
        
        vetor[3] = vetor[1];
        vetor[vetor[3]] = vetor[vetor[2]];
        
        for(float numero : vetor) {
            System.out.println(numero);
        }
    }
}
