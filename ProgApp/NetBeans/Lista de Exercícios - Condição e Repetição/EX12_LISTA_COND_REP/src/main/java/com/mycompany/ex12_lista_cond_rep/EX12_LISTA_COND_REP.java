package com.mycompany.ex12_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
12. Sistema de Votação: Desenvolva um programa que permita ao usuário votar em 3
candidatos diferentes. O programa deve utilizar um laço FOR para permitir a votação de
vários eleitores e, ao final, exibir o total de votos de cada candidato e o vencedor.
 */
public class EX12_LISTA_COND_REP {

    public static void main(String[] args) {
        short qntEleitores = 4;
        short votosCand1 = 0, votosCand2 = 0, votosCand3 = 0;
        Scanner console = new Scanner(System.in);
        
        for(int c = 0; c < qntEleitores; c++) {
            System.out.print("""
                             \nELEIÇÃO ------------------------
                             10 Candidata Maria
                             20 Candidato José
                             30 Candidato Ronaldo
                             
                             Vote em um dos candidatos digitando o número correspondente.
                             Escolha>>""" + ' ');
            switch(console.nextShort()) {
                case 10 -> ++votosCand1;
                case 20 -> ++votosCand2;
                case 30 -> ++votosCand3;
                default -> {
                    System.out.println("ERRO: CANDIDATO INVÁLIDO! Tente novamente.\n");
                    --c;
                }
            }
        }
        
        System.out.printf("""
                          RESULTADOS ***************
                          __________________ VOTOS
                          Candidata Maria   | %3d
                          Candidato José    | %3d
                          Candidato Ronaldo | %3d
                         
                           VENCEDOR:""" + ' ', votosCand1, votosCand2, votosCand3);
        
        if(votosCand1 > votosCand2 && votosCand1 > votosCand3) 
            System.out.println("Candidata Maria");
        else if (votosCand2 > votosCand1 && votosCand2 > votosCand3)
            System.out.println("Candidato José");
        else if (votosCand3 > votosCand1 && votosCand3 > votosCand2)
            System.out.println("Candidato Ronaldo");
        else
            System.out.println("EMPATE");
    }
}
