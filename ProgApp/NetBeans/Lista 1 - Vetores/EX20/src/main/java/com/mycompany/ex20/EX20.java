package com.mycompany.ex20;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
20. Receber 1000 números e: a) Mostrar todos os números na ordem inversa em que
foram digitados. b) Mostrar todos os números ímpares digitados. c) Mostrar todos os números
entre 10 e 50 que foram digitados, incluindo o 10 e o 50.
 */
public class EX20 {

    public static void main(String[] args) {
        
        int[] numeros = new int[1000];
        String impares="", num_dez_cinquenta="";
        for(int n = 0; n < numeros.length; ++n) {
            System.out.print((n+1) + ". numero: ");
            while (true) {
                Scanner in = new Scanner(System.in);
                try {
                    //numeros[n] = in.nextInt();
                    System.out.println(numeros[n] = (int)Math.round(Math.random() * 1000));
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("ERRO: entrada invalida. Tente novamente: ");
                }
            }
            
            if (numeros[n] % 2 != 0)
                impares += String.valueOf(numeros[n]) + "\n";
            
            if (numeros[n] >= 10 && numeros[n] <= 50)
                num_dez_cinquenta += String.valueOf(numeros[n]) + "\n";
        }
        System.out.println("\n# ORDEM INVERSA --------------------------------");
        for (int i = numeros.length-1; i >= 0; --i) {
            System.out.println(numeros[i]);
        }
        
        System.out.printf("""
                \n# NUMEROS IMPARES --------------------------------
                %s   
                # NUMEROS 10-50 --------------------------------
                %s
                """, impares, num_dez_cinquenta);

    }
}
