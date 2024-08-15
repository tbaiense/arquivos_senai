package com.mycompany.ex05_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
5. Tabuada Personalizada: Crie um programa que solicite ao usuário um número e gere a
tabuada desse número de 1 a 10 utilizando um laço FOR. O programa deve exibir o
resultado de cada multiplicação.
 */
public class EX05_LISTA_COND_REP {

    public static void main(String[] args) {
        double num;
        Scanner console = new Scanner(System.in);
        
        System.out.print("Digite o número para multiplicar: ");
        num = console.nextDouble();
        
        for(int i=1; i <= 10; ++i)
            System.out.printf("%4.1f * %2d = %4.1f\n", num, i, num*i);
        
    }
}
