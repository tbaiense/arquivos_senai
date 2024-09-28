package thiago.ex10;
import java.io.DataInputStream;
import java.io.IOException;

/**10. Escreva um programa que leia um número N (entre 0 e 50) e em seguida leia N números reais em um vetor
A. O programa dever separar os valores lidos em A em outros dois vetores NEG e POS, o primeiro contendo
somente os valores negativos e o segundo contendo os valores positivos e zero. Apresentar na tela os
vetores NEG e POS e a quantidade de valores contidos em cada um.
* 
 * @author thiago
 */
public class Ex10 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        System.out.print("Insira o valor de N (entre 0 e 50): ");
        
        int N=0;
        double[] A, NEG, POS;
        try { // Validação de entrada
            N = Integer.parseInt(in.readLine());
            //in.close();
            if (N > 50 || N < 0) {
                throw new IllegalArgumentException("valor fora do intervalo permitido");
            }
        } catch (IllegalArgumentException e) {
            StringBuilder errMsg = new StringBuilder("ERRO: ");
            if(e instanceof NumberFormatException)
                errMsg.append("valor invalido para N");
            else {
                errMsg.append(e.getMessage());
            }
            errMsg.append("\nFinalizando a execução do programa");
            System.out.println(errMsg.toString());
            return;
        }
        if (N > 0) { 
            A = new double[N];
            int NEG_count=0, POS_count=0; // Acompanha a contagem de valores negativos e positivos, respectivamente
            for (int i = 0; i < N; i++) { // Recebimento de valores
                System.out.print((i+1) + ". num real: ");
                in = new DataInputStream(System.in);
                A[i] = Double.parseDouble(in.readLine());
                
                if (A[i] < 0)
                    NEG_count++;
                else
                    POS_count++;
            }
            
            NEG = new double[NEG_count];
            POS = new double[POS_count];
            StringBuilder strNEG = new StringBuilder(String.format("NEG[%d]: {", NEG_count));
            StringBuilder strPOS = new StringBuilder(String.format("POS[%d]: {", POS_count));
            for (int a = 0, n = 0, p = 0; a < A.length; a++) { // Separação de valores negativos e positivos
                if (A[a] < 0 &&  n < NEG_count) {
                    NEG[n++] = A[a];
                    strNEG.append(String.format("  %.2f",  A[a]));
                } else {
                    POS[p++] = A[a];
                    strPOS.append(String.format("  %.2f",  A[a]));
                }
            }
            strNEG.append("  }");
            strPOS.append("  }");
            System.out.printf("""
                              \nValores armazenados nos vetores ----------
                              %s
                              %s
                              """, strNEG, strPOS);
        } else {
            System.out.println("Não foi inserido nenhum numero");
        }
    }
}
