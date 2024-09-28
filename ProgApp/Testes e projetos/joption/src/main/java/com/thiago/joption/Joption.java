package com.thiago.joption;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;

public class Joption {
    
    static final int QTD_NOTAS = 5;
    static String[] caminhoArq = new String[QTD_NOTAS];
    
    public static void main(String[] args) throws IOException {
        
        
        final int QTD_NUMEROS = 5;
        int[] vetor = new int[QTD_NUMEROS];
        System.out.println("Insira os numeros para fazer tabuada:");
        for(int i=0; i < QTD_NUMEROS; i++) {
            System.out.print((i+1) + ". numero: ");
            while(true) {
                try {
                    vetor[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o " + (i+1) + ". numero:", "Insercao de numeros", JOptionPane.QUESTION_MESSAGE));
                    escreverTabuada(vetor[i], i);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Numero invalido. Tente novamente", "Entrada inválida", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        StringBuilder caminhos = new StringBuilder();
        for(String str : caminhoArq) {
            caminhos.append(str);
        }
        JOptionPane.showMessageDialog(null, caminhos.toString(), "CAMINHOS DAS TABUADAS", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void escreverTabuada(int numAtual, int index) throws IOException {
        final int TAB_MAX = 10;
        final String LOCAL_ARQUIVO = String.format("C:\\Users\\Public\\tabuada-%s.txt", numAtual);
        caminhoArq[index] = LOCAL_ARQUIVO + "\n";
        FileWriter arquivo = new FileWriter(LOCAL_ARQUIVO);
        PrintWriter writer = new PrintWriter(arquivo);
        StringBuilder str = new StringBuilder();
        str.append("TABUADA DE "+ numAtual + "----------\n");
        writer.printf(str.toString());
        String temp = "";
        for(int i=1; i <= TAB_MAX; i++) {
            temp = String.format("%2d x %2d = %3s\n", numAtual, i, numAtual*i);
            str.append(temp);
            writer.printf(temp);
        }
        JOptionPane.showMessageDialog(null, str.toString(), "Tabuada", JOptionPane.INFORMATION_MESSAGE);
        writer.close();
    }
}
