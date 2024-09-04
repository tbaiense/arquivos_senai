package com.mycompany.ex22;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
22. Receber a descrição e o valor de um número qualquer de produtos de uma loja. Ler até
que o usuário não queira mais continuar a inserir dados. a) Exibir descrição e valor dos
produtos que custam abaixo da média de todos os produtos. b) Obter um caractere e exibir as
descrições de todos os produtos cujos nomes iniciam com esse caractere.
 */

class Produto {
    String descricao;
    double preco;
    
    Produto(String descricao, double preco) {this.descricao = descricao; this.preco = preco;}
    
    @Override
    public String toString() {return String.format("DESCRICAO: %-10s | PRECO: R$ %,.2f", descricao, preco);};
}

public class EX22 {

    public static void main(String[] args) {
        Produto[] produtos = new Produto[200];
        double mediaPreco, somaPreco=0;
        String nomesChar="", prodPrecoAbaixoMed="";
        int qntProdutos=0;
        
        for(int n=0; n < produtos.length; ++n) {
            System.out.println("# PRODUTO " + (n+1) + " ------------------");
            
            System.out.print("DESCRICAO: ");
            String descricao;
            while (true) {
                Scanner in = new Scanner(System.in);
                descricao = in.nextLine();
                if (descricao.length() >= 3)
                    break;
                else
                    System.out.print("ERRO: digite pelo menos 3 letras. Tente novamente: ");
            }
            
            System.out.print("PRECO (ex. 10,50): ");
            float preco;
            while(true) {
                Scanner in = new Scanner(System.in);
                try {
                    preco = in.nextFloat();
                    if (preco > 0)
                        break;
                    else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.print("ERRO: salario inválido. Digite um numero real maior que zero: ");
                }
            }
            System.out.println("");
            somaPreco += preco;
            
            produtos[n] = new Produto(descricao, preco);
            ++qntProdutos;
            
            if (n < produtos.length-2) {
                System.out.print("INSERIR OUTRO PRODUTO?\nSim ou não >> ");
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
        
        mediaPreco = somaPreco / qntProdutos;
        for (int f=0; f < qntProdutos; ++f) {
            if (produtos[f].preco < mediaPreco) {
                prodPrecoAbaixoMed += produtos[f] + "\n";
            }
        }
        
        char charNome;
        System.out.println("\nDigite um caracter para filtar a descricao: ");
        while (true) {
            Scanner in = new Scanner(System.in);
            String entrada;
            entrada = in.nextLine();
            if (entrada.length() > 0) {
                charNome = Character.toUpperCase(entrada.charAt(0));
                break;
            } else {
                System.out.print("ERRO: entrada vazia. Tente novamente: ");
            }
        }
        
        for(int i=0; i < qntProdutos; ++i) {
            if (Character.toUpperCase(produtos[i].descricao.charAt(0)) == charNome)
                nomesChar += produtos[i].descricao;
        }
        
        System.out.printf("""
            \n# PRODUTOS COM PRECO ABAIXO DA MÉDIA (%,0.2f) -------------------
            %s
            # PRODUTOS COM NOME QUE COMECA COM '%c' -------------------
            %s
            """, mediaPreco, prodPrecoAbaixoMed, charNome, nomesChar);
    }
}
