package com.mycompany.ex01_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
1. Sistema de Aprovação de Alunos: Crie um programa que receba as notas de um aluno em
três disciplinas e calcule sua média. Utilize estruturas IF e ELSE para determinar se o aluno
foi aprovado, reprovado ou está em recuperação com base na média (Aprovado: média ≥ 7,
Recuperação: 5 ≤ média < 7, Reprovado: média < 5).
 */

public class EX01_LISTA_COND_REP {

    public static void main(String[] args) {
        int qntNotas = 3;
        float somaNotas = 0;
        float mediaNotas;
        Scanner console = new Scanner(System.in);
        
        //Receber notas
        System.out.println("Insira, a seguir, as notas no formato '7,2':");
        for (int n=0; n<qntNotas; ++n) {
            System.out.print((n+1) + "a nota: ");
            somaNotas += console.nextFloat();
        }
        
        mediaNotas = somaNotas / 3;
        
        System.out.printf("""
            RESULTADO: ----------------
            >>> MÉDIA FINAL: %1.1f pontos
            >>> SITUAÇÃO: """, mediaNotas);
        
        //Determinar situação
        if (mediaNotas >= 7)
            System.out.println(" APROVADO!");
        else if (mediaNotas >= 5)
            System.out.println(" RECUPERAÇÃO!");
        else
            System.out.println(" REPROVADO!");
    }
}
