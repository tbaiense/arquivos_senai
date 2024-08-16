package com.mycompany.ex18_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
18. Sistema de Pedágio: Desenvolva um programa que simule a cobrança de pedágio em
uma estrada. O usuário deve inserir o tipo de veículo (carro, moto, caminhão) e o programa
deve utilizar IF-ELSE para calcular o valor do pedágio com base em uma tabela de preços
predefinida.
*/
public class EX18_LISTA_COND_REP {
    enum TipoVeiculo { INDEFINIDO, CARRO, MOTO, CAMINHAO }
    
    public static void main(String[] args) {
        TipoVeiculo veiculo = TipoVeiculo.INDEFINIDO;
        Scanner console = new Scanner(System.in);
        float precoPedagio = 0f;
        
        do {
            System.out.print("""
                         PEDÁGIO ---------------
                         0 Carro
                         1 Moto
                         2 Caminhão
                         
                         Especifique o típo do veículo usando um dos números acima:
                         Escolha >>>""" + ' ');
        
            switch(console.nextShort()) {
                case 0 -> { veiculo = TipoVeiculo.CARRO; } 
                case 1 -> { veiculo = TipoVeiculo.MOTO; }
                case 2 -> { veiculo = TipoVeiculo.CAMINHAO; }
                default -> {
                    System.out.print("\n\nERRO: OPÇÃO INVÁLIDA! TENTE NOVAMENTE...\n\n");
                }
            }
        } while (veiculo == TipoVeiculo.INDEFINIDO);
        
        if (veiculo == TipoVeiculo.CARRO)
            precoPedagio = 4.70f;
        else if (veiculo == TipoVeiculo.MOTO)
            precoPedagio = 2.40f;
        else if (veiculo == TipoVeiculo.CAMINHAO)
            precoPedagio = 18.90f;
        else
            System.exit(1);
        
        System.out.printf("VALOR DO PEDÁGIO: R$ %2.2f", precoPedagio);
    }
}
