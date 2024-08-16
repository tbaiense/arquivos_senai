package com.mycompany.ex20_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
20. Cálculo de Desconto: Desenvolva um programa que solicite ao usuário o valor de uma
compra e o percentual de desconto. Utilize IF-ELSE para aplicar o desconto correto e exibir
o valor final ao usuário.
*/
public class EX20_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        float desconto;
        double valorCompra, valorFinal;
        
        System.out.print("Digite o valor total da compra: R$ ");
        valorCompra = console.nextDouble();
        System.out.print("Digite o percentual de desconto (ex. 100 ou 75,2)\n>>> ");
        desconto = console.nextFloat();
        
        valorFinal = (desconto < 100.0) ? valorCompra - valorCompra * (desconto / 100) : 0 ; // O ternário ainda é um IF-ELSE no fim das contas, né? (ಥ﹏ಥ) 

        System.out.printf("VALOR FINAL: R$ %3.2f", valorFinal);
    }
}
