package com.thiago.projeto_14_thiago;

import java.io.DataInputStream;
import java.io.IOException;

public class PROJETO_14_THIAGO {

    public static void main(String[] args) throws IOException {
        final int TAM = 2;
        int[][] matriz = new int[TAM][TAM];
        int somaLinhas[] = new int[TAM];
        int somaColunas[] = new int[TAM];
        int somaDiag[] = new int[2];
        int [] vetorOrdenado = new int[TAM*TAM];
        int[][] matrizNova = new int[TAM][TAM];
        int i=0;
        for(int l=0; l < TAM; ++l) {
            for(int c=0; c < TAM; ++c) {
                System.out.print((l+1)+" - "+(c+1)+". num: ");
                while (true) {
                    try {
                        DataInputStream in = new DataInputStream(System.in);
                        //matriz[l][c] = Integer.parseInt(in.readLine());
                        System.out.println(matriz[l][c] = (int)Math.round(Math.random() * 100));
                        break;
                    } catch (NumberFormatException e ) {
                        System.out.println("ERRO: numero invalido. Tente novamente: ");
                    }
                }
                vetorOrdenado[i++] = matriz[l][c];
            } 
        }
        System.out.println("");
        // Ordenacao
        for (int f=0; f < vetorOrdenado.length-1; ++f) {
            for(int d=f+1; d < vetorOrdenado.length; d++) {
                if (vetorOrdenado[f] > vetorOrdenado[d]) {
                    int copia = vetorOrdenado[f];
                    vetorOrdenado[f] = vetorOrdenado[d];
                    vetorOrdenado[d] = copia;
                }
            }
        }
        
        System.out.println("# VETOR ORDENADO --------------------");
        for (int l : vetorOrdenado)
            System.out.print(l + "  ");
        
        // Devolve ordenados
        i=0;
        for(int l=0; l < TAM; ++l) {
            for(int c=0; c < TAM; ++c) {
                matriz[l][c] = vetorOrdenado[i++];
                somaLinhas[l] += matriz[l][c];
                somaColunas[c] += matriz[l][c];
            }
        }
        
        boolean[] eNumRep = new boolean[TAM*TAM];
        System.out.println("\n# POSICOES COM NUMEROS REPETIDOS -----------------");
        for (int nAtual = 0; nAtual < vetorOrdenado.length; ++nAtual) { // Itera na array
            if (eNumRep[nAtual]) { // Pula se o número atual já tiver sido verificado e encontrado repetidos
                continue;
            } else {
                System.out.printf("Numero %2d: ", vetorOrdenado[nAtual]);
                for (int nProx = nAtual+1; nProx < vetorOrdenado.length ; ++nProx) {
                    if (eNumRep[nProx]) { // Pula se o número próximo já tiver sido verificado e encontrado repetidos
                        continue;
                    } else {
                        if (vetorOrdenado[nAtual] == vetorOrdenado[nProx]) { // Só registra se ainda não foi observado como repetido
                            eNumRep[nProx] = true;
                            if (!eNumRep[nAtual]) {
                                eNumRep[nAtual] = true;
                                System.out.print(nAtual + "  ");
                            }
                            System.out.print(nProx + "  ");
                        }
                    }
                }
                if (!eNumRep[nAtual]) {
                    System.out.println(" SEM REPETICAO");
                } else {
                    System.out.println("");
                }
            }
        }
    }
}
