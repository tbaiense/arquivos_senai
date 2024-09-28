package thiago.ex15;
import java.io.DataInputStream;
import java.io.IOException;
/** 15. Determine qual é a idade que o usuário faz no ano atual, para isso solicite o ano de nascimento do usuário
e o ano atual.
 * 
 * @author thiago
 */
public class Ex15 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Digite o ano atual:");
        int anoAtual = Integer.parseInt(in.readLine());
        System.out.println("Digite seu ano de nascimento:");
        int anoNasc = Integer.parseInt(in.readLine());
        System.out.printf("Voce faz %d anos em %d", anoAtual-anoNasc, anoAtual);
    }
}
