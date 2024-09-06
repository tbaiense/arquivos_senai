package com.thiago.ex27;
import java.io.DataInputStream;
import java.io.IOException;

/**
 *7. Escreva um algoritmo que leia e armazene 1000 valores em um array de inteiros e, 
depois de obter todos eles, copie-os para um outro array. 
 * @author t.baiense
 */
public class EX27 {

    public static void main(String[] args) {
        int[] vetUm,vetDois;
        vetUm = new int[1000];
        
        for (int i=0; i < vetUm.length; i++) {
            System.out.println(vetUm[i] = (int)Math.round(Math.random() * 100));
        }
        
        vetDois = vetUm.clone();
    }
}
