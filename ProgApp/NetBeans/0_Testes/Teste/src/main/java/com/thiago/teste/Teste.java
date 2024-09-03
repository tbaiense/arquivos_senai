package com.thiago.teste;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Teste {
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] vetUm = new int[2];
        int[] vetDois = new int[2];
        
        for(int v=0; v < 2; ++v) {
            switch (v) {
                case 0 -> {
                    System.out.println("# VETOR UM -----------------------");
                    vetUm = receberVetor(2);
                }
                case 1 -> {
                    System.out.println("# VETOR DOIS -----------------------");
                    vetDois = receberVetor(2);
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < 2; ++i) {
            int resultado;
            System.out.print("Resultado de " + vetUm[i] + " / " + vetDois[i] + " = ");
            try {
                resultado = vetUm[i] / vetDois[i];
                System.out.printf("%d\n", resultado);
            } catch (ArithmeticException e) {
                System.out.println("ERRO: Divisao invalida!");
            }
        }
        scanner.close();
    }
    
    private static int[] receberVetor(int tam) {
        Scanner scanner = new Scanner(System.in);
        int[] vet = new int[tam];
        
        for(int i=0; i < tam; ++i) {
            System.out.print((i+1) + ". numero para o vetor: ");
            while(true) {
                try {
                    vet[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.print("ERRO: NÚMERO NÁO É INTEIRO. TENTE NOVAMENTE: ");
                }
            }
        }
        return vet;
    }
}
