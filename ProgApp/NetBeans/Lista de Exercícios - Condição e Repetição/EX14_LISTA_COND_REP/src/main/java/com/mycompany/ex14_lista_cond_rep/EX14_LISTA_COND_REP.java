package com.mycompany.ex14_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
14. Jogo do Par ou Ímpar: Desenvolva um jogo em que o usuário escolhe um número e o
programa sorteia outro número aleatório. Utilize IF-ELSE para determinar se a soma dos
dois números é par ou ímpar, e declare o vencedor com base na escolha do usuário.
 */
public class EX14_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int escolhaUsuario;
        int numAleatorio = (int) Math.round(1 + Math.random() * (100-1));
        int somaNum;
        
        System.out.print("Digite um número: ");
        escolhaUsuario = console.nextInt();
        somaNum = escolhaUsuario + numAleatorio;
        System.out.print("Número aleatório: " + numAleatorio);
        
        if (escolhaUsuario % 2 == numAleatorio % 2) // Ambos do mesmo tipo
            System.out.println("EMPATE!");
        else
            if (escolhaUsuario % 2 == somaNum % 2)
                System.out.println("USUÁRIO GANHOU!");
            else
                System.out.println("PC VENCEU!");
        
    }
}
