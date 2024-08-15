package com.mycompany.ex15_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
15. Cálculo de Fatorial: Crie um programa que solicite ao usuário um número e utilize um
laço FOR para calcular o fatorial desse número. O programa deve exibir o resultado ao final.
 */
public class EX15_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int escolhaUsuario, fatorial;

        System.out.print("Digite um número: ");
        fatorial = escolhaUsuario = console.nextInt();
        
        for (int i = escolhaUsuario-1; i >= 2; i--)
            fatorial *= i;
        System.out.println("RESULTADO: " + fatorial);
    }
}
