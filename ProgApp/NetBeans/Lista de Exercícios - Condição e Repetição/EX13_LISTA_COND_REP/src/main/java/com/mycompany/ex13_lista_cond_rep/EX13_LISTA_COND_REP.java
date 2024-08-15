package com.mycompany.ex13_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
13. Verificação de Ano Bissexto: Crie um programa que solicite ao usuário um ano e utilize
IF-ELSE para verificar se ele é bissexto. O programa deve seguir as regras de divisibilidade
para determinar o resultado.
 */
public class EX13_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int ano;
        
        System.out.print("Digite um ano para verificar se é bissexto: ");
        ano = console.nextInt();
        
        // ANO BISSEXTO
        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))
            System.out.println("BISSEXTO!");
        else
            System.out.println("NÃO É BISSEXTO!");
    }
}
