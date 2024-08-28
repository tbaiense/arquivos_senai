package com.thiago.projeto_12_thiago;
import java.util.Scanner;

/**
 * Essa classe implementa um pequeno jogo de adivinhação de filmes,
 * onde o usuário adivinha o filme onde outro jogador especificou.
 */

public class PROJETO_12_THIAGO {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String jogadorUm, jogadorDois; // Nome dos jogadores
        String filme; // Nome do filme, inserido pelo jogador um
        short qntPistas = 5;
        short tentativas = 5; // Número de tentativas para o jogador 2
        
        System.out.print("Jogador 1 - Insira seu nome: ");
        jogadorUm = stdin.nextLine();
        System.out.print(jogadorUm + " - Especifique o nome do filme: ");
        filme = stdin.nextLine().trim();
        
        // Dicas

        String[] pistas = new String[qntPistas]; // Armazena as pistas inseridas pelo jogador um
        for (int pn = 0; pn < qntPistas; ++pn) {
            System.out.printf("Pista n.%d : ", pn+1);
            pistas[pn] = stdin.nextLine();
        }
        
        System.out.println("------------------------------");
        
        //Cadastro jogador dois
        System.out.print("Jogador 2 - Insira seu nome: ");
        jogadorDois = stdin.nextLine();
        
        String escolha;
        System.out.printf("\nPista: %s\n%s - Advinhe o nome do filme: ", pistas[qntPistas - 1], jogadorDois);
        --qntPistas; 
        
        // Escolhas
        do {
            escolha = stdin.nextLine().trim();
            --tentativas;
            if (filme.equalsIgnoreCase(escolha)) {
                System.out.println("ACERTOU!!");
                break;
            } else {
                System.out.println(jogadorDois + ", você errou!");
                if (tentativas > 0) { // Se houver tentativas restantes
                    if (qntPistas > 0) {// Se houver pistas restantes
                        System.out.println(qntPistas + " pista restante: " + pistas[qntPistas - 1]);
                        --qntPistas;
                    }
                    System.out.print("Tente novamente: ");
                } else
                    System.out.println("ACABARAM SUAS TENTATIVAS E VOCÊ PERDEU! :(");
            }
        } while (tentativas > 0);
            
    }
    
}
