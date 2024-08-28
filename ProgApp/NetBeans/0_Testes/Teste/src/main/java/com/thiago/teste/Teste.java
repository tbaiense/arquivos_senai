package com.thiago.teste;
import java.util.Scanner;

public class Teste {
    private static String[] nomes = new String[10]; // Nomes inseridos pelo usuário
    private static int qntNomesReg; // Contabiliza quantos nomes foram inseridos
    
    public static void main(String[] args) {
        System.out.println("Escreva os nomes a seguir:");
        for (int n = 0; n < 10; ++n)
            nomes[n] = receberNome();
        exibirNomes(nomes);
    }
    
    private static String receberNome() {
        System.out.print(++qntNomesReg + ") >>> ");
        Scanner stdin = new Scanner(System.in);
        return stdin.nextLine();
    }
    
    private static void exibirNomes(String[] nomes) {
        System.out.printf("\n# Nomes registrados (%s):\n", qntNomesReg);
        for (String nome : nomes) // Percorre o vetor `nomes`, colocando cada String em `nome`
            System.out.println(nome);
    }
}
