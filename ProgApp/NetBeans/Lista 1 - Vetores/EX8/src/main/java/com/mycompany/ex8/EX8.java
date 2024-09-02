package com.mycompany.ex8;
import java.util.Scanner;
import java.util.InputMismatchException;
/** ALUNO: Thiago Moura Baiense
 * 8. Escreva um algoritmo que permita a leitura das notas de uma turma de 20 alunos.
 * Calcular a média da turma e contar quantos alunos obtiveram nota acima desta média
 * calculada. Escrever a média da turma e o resultado da contagem.
 */
public class EX8 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        final int QNT_NOTAS = 20;
        int qntMelhores = 0; // Quantidade de alunos que tiveram pontuação acima da média da turma 
        float[] notas = new float[QNT_NOTAS];
        float somaNotas = 0, mediaNotas;
        
        for(int n=0; n < QNT_NOTAS; ++n) {
            System.out.print("Nota do aluno " + (n+1) + ": ");
            float entrada; // Variável temporária de validação de entrada
            
            // Recebimento e verificação de entrada
            do {
                try {
                    entrada = stdin.nextFloat();
                    if (entrada >= 0.0f && entrada <= 10.0f) {
                        notas[n] = entrada;
                        break; // Sai do loop ao entrar com valor válido                        
                    } else 
                        throw new InputMismatchException();
                } catch (InputMismatchException e) {
                    stdin.nextLine();
                    System.out.print("\nERRO: entrada inválida.\nInsira um número inteiro ou decimal (ex. 10,3) tal que: 0 <= número <= 10\n>>> ");
                }
            } while (true);
            
            somaNotas += entrada;
        }
        
        mediaNotas = somaNotas / QNT_NOTAS;
        
        for (float nota : notas) {
            if (nota > mediaNotas)
                ++qntMelhores;
        }
        
        System.out.printf("""
            \n# RESULTADOS -----------------------------------------------------------
            Nota média da turma: %2.1f
            Quantidade de alunos acima da média da turma: %d
            """, mediaNotas, qntMelhores);
    }
}
