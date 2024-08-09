package com.mycompany.projeto_8_thiago;
import java.util.Scanner;

/** A classe implementa um programa que recebe
 * a quantidade de medalhas de um país e determina 
 * a sua classficiação de acordo com o critério 
 * estabelecido.
 */
public class PROJETO_8_THIAGO {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int ouro, prata, bronze; // Armazenam a quantidade de medalhas
        String mensagem = ""; // Armazena a classificaçao de desempenho
        
        System.out.print("Insira a quantidade de medalhas de OURO: ");
        ouro = stdin.nextInt();
        System.out.print("Insira a quantidade de medalhas de PRATA: ");
        prata = stdin.nextInt();
        System.out.print("Insira a quantidade de medalhas de BRINZE: ");
        bronze = stdin.nextInt();
        
        if ( ouro > 5 && ((ouro + prata + bronze) > 30) )
            mensagem = "DESEMPENHO EXTRAORDINÁRIO";
        else if (ouro > 10)
               mensagem = "ÓTIMO DESEMPENHO";
        else if (ouro >= 5)
            mensagem = "BOM DESEMPENHO";
        else if ( (ouro + prata + bronze) > 20 )
            mensagem = "DESEMPENHO REGULAR";
        else
            mensagem = "DESEMPENHO FRACO";
        
        System.out.print("O resultado obtido foi " + mensagem);
    }
}
