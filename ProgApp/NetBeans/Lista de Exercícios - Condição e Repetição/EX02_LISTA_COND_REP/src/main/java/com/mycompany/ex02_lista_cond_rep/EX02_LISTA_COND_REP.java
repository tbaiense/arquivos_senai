package com.mycompany.ex02_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
2. Jogo de Adivinhação: Desenvolva um programa em que o computador escolhe um número
aleatório entre 1 e 100, e o usuário tem que adivinhar. Utilize um laço WHILE para permitir
múltiplas tentativas até que o usuário acerte, e IF-ELSE para fornecer dicas (se o número é
maior ou menor).
 */
public class EX02_LISTA_COND_REP {

    public static void main(String[] args) {
        int numInserido, numGerado;
        boolean acertou = false;
        Scanner console = new Scanner(System.in);
        
        //Geração do número
        numGerado = (int) Math.round(1 + Math.random() * (100-1));
        
        System.out.println("Um número aleatório foi gerado! Tente advinhá-lo: " + numGerado);
        //Advinhação
        while(!acertou) {
            System.out.print(">>> ");
            numInserido = console.nextInt();
            
            if(numInserido == numGerado)
                acertou = true;
            else if (numInserido > numGerado)
                System.out.println("ERRADO: o número sorteado é menor.");
            else
                System.out.println("ERRADO: o número sorteado é maior.");
        }
        System.out.println("\nParabéns, você acertou o número sorteado!\n");
    }
}
