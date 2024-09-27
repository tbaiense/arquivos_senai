package thiago.ex6;
import java.io.DataInputStream;
import java.io.IOException;

/**6.Escreva um programa que permaneça em laço dentro do qual será efetuada a leitura de um número inteiro
X. O laço termina quando for digitado o valor 0 (zero) para X. Para cada valor X lido, o programa deve
informar na tela se o mesmo é positivo ou negativo.
 * 
 * @author thiago
 */
public class Ex6 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        
        int digitado=1;
        while (true) {
            System.out.print("Digite um número (0 para sair): ");
            digitado = Integer.parseInt(in.readLine());
            if(digitado == 0) {
                break;
            }
            
            if(digitado > 0) {
                System.out.println("Positivo");
            } else {
                System.out.println("Negativo");
            }
        }

    }
}
