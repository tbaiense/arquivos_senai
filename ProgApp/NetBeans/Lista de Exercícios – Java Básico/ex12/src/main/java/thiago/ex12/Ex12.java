package thiago.ex12;
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
public class Ex12 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        System.out.print("Insira o valor de N (entre 0 e 50): ");
        
        int N=0;
        int[] A;
        try { // Validação de entrada do tamanho
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
        A = new int[N];
        
        if (N > 0) { // Preenchimento com números aleatorios entre 0 e 100, inclusive
            StringBuilder strA = new StringBuilder(String.format("A[%d]: {", N));
            Random randGen = new Random();
            for (int a = 0; a < A.length; a++) { // Separação de valores negativos e positivos
                    A[a] = randGen.nextInt(101);
                    strA.append(String.format("%4d  ",  A[a]));
                    if(a > 0 && a < (A.length-1) && a % 10 == 9 )
                        strA.append("\n\t");
            }
            strA.append("\t}");
            System.out.printf("""
                              \nValores armazenados no vetor ----------
                              %s
                              """, strA);
            
            System.out.print("Insira o valor a excluir: ");
            in = new DataInputStream(System.in);
            int X;
            
            while(true) {
                try { // Validação de entrada do tamanho
                    final int digitado = Integer.parseInt(in.readLine());
                    X = digitado;
                    break;
                } catch (IllegalArgumentException e) {
                    in = new DataInputStream(System.in);
                    System.out.print("ERRO: " + e.getMessage() + ". Tente novamente: ");
                }
            }
            
            
            int mantidos=0; // Quantas ocorrências de X foram encontradas
            
            
            for (int i = 0; i < A.length; i++) {
                if(A[i] != X) {
                    mantidos++;
                }
            }
            if(mantidos > 0){
                StringBuilder numMantido = new StringBuilder(); // String com os numeros de A, sem X
                int[] newA = new int[mantidos]; // Novo vetor sem ocorrencias de N
                for (int m = 0, a = 0; m < newA.length; a++) {
                    if(A[a] != X) {
                        newA[m] = A[a];
                        numMantido.append(String.format("%4d  ", A[a]));
                        if(m > 0 && m < (newA.length-1) && m % 10 == 9 )
                            numMantido.append("\n");
                        
                        m++;
                    }
                }
                System.out.printf("""
                                  NUMEROS EM A, SEM %d --------
                                  %s
                                  """, X, numMantido.toString());
            } else {
                System.out.println("Não foi encontrada nenhuma ocorrencia de " + X);
            }
        } else {
            System.out.println("Não foi inserido nenhum numero");
        }
    }
}
