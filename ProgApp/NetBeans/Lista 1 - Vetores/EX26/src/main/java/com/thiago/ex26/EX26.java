package com.thiago.ex26;
import java.io.DataInputStream;
import java.io.IOException;
/**
26. Escreva um programa para receber 100 números inteiros e armazená-los em um vetor. 
Depois, receber um número e mostrar em que posição do vetor ele está armazenado. Caso o 
número não esteja no vetor, exibir a mensagem “Número não encontrado”. 
 * @author t.baiense
 */
public class EX26 {

    public static void main(String[] args) throws IOException {
        int[] numeros = new int[100];
        
        System.out.println("Insira os numeros a seguir:");
        for (int i=0; i < numeros.length; i++) {
            System.out.print(i + ". num >>> ");
            while(true) {
                DataInputStream in = new DataInputStream(System.in);
                try {
                    //numeros[i] = Integer.parseInt(in.readLine());
                    System.out.println(numeros[i] = (int)Math.round(Math.random() * 100));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: numero invalido. Tente novamente: ");
                }
            }
        }
        
        System.out.print("Procurar numero: ");
        int procurado;
        while(true) {
            DataInputStream in = new DataInputStream(System.in);
            try {
                procurado = Integer.parseInt(in.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ERRO: numero invalido. Tente novamente: ");
            }
        }
        boolean encontrado=false;
        for(int n=0; n < numeros.length; n++) {
            if(numeros[n] == procurado) {
                if (!encontrado)
                    System.out.print("ENCONTRADO NA POSICAO: " + n);
                else
                    System.out.print("  " + n);
                encontrado = true;
            }    
        }
        
        if(!encontrado) {
            System.out.println("NUMERO NAO ENCONTRADO");
        }
    }
}
