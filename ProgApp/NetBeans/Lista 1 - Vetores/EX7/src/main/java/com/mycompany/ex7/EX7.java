package com.mycompany.ex7;
import java.util.Scanner;
/** ALUNO: Thiago Moura Baiense
 * 7. Escreva um algoritmo que permita a leitura dos nomes de 10 pessoas e armaze os
 * nomes lidos em um vetor. Após isto, o algoritmo deve permitir a leitura de mais 1 nome
 * qualquer de pessoa e depois escrever a mensagem ACHEI, se o nome estiver entre os 10
 * nomes lidos anteriormente (guardados no vetor), ou NÃO ACHEI caso contrário.
 */
public class EX7 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String[] nomes = new String[2];
        String procurado; // Nome a ser procurado, inserido pelo usuário
        boolean encontrado = false; // Se o nome procurado foi encontrado em `nomes`
        
        for(int i = 0; i < nomes.length; ++i) {
            System.out.print((i+1) + ". nome: ");
            nomes[i] = stdin.nextLine().trim();
        }
        
        System.out.print("Nome a procurar na lista: ");
        procurado = stdin.nextLine().trim();
        
        for(String nome : nomes) 
            if (nome.equalsIgnoreCase(procurado)) {
                encontrado = true;
                break;
            }
        
        String mensagem = (encontrado) ? "ACHEI!" : "NÃO ACHEI!";
        System.out.print(mensagem);
    }
}
