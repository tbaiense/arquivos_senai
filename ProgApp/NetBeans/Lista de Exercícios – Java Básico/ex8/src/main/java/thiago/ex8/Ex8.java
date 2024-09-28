package thiago.ex8;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

/**8.Escreva um programa que leia dois números inteiros denominados Min e Max. Em seguida, inicie um laço
dentro do qual será efetuada a leitura de um número inteiro X. O laço termina quando for digitado o valor
0 (zero) para X. Dentro do laço o programa deve contar e totalizar todos os valores de X que estejam no
intervalo fechado [Min, Max]. Se algum valor fora do intervalo for digitado para X, o programa deve dar a
mensagem "Valor fora do intervalo [Min, Max] ignorado na totalização". Após sair do laço, deve apresentar
o total e a quantidade correta de valores fornecidos. Cuidado com a possibilidade do usuário digitar o valor
Min maior que o valor Max. Se isso acontecer o programa deve avisar a situação e invertê-los.
 * 
 * @author thiago
 */
public class Ex8 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        
        int inserido=0, soma=0;
        int Max, Min;

        System.out.print("Numero Max: ");
        Max = Integer.parseInt(in.readLine());
        System.out.print("Numero Min:");
        in = new DataInputStream(System.in);
        Min = Integer.parseInt(in.readLine());
        
        if (Max < Min) {
            int copia = Max;
            Max = Min;
            Min = copia;
            System.out.println("Atencao: Max e menor que Min. Os números foram invertidos.");
        }
        
        while (true) {
            System.out.print("Digite um número (0 para sair): ");
            in = new DataInputStream(System.in);
            int digitado = Integer.parseInt(in.readLine());
            if (digitado == 0) {
                break;
            }
            if(digitado <= Max && digitado >= Min) {
                soma += digitado;
                inserido++;
            } else {
                System.out.printf("Valor fora do intervalo [%d, %d] ignorado na totalização\n", Min, Max);
            }
        }
        if (inserido > 0) {
            System.out.printf("""
                           \nTotal: %d
                           Quantidade inserida: %d
                           """, soma, inserido);
        } else {
            System.out.println("Não foi inserido nenhum numero");
        }
        
    }
}
