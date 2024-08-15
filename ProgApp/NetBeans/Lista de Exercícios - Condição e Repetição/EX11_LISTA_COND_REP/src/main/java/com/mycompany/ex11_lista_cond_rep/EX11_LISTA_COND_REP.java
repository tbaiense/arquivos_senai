package com.mycompany.ex11_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
11. Conversor de Temperatura: Crie um programa que converta uma temperatura de
Celsius para Fahrenheit e vice-versa. O programa deve solicitar ao usuário a temperatura e
a unidade de origem, e utilizar IF-ELSE para realizar a conversão correta.
 */
public class EX11_LISTA_COND_REP {

    public static void main(String[] args) {
        float tempOrigem;
        float tempFinal = 0;
        Scanner console = new Scanner(System.in);
        
        System.out.print("Digite a temperatura que deseja converter: ");
        tempOrigem = console.nextFloat();
        System.out.print("""
                           Agora, selecione a medida da temperatura inserida digitando um dos números abaixo:
                            0 Celsius
                            1 Fahrenheit
                           Escolha >>>""" + ' ');
        switch (console.nextShort()) {
            case 0 -> tempFinal = (tempOrigem * 5) / 9 + 32; // C -> F
            case 1 -> tempFinal = (tempOrigem - 32) / 9 * 5;
            default -> {
                System.out.println("ERRO: OPÇÃO INVÁLIDA!");
                System.exit(1);
            }
        }
        
        System.out.printf("TEMPERATURA CONVERTIDA: %1.1fº", tempFinal);
    }
}
