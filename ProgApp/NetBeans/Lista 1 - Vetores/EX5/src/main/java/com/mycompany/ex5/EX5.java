package com.mycompany.ex5;
import java.util.Scanner;
/** ALUNO: Thiago Moura Baiense
 * 5. Escreva um algoritmo que receba dez números do usuário e armazene em um vetor a
 * metade de cada número. Após isso, o algoritmo deve imprimir todos os valores armazenados.
 */
public class EX5 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int qntNum = 10;
        float metades[] = new float[qntNum];
        
        for(int i = 0; i < metades.length; i++) {
            System.out.printf("%d. número >> ", i+1);
            do {
                try {
                    metades[i] = stdin.nextFloat() / 2.0f;
                    break;
                } catch (Exception e) {
                    stdin.nextLine();
                    System.out.print("\nNúmero inválido!\nTente novamente inserindo um número inteiro: ");
                }
            } while (true);
        }
        
        String nums = "\n\nMETADES ---------------\n";
        for(float m : metades)
            nums += ((m - (int)m) > 0) ? // Se o número é real ou não
                String.format("%.2f\n", m) : String.format("%.0f\n", m); // 
        
        System.out.print(nums);
    }
}
