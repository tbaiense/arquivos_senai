package com.mycompany.ex10_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
10. Contagem Regressiva: Desenvolva um programa que exiba uma contagem regressiva de
10 até 0, utilizando um laço WHILE. O programa deve exibir cada número em sequência até
alcançar o zero.
 */
public class EX10_LISTA_COND_REP {

    public static void main(String[] args) {
        int num = 10;
        while (num >= 0)
            System.out.println(num--);
    }
}
