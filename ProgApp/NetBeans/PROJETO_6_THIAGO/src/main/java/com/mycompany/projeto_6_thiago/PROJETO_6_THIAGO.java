/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_6_thiago;
import java.util.Scanner;
/**
 *
 * @author t.baiense
 */
public class PROJETO_6_THIAGO {

    public static void main(String[] args) {
        int QNT_NOTAS = 3; 
        float soma, media;
        soma = 0.0f;
        Scanner input = new Scanner(System.in);
        
        for(int n=1; n < QNT_NOTAS+1; n++) {
            System.out.printf("%da nota: ", n);
            soma += input.nextFloat();
            System.out.println("");
        }
        media = soma / QNT_NOTAS;
        System.out.printf("A média calculada foi de %.2f pontos", media);
    }
}
