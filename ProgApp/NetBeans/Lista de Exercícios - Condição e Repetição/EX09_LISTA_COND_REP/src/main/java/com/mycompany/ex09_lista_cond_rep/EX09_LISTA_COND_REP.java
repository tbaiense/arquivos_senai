package com.mycompany.ex09_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
9. Verificação de Números Primos: Crie um programa que solicite ao usuário um número e
utilize um laço FOR para verificar se o número é primo. Utilize IF para determinar se ele é
divisível por outros números além de 1 e ele mesmo.
 */
public class EX09_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long num;
        boolean ePrimo = true;
        
        System.out.print("Digite um número inteiro para verificar se é primo:\n>>> ");
        num = Math.abs(console.nextLong());
        
        if (num == 1 || num == 0)
            ePrimo = false;
        else
            for(long i=2; i<num; i++) {
                if (num % i == 0)
                    ePrimo = false;
            }
        
        if(ePrimo)
            System.out.println("\nNÚMERO É PRIMO!");
        else
            System.out.println("\nNÚMERO NÃO É PRIMO!");
        
    }
}
