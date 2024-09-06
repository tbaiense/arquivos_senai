package com.thiago.ex29;
import java.io.DataInputStream;
import java.io.IOException;
/**
29. O mesmo exercício anterior, mas depois de ordenar os elementos do vetor em ordem
crescente, deve ser lido mais um número qualquer e inserir esse novo número na posição
correta, ou seja, mantendo a ordem crescente do vetor.
 * @author t.baiense
 */
public class EX29 {

    public static void main(String[] args) throws IOException {
        int[] numeros = new int[10];
        DataInputStream in;
        
        for(int n=0; n<numeros.length; ++n) {
            System.out.print((n+1) + ". num >>> ");
            numeros[n] = receberIntValidado();
        }
        
        numeros = selectionSort(numeros);
        
        System.out.println("\n# ARRAY ORDENADO --------------");
        for(int n : numeros)
            System.out.print(n + "  ");
        
        System.out.println("\nInsira outro numero no array: ");
        numeros = inserirInteiroVetor(numeros, receberIntValidado()); // Devolve vetor novo com incremento de espacos em +1
        
        System.out.println("\n# NOVO ARRAY ORDENADO --------------");
        for(int n : numeros)
            System.out.print(n + "  ");
        
    }
    
    private static int receberIntValidado() throws IOException{
        int valor;
        DataInputStream in;
        while(true) {
            in = new DataInputStream(System.in);
            try {
                valor = Integer.parseInt(in.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("ERRO: entrada invalida. Tente novamente: ");
            }
        }
        return valor;
    }
    
    private static int[] selectionSort(int[] array) {
        //Selection sort
        for(int fim=array.length-1; fim>=0; --fim) {
            int idMaior=0;
            int posAtual=0;
            
            // Procura o maior numero no array e grava a posicao
            while(posAtual<=fim) {
                if (array[posAtual] > array[idMaior]) {
                    idMaior = posAtual;
                }
                ++posAtual;
            }
            
            // Coloca os maiores nas posicoes finais, até a posicao 0
            int copia = array[fim];
            array[fim] = array[idMaior];
            array[idMaior] = copia;
        }
        return array;
    }
    
    private static int[] inserirInteiroVetor(int[] numeros, int valor) {
        //Encontra a posicao ideal para inserir o numero no array
        int p;
        for(p=0; p < numeros.length && numeros[p] < valor; p++);
        
        // Cria vetor temporario
        int[] copia = numeros.clone();
        numeros = new int[numeros.length+1];
        
        // Adiciona numeros anteriores à posicao encontrada
        for(int i=0; i < p; ++i) {
            numeros[i] = copia[i];
        }
        numeros[p] = valor; // Adiciona numero desejado
        
        // Adiciona numeros restantes do array
        for(int j=numeros.length-1; j > p;) {
            numeros[j] = copia[--j];
        }
        return numeros;
    }
}
