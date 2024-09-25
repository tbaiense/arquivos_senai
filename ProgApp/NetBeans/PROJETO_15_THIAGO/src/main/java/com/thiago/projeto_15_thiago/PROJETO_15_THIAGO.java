package com.thiago.projeto_15_thiago;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PROJETO_15_THIAGO {
    public static void main(String[] args) throws IOException {
        final int QTD_NUMEROS = 5;
        int[] vetor = new int[QTD_NUMEROS];
        Scanner in;
        System.out.println("Insira os numeros para fazer tabuada:");
        for(int i=0; i < QTD_NUMEROS; i++) {
            System.out.print((i+1) + ". numero: ");
            while(true) {
                try {
                    in = new Scanner(System.in);
                    escreverTabuada(vetor[i] = in.nextInt());
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Numero invalido.\nTente novamente >>> ");
                }
            }
        } 
    }
    
    public static void escreverTabuada(int numAtual) throws IOException {
        final int TAB_MAX = 10;
        final String LOCAL_ARQUIVO = String.format("C:\\Users\\Public\\tabuada-%s.txt", numAtual); 
        FileWriter arquivo = new FileWriter(LOCAL_ARQUIVO);
        PrintWriter writer = new PrintWriter(arquivo);
        
        writer.printf("TABUADA DE "+ numAtual + "----------\n");
        for(int i=1; i <= TAB_MAX; i++) {
            writer.printf("%2d x %2d = %3s\n", numAtual, i, numAtual*i);
        }
        writer.close();
    }
}
