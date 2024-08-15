package com.mycompany.ex03_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
3. Calculadora Simples: Crie uma calculadora que permita ao usuário escolher entre as
operações básicas (adição, subtração, multiplicação e divisão). Utilize IF-ELSE para
determinar a operação escolhida e execute-a com base nos números inseridos pelo usuário.
 */
public class EX03_LISTA_COND_REP {

    public static void main(String[] args) {
        short opSelecionada = 0; // 0 soma, 1 subtração, 2 multiplicação, 3 divisão
        double num1, num2, resultado;
        Scanner console = new Scanner(System.in);
        
        //Recebe os dois números
        System.out.print("""
                         CALCULADORA -----------
                         Digite dois números a seguir e selecione a operação desejada para o resultado.
                         1) >>>\t""");
        num1 = console.nextDouble();
        System.out.print("2) >>>\t");
        num2 = console.nextDouble();
        
        System.out.print("""
                           Agora, selecione a operação desejada inserindo o número correspondente:
                            0 Soma
                            1 Subtração
                            2 Multiplicação
                            3 Divisão
                           
                           Escolha >>>\t""");
        opSelecionada = console.nextShort();
        
        resultado = switch(opSelecionada) {
            case 0 -> num1 + num2;
            case 1 -> num1 - num2;
            case 2 -> num1 * num2;
            case 3 -> num1 / num2;
            default -> {
                System.out.print("Operação indefinida. Nenhuma operação foi realizada.");
                yield 0;
            }
        };
        System.out.print("RESULTADO: " + resultado);
    }
}
