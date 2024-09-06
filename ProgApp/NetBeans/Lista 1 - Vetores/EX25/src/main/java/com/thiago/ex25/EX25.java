package com.thiago.ex25;
import java.io.DataInputStream;
import java.io.IOException;
/**
25. Receber um número de mês e retornar o nome do mês por extenso. O algoritmo 
deverá obter o nome do mês em um vetor que contém como valores os nomes dos meses e 
cujo índice é o número do mês. Exemplo: se receber o número 2 como entrada, exibir 
'Fevereiro'
 * @author t.baiense
 */
public class EX25 {

    public static void main(String[] args) throws IOException {
        String[] meses = {
            "JANEIRO",
            "FEVEREIRO",
            "MARCO",
            "ABRIL",
            "MAIO",
            "JUNHO",
            "JULHO",
            "AGOSTO",
            "SETEMBRO",
            "OUTUBRO",
            "NOVEMBRO",
            "DEZEMBRO"
        };
        
        System.out.print("Digite o numero de um mes: ");
        int mes;
        while(true) {
            DataInputStream in = new DataInputStream(System.in);
            try {
                mes = Integer.parseInt(in.readLine());
                if (mes > 12 || mes < 1) {
                    System.out.println("ERRO: mes invalido. Digite um mes entre 1-12: ");
                } else
                    break;
            } catch (NumberFormatException e) {
                System.out.print("ERRO: numero invalido. Tente novamente: ");
            }
        }
        
        System.out.println("O MES ESCOLHIDO FOI: " + meses[mes-1]);
    }
}
