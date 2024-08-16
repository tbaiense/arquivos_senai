package com.mycompany.ex19_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
19. Cálculo de Potência: Crie um programa que solicite ao usuário a base e o expoente, e
utilize um laço FOR para calcular a potência (base^expoente). O programa deve exibir o
resultado ao final.
*/
public class EX19_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double base, resultado=1;
        int expoente, limite;
        
        System.out.print("Digite a base a ser calculada (ex 1 ou 2,5): ");
        base = console.nextDouble();
        
        
        System.out.print("Especifique o expoente: ");
        expoente = console.nextInt();
        
        if (expoente != 0) {
            resultado = base;
            limite = Math.abs(expoente);
            for (int i=2; i <= limite; ++i)
                resultado *= base;
            
            if (expoente < 0)
                resultado = 1.0 / resultado;   
        }

        System.out.printf("RESULTADO: %2.5f", resultado);
    }
}
