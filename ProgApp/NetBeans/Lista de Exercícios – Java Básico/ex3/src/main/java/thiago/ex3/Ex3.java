package thiago.ex3;
import java.io.DataInputStream;
import java.io.IOException;

/**3. Escreva um programa que leia dois números inteiros e apresente na tela sua soma apenas se ambos tiverem
o mesmo sinal (positivo ou negativo). Use o mesmo formato do exercício anterior e, caso os números
fornecidos tenham sinais trocados o programa deve escrever na tela que os "Dados de Entrada são
Inválidos".
 *
 * @author thiago
 */
public class Ex3 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        int num1, num2;
        int soma;
        
        System.out.print("Insira o primeiro numero: ");
        num1 = Integer.parseInt(in.readLine());
        System.out.print("Insira o segundo numero: ");
        in = new DataInputStream(System.in);
        num2 = Integer.parseInt(in.readLine());
        if((num1 >= 0 && num2 >= 0) || (num1 < 0 && num2 < 0))
            System.out.println("Soma de " + num1 + " com " + num2 + " = " + (num1+num2));
        else
            System.out.println("Dados de Entrada são Inválidos");
    }
}
