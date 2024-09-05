package com.thiago.teste;

import java.io.DataInputStream;
import java.io.IOException;

public class Teste {
        
    public static void main(String[] args) throws IOException {
        String s="";
        float notas[], media=0, soma=0;
        notas = new float[4];
        DataInputStream dado;
        
        for(int i=0; i < notas.length; ++i) {
            System.out.println("Entre com a nota " + (i+1) +":");
            dado = new DataInputStream(System.in);

            s = dado.readLine();
            media += notas[i] = Float.parseFloat(s);
        }
        System.out.println(media /= notas.length);
    }
}
