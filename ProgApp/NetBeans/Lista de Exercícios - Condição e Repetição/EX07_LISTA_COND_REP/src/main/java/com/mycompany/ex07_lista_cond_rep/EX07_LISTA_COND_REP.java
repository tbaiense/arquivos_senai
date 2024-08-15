package com.mycompany.ex07_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
7. Contagem de Números Pares e Ímpares: Crie um programa que solicite ao usuário um
número e utilize um laço FOR para percorrer todos os números de 1 até o número inserido.
O programa deve contar e exibir a quantidade de números pares e ímpares.
 */
public class EX07_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num, pares=0, impares=0;
        
        System.out.print("Digite um número inteiro: ");
        num = console.nextInt();
        
        for(int n=1; n<=num; ++n)
            if (n % 2 == 0)
                pares++;
            else
                ++impares;
        
        System.out.println("IMPARES: " + impares + " PARES " + pares);
    }
}
