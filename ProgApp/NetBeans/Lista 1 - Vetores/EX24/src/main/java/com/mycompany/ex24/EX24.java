package com.mycompany.ex24;
import java.io.DataInputStream;
import java.io.IOException;
/**
24. Deseja-se calcular a conta de consumo de energia elétrica de vários consumidores.
Para isso, ler uma única vez o valor do Kw e para cada consumidor, ler o nome do consumidor
e a quantidade de Kw consumidos. Depois, listar o nome e o total a pagar (total a pagar =
preço x quantidade) de cada consumidor.
 */

class Consumidor {
    String nome;
    double consumo;

    Consumidor(String nome, double consumo) {
        this.nome = nome;
        this.consumo = consumo;
    }
    
    public String gerarConta(double preco) {
        return String.format("NOME: %-10s | A PAGAR: R$ %,3.2f\n", this.nome, consumo*preco);
    }
}
public class EX24 {

    public static void main(String[] args) throws IOException {
        float preco;
        Consumidor[] consumidores = new Consumidor[16];
        DataInputStream in;
        int qntCadastrados=0;
        
        System.out.print("Preço do Kw/h em R$: ");
        while(true) {
            in = new DataInputStream(System.in);
            try {
                preco = Float.parseFloat(in.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ERRO: formato de numero invalido. Tente novamente: ");
            }
        }
        
        cadastro:for(int c=0; c < consumidores.length; ++c) {
            System.out.printf("# CONSUMIDOR %d ---------\n", c+1);
            
            System.out.print("Nome: ");
            String nome;
            in = new DataInputStream(System.in);
            nome = in.readLine();
            
            double consumo;
            System.out.print("Consumo em Kw/h: ");
            while(true) {
                in = new DataInputStream(System.in);
                try {
                    consumo = Float.parseFloat(in.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: formato de numero invalido. Tente novamente: ");
                }
            }
            consumidores[c] = new Consumidor(nome, consumo);
            ++qntCadastrados;
            
            System.out.println("\nInserir outro consumidor?\n Sim ou nao >>>");
            in = new DataInputStream(System.in);
            String entrada="";

            entrada = in.readLine();
            if (entrada.length() != 0 && Character.toUpperCase(entrada.trim().charAt(0)) != 'S') {
                break cadastro;
            }
            
        }
        
        System.out.println("\n# CONTAS CONSUMIDORES ---------");
        for(int c=0; c < qntCadastrados; c++) {
            System.out.print(consumidores[c].gerarConta(preco));
        }
    }
}
