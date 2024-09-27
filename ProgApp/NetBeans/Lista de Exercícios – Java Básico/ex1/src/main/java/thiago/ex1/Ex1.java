package thiago.ex1;

import java.io.DataInputStream;
import java.io.IOException;

/**1.Escreva um programa que leia dois números inteiros e apresente na tela sua soma, no seguinte formato:
Soma de 5 com 7 = 12
 *
 * @author thiago
 */
public class Ex1 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        int num1, num2;
        int soma;
        
        System.out.print("Insira o primeiro numero: ");
        num1 = Integer.parseInt(in.readLine());
        System.out.print("Insira o segundo numero: ");
        in = new DataInputStream(System.in);
        num2 = Integer.parseInt(in.readLine());
        System.out.println("Soma de " + num1 + " com " + num2 + " = " + (num1+num2));
    }
}
