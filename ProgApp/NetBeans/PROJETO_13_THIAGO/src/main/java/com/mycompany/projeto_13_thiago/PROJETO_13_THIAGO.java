/* ALUNO: THIAGO MOURA BAIENSE
 * Escreva um programa que realiza diferentes operações matemáticas em elementos de um vetor de números inteiros.
O programa deve solicitar ao usuário que insira os elementos do vetor, o tipo de operação desejada (adição, 
subtração, multiplicação, divisão) e os índices dos elementos a serem operados. O programa deve utilizar blocos 
try-catch para capturar erros como divisão por zero, índices inválidos e entradas inválidas.

Instruções:

1.O programa deve permitir ao usuário definir o tamanho do vetor e preencher os valores.

2.O programa deve solicitar ao usuário que escolha uma operação matemática (adição, subtração, multiplicação, divisão).

3.O programa deve exibir os resultados presentes no vetor antes de realizar as operações, incluindo os respectivos índices.

4.O programa deve pedir dois índices do vetor para realizar a operação nos elementos correspondentes.

5.Use try-catch para:

    Capturar tentativas de divisão por zero.
    Capturar exceções de índices fora dos limites do vetor.
    Capturar entradas inválidas (como strings quando se espera um número).

6.Exiba o resultado da operação ou uma mensagem de erro apropriada.

7.O programa deve armazenar os resultados em um segundo vetor chamado “resultados”.
 */

package com.mycompany.projeto_13_thiago;
import java.util.Scanner;

public class PROJETO_13_THIAGO {

    public static void main(String[] args) {
        int[] vetor; // Armazena os números entrados pelo usuário
        double[] resultados = new double[10]; // Armazena o resultado das operações, sendo 10 o tamanho máximo do histórico
        int tamVetor; // Tamanho de `vetor`, definido pelo usuário
        
        // Cria vetor
        System.out.print("Especifique o tamanho do vetor: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            short entrada;
            try {
                entrada = Short.parseShort(scanner.nextLine());
                
                if (entrada < 0)
                    throw new Exception("tamanho não pode ser negativo");
                if (entrada > 1024)
                    throw new Exception("tamanho muito grande (máx. 1024)");
                
                tamVetor= entrada;
                break;
            } catch (NumberFormatException e1) {
                System.out.print("ERRO: entrada inválida.\nTente novamente: ");
            } catch (Exception e2) {
                System.out.print("ERRO: " + e2.getMessage() + ".\nTente novamente: ");
            }
        }
        
        vetor = new int[tamVetor];
        
        // Preenche vetor
        System.out.println("\n# Insira numeros inteiros no vetor a seguir -------");
        for(int n=0; n < vetor.length; ++n) {
            System.out.print((n+1) + ". num: ");
            while (true) { // Valida a entrada para inteiros
                int entrada;
                try {
                    entrada = Integer.parseInt(scanner.nextLine());
                    vetor[n] = entrada;
                    break;
                } catch (NumberFormatException e1) {
                    System.out.print("| ERRO: entrada inválida.\n -- Tente novamente: ");
                }                         
            }
        }
        
        // Realiza contas
        for (int r=0; r < resultados.length; ++r) {
            // Receber operador
            System.out.print("\nEscolha um operador (+, -, * ou /): ");
            String op;
            while(true) { // Validar operador
                try {
                    op = scanner.nextLine().trim();   
                    if (!op.equals("+") && !op.equals("-")  && !op.equals("*") && !op.equals("/"))
                        throw new Exception("operador inválido");
                    
                    break;
                } catch (Exception e) {
                    System.out.print("ERRO: " + e.getMessage() + ".\nTente novamente: ");
                }
            }
            
            // Exibir o vetor
            System.out.print("\n# VETOR --------------\n| ");
            String strVetor = "";
            for (int i = 0; i < vetor.length; ++i) {
                strVetor += String.format("%d (%d), ", vetor[i], i);
            }
            
            System.out.print(strVetor + "\n-- Selecione dois indices para realizar a operação ");
            switch (op) {
                case "+" -> System.out.print("ADICAO (+)");
                case "-" -> System.out.print("SUBTRACAO (-)");
                case "*" -> System.out.print("MULTIPLICACAO (*)");
                case "/" -> System.out.print("DIVISAO (/)");
                default -> System.out.print("\nERRO! Operação inválida");
            }
            System.out.println("");
            
            // Receber indices
            int[] valores = new int[2];
            for (int j = 0; j < valores.length; ++j) {
                System.out.print((j+1) + ". indice: ");
                while (true) {
                    short indice;
                    try {
                        indice = Short.parseShort(scanner.nextLine());

                        if (indice < 0)
                            throw new Exception("indice não pode ser negativo");

                        if (j == 1 && vetor[indice] == 0 && op.equals("/")) // Divisão por zero
                            throw new ArithmeticException();
                        valores[j] = vetor[indice];
                        break;
                    } catch (ArithmeticException e1) {
                        System.out.print("ERRO: divisao por zero.\nEscolha outro indice final: ");
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e2) {
                        System.out.print("ERRO: indice inválido.\nTente novamente: ");
                    } catch (Exception e3) {
                        System.out.print("ERRO: " + e3.getMessage() + ".\nTente novamente: ");
                    }
                }
            }
            
            resultados[r] = switch (op) {
                case "+" -> valores[0] + valores[1];
                case "-" -> valores[0] - valores[1];
                case "*" -> valores[0] * valores[1];
                case "/" -> (double)valores[0] / valores[1]; // Garantido que não há divisão por zero
                default -> 0;
            };
            
            System.out.printf("""
                              \n# RESULTADO --------------
                              %d %s %d =""", valores[0], op, valores[1]);
            
            if ((resultados[r] - (int)resultados[r]) > 0) // Se for número com vírgula
                    System.out.printf(" %.2f\n", resultados[r]);
                else
                    System.out.printf(" %.0f\n", resultados[r]);
            System.out.print("\nRealizar outro calculo?\n Sim ou não >>> ");
            String escolhaContinuar = scanner.nextLine().trim();
            if (escolhaContinuar.length() > 0 && Character.toUpperCase(escolhaContinuar.charAt(0)) != 'S')
                break;
        }
        
        System.out.println("\n# HISTÓRICO DE RESULTADOS ---------------- ");
        for(double num : resultados)
            if (num > 0)
                if ((num - (int)num) > 0) // Se for número com vírgula
                       System.out.printf("%.2f\n", num);
                else
                    System.out.printf("%.0f\n", num);
    }
}
