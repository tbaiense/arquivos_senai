package thiago.ex7;

import java.io.DataInputStream;
import java.io.IOException;

/**7. Elaborar um programa que efetue a leitura de valores positivos inteiros até que zero ou um valor negativo
seja informado. Ao final devem ser apresentados: o maior e menor valores informados pelo usuário, a
quantidade de valores, a soma e a média de todos.
 * 
 * @author thiago
 */
public class Ex7 {

    public static void main(String[] args) throws IOException {
        DataInputStream in;
        int[] vetor = new int[10];
        
        int inserido=0, soma=0;
        int maior=0, menor=0; // Armazena os indices dos numeros do vetor
        double media;
        while (true) {
            System.out.print("Digite um número (0 ou negativo para sair): ");
            in = new DataInputStream(System.in);
            int digitado = Integer.parseInt(in.readLine());
            if (digitado < 1) {
                break;
            }
            
            soma += vetor[inserido] = digitado;
            
            if (digitado > vetor[maior]) {
                maior = inserido;
            } else if (digitado < vetor[menor]) {
                menor = inserido;
            }
            inserido++;
            
            if(inserido == vetor.length) { // nao tem espaco no vetor
                int[] novoVetor = new int[vetor.length+10];
                for (int i = 0; i < vetor.length; i++) {
                    novoVetor[i] = vetor[i];
                }
                vetor=novoVetor;
            }
        }
        
        if (inserido > 0) {
            media = (double)soma / inserido;
            System.out.printf("""
                              \nMaior numero: %d
                              Menor numero: %d
                              Quantidade de valores: %d
                              Soma dos valores: %d
                              Média dos valores: %1.2f
                               """, vetor[maior], vetor[menor], inserido, soma, media);
        } else {
            System.out.println("Não foi inserido nenhum numero");
        }
        
    }
}
