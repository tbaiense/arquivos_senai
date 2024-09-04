package com.mycompany.ex21;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
21. Receber o nome e o salário de um número qualquer de funcionários de uma empresa.
Ler até que o usuário não queira mais continuar a inserir dados. a) Exibir nome e salário dos
funcionários que recebem acima da média salarial dos próprios funcionários da empresa. b)
Exibir os nomes de todos os funcionários cujos nomes iniciam com a letra A.
 */

class Funcionario {
    String nome;
    double salario;
    
    Funcionario(String nome, double salario) {this.nome = nome; this.salario = salario;}
    
    @Override
    public String toString() {return String.format("NOME: %-10s | SALARIO: R$ %,.2f", nome, salario);};
}
public class EX21 {

    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[200];
        double mediaSal, somaSal=0;
        String nomesA="", funcSalAcimaMed="";
        int qntFunc=0;
        
        for(int n=0; n < funcionarios.length; ++n) {
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
            
            if(Character.toUpperCase(nome.charAt(0)) == 'A')
                nomesA += nome + "\n";
            
            System.out.print("SALARIO (ex. 1200,20): ");
            float salario;
            while(true) {
                Scanner in = new Scanner(System.in);
                try {
                    salario = in.nextFloat();
                    if (salario > 0)
                        break;
                    else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.print("ERRO: salario inválido. Digite um numero real maior que zero: ");
                }
            }
            System.out.println("");
            somaSal += salario;
            
            funcionarios[n] = new Funcionario(nome, salario);
            ++qntFunc;
            
            if (n < funcionarios.length-2) {
                System.out.print("INSERIR OUTRO FUNCIONARIO?\nSim ou não >> ");
                Scanner in = new Scanner(System.in);
                try {
                    if(Character.toUpperCase(in.nextLine().trim().charAt(0)) != 'S')
                        break;
                } catch (StringIndexOutOfBoundsException e) {
                    break;
                }
            }
            System.out.println("");
        }
        
        mediaSal = somaSal / qntFunc;
        for (int f=0; f < qntFunc; ++f) {
            if (funcionarios[f].salario > mediaSal) {
                funcSalAcimaMed += funcionarios[f] + "\n";
            }
        }
            
        System.out.printf("""
            \n# FUNCIONARIOS COM SALARIO ACIMA DA MÉDIA (%.2f)-------------------
            %s
            # FUNCIONARIOS COM NOME QUE COMECA COM 'A' -------------------
            %s
            """, mediaSal, funcSalAcimaMed, nomesA);
    }
}
