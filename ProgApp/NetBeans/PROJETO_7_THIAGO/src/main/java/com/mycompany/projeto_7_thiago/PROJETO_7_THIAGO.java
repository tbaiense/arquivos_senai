package com.mycompany.projeto_7_thiago;
import java.util.Scanner;
/**
 * Programa que calcula o IMC do usuário.
 * O usuário insere o peso em kilos em números reais,
 * a altura em metros em números reais e o IMC é calculado
 * e exibido em números reais.
 */
public class PROJETO_7_THIAGO {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in); // Recebe entrada do teclado
        float peso; // Peso do usuário em kilogramas, recebe pelo teclado
        float altura; // altura do usuário em metros, recebe pelo teclado
        float imc; // IMC do usuário em kg/m², computado pelo programa
        String classificacao = ""; //Armazena a classificação
        
        System.out.print("Insira seu peso em kilogramas (ex. 76,3): ");
        peso = stdin.nextFloat();
        System.out.print("Insira sua altura em metros (ex. 1,85): ");
        altura = stdin.nextFloat();
        
        // Cálculo do IMC
        imc = peso / (altura * altura);
    
        if (imc >= 40.0)
            classificacao += "Obesidade Classe III";
        else if (imc >= 35.0)
            classificacao += "Obesidade Classe II";
        else if (imc >= 30.0)
            classificacao += "Obesidade Classe I";
        else if (imc >= 25.0)
            classificacao += "Excesso de peso";
        else if (imc >= 20.0)
            classificacao += "Peso normal";
        else if (imc >= 18.5)
            classificacao += "Abaixo do peso";
        
        System.out.printf("""
                          \nDados os dados abaixo:
                          - Peso: %1.2fkg
                          - Altura: %1.2fm
                          
                          O IMC calculado foi de: %2.1f.
                          Com esse IMC, você se encaixa na classificação:
                          """, peso, altura, imc);
        
        System.out.println(classificacao.toUpperCase());
    }
}
