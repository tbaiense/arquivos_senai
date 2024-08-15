package com.mycompany.ex06_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
6. Cálculo de IMC: Desenvolva um programa que calcule o Índice de Massa Corporal (IMC)
de uma pessoa. O programa deve solicitar o peso e a altura do usuário, calcular o IMC e usar
IF-ELSE para classificar o resultado (baixo peso, peso normal, sobrepeso, obesidade).
 */
public class EX06_LISTA_COND_REP {

    public static void main(String[] args) {
        double peso, altura, imc;
        Scanner console = new Scanner(System.in);
        
        System.out.print("Digite seu peso em kg: ");
        peso = console.nextDouble();
        System.out.print("Digite sua altura em metros: ");
        altura = console.nextDouble();
        
        imc = peso / (altura * altura);
        System.out.printf("\nClassificação (IMC %2.1f): ", imc);
        // Classificação
        if (imc >= 40)
            System.out.println("Obesidade grau III");
        else if (imc >= 35)
            System.out.println("Obesidade grau II");
        else if (imc >= 30)
            System.out.println("Obesidade grau I");
        else if (imc >= 25)
            System.out.println("Sobrepeso");
        else if (imc >= 18.6)
            System.out.println("Peso normal");
        else
            System.out.println("Magreza");
    }
}
