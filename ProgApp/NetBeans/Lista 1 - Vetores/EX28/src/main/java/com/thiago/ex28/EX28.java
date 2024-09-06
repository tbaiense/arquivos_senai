package com.thiago.ex28;
import java.io.DataInputStream;
import java.io.IOException;
/**
28. Faça um algoritmo para ler 10 números e armazenar em um vetor. Após isto, o 
algoritmo deve ordenar os números no vetor em ordem crescente. Escrever o vetor ordenado. 
 * @author t.baiense
 */
public class EX28{

    public static void main(String[] args) throws IOException {
        int[] vetor = new int[10];
        for(int i=0; i < vetor.length; i++) {
            System.out.print((i+1) + ". num >>> ");
            while(true) {
                DataInputStream in = new DataInputStream(System.in);
                try {
                    vetor[i] = Integer.parseInt(in.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: entrada invalida. Tente novamente: ");
                }
            }
        }
        
        //Selection sort
        for(int fim=vetor.length-1; fim >=0; --fim) {
            int idMaior=0;
            int posAtual=0;
            
            while (posAtual <= fim) {
                if (vetor[posAtual] > vetor[idMaior]) {
                    idMaior = posAtual;
                }
                ++posAtual;
            }
            
            int copia = vetor[fim];
            vetor[fim] = vetor[idMaior];
            vetor[idMaior] = copia;
        }
        System.out.println("# VETOR ORDENADO -------------------");
        for(int n : vetor) {
            System.out.print(n + "  ");
        }
    }
}
