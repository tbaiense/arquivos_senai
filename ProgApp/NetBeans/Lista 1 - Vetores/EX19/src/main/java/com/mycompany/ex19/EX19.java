package com.mycompany.ex19;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *19. Ler informações sobre um grupo de 250 pessoas e calcular alguns dados estatísticos.
Para cada pessoa do grupo obter o nome da pessoa, a altura, o peso e o sexo (“F” para
feminino e “M” para o masculino). Calcular e escrever: a) A listagem contendo nome, altura,
peso e sexo de todas as pessoas. As informações de uma pessoa deverão ocupar uma única
linha. b) A quantidade total de homens e mulheres e o percentual de cada. c) A média de peso
das pessoas (somatório dos pesos de todas as pessoas pela quantidade de pessoas) d) O nome
da pessoa mais alta.
 */

class Pessoa {
    float altura, peso;
    String nome;
    char sexo;
    
    Pessoa(String nome, char sexo, float altura, float peso) {this.nome = nome; this.sexo = sexo; this.altura = altura; this.peso = peso;}
    
    @Override
    public String toString() {return String.format("NOME: %-10s | SEXO: %c | ALTURA: %1.2f | PESO: %3.1f KG" , nome, sexo, altura, peso);}
}

public class EX19 {

    public static void main(String[] args) {
        int qntHomem=0, qntMulher=0;
        double mediaPeso, somaPeso=0;
        int idMaiorAltura=0; // Posicao da pessoa com maior altura no vetor
        Pessoa[] pessoas = new Pessoa[250];
        
        for(int n=0; n < pessoas.length; ++n) {
            System.out.println("# PESSOA " + (n+1) + " ------------------");
            
            System.out.print("NOME: ");
            String nome;
            while (true) {
                Scanner in = new Scanner(System.in);
                nome = in.nextLine();
                if (nome.length() >= 3)
                    break;
                else
                    System.out.print("ERRO: digite pelo menos 3 letras. Tente novamente: ");
            }
            
            System.out.print("SEXO (F ou M): ");
            char sexo = '-';
            while (true) {
                Scanner in = new Scanner(System.in);
                String entrada;
                entrada = in.nextLine();
                if (entrada.length() > 0) {
                    sexo = Character.toUpperCase(entrada.charAt(0));
                    if (sexo == 'F' || sexo == 'M')
                        break;
                    else {
                        sexo = '-';
                    }
                } else {
                        System.out.print("ERRO: entrada vazia. Tente novamente: ");
                }
            }
            
            switch (sexo) {
                case 'F' -> qntMulher++;
                case 'M' -> qntHomem++;
            }
            
            System.out.print("ALTURA (ex. 1,70): ");
            float altura;
            while(true) {
                Scanner in = new Scanner(System.in);
                try {
                    altura = in.nextFloat();
                    if (altura > 0)
                        break;
                    else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.print("ERRO: altura inválida. Digite um número real maior que zero (1,5): ");
                }
            }
            
            if (n != 0 && altura > pessoas[idMaiorAltura].altura) {
                idMaiorAltura = n; // Usado para recuperar o nome no vetor `pessoas`
            }
            
            System.out.print("PESO (ex. 75,3): ");
            float peso;
            while(true) {
                Scanner in = new Scanner(System.in);
                try {
                    peso = in.nextFloat();
                    if (altura > 0)
                        break;
                    else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.print("ERRO: altura inválida. Digite um número real maior que zero (1,5): ");
                }
            }
            somaPeso += peso;
            
            pessoas[n] = new Pessoa(nome, sexo, altura, peso);
            System.out.println("");
        }
        
        mediaPeso = somaPeso / pessoas.length;
        
        System.out.println("# CADASTRADOS ---------------------");
        for(Pessoa p : pessoas) {
            System.out.println(p);
        }
        System.out.println("\n# ESTATÍSTICAS ---------------------");
        System.out.printf("Peso médio: %.1f KG\n", mediaPeso);
        System.out.printf("Maior altura: %s (%.2f m)\n", pessoas[idMaiorAltura].nome, pessoas[idMaiorAltura].altura);
        System.out.printf("Pessoas cadastradas: %d (%2.1f%% HOM., %2.1f%% MUL.)\n", qntHomem + qntMulher, ((float)qntHomem/(qntHomem + qntMulher)) * 100f, (1f - (float)qntHomem/ (qntHomem + qntMulher)) * 100f);
    }
}
