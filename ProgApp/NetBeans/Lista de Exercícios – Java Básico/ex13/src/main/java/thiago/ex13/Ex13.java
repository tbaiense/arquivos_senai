package thiago.ex13;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Random;

/**12. Escreva um programa que leia um número N (entre 0 e 50) e em seguida defina um vetor V preenchendo-o
com N números inteiros aleatórios (pesquise como fazer isso em Java). Exiba-o na tela. Inicie um laço no
qual será feita a leitura de um número X. Pesquise se X está ou não no vetor V e caso esteja elimine todas
as ocorrências do mesmo e reexiba o vetor na tela.
* 
 * @author thiago
 */
public class Ex13 {

    public static void main(String[] args) throws IOException {
        final int START = 150;
        final int STOP = 301;
        
        StringBuilder strNum = new StringBuilder();
        final int FINAL = STOP - START;
        for (int n = START, i=0; n < STOP; n++, i++) {
            strNum.append(String.format("%4d  ", n));
            if(i > 0 && i < FINAL && i % 10 == 9)
                strNum.append("\n");
        }
        System.out.printf("""
                          NUMEROS DE %d A %d --------
                          %s
                          """, START, STOP, strNum.toString());
    }
}
