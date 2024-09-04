package com.mycompany.ex18;
import java.util.Scanner;
import java.util.InputMismatchException;
/** 
 *18. Faça um algoritmo para ler 50 números e armazenar em um vetor VET, verificar e
escrever se existem números repetidos no vetor VET e em que posições se encontram.
 */
public class EX18 {

    public static void main(String[] args) {
        int[] VET = new int[50];
        boolean[] eNumRep = new boolean[50]; // Armazena números repetidos que foram já verificados
        int entrada;
        
        
        insercao: for(int n=0; n < VET.length; ++n) {
            System.out.print("Numero para o indice " + n + ": ");
            
            while (true) {
                Scanner in = new Scanner(System.in);
                try {
                    entrada = in.nextInt();
                    //entrada = (int)Math.round(Math.random() * 20);
                    //System.out.println(entrada);
                    VET[n] = entrada;
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("ERRO: entrada invalida. Digite um numero inteiro: ");
                } catch (ArrayIndexOutOfBoundsException e2) {
                    System.out.print("ERRO: indice fora do intervalo do vetor. Finalizando insercao...");
                    break insercao;
                }
            }
        }
        System.out.println("# POSICOES COM NUMEROS REPETIDOS -----------------");
        for (int nAtual = 0; nAtual < VET.length-1; ++nAtual) { // Itera na array
            if (eNumRep[nAtual]) { // Pula se o número atual já tiver sido verificado e encontrado repetidos
                continue;
            } else {
                System.out.printf("Número %2d: ", VET[nAtual]);
                for (int nProx = nAtual+1; nProx < VET.length ; ++nProx) {
                    if (eNumRep[nProx]) { // Pula se o número próximo já tiver sido verificado e encontrado repetidos
                        continue;
                    } else {
                        if (VET[nAtual] == VET[nProx]) { // Só registra se ainda não foi observado como repetido
                            eNumRep[nProx] = true;
                            if (!eNumRep[nAtual]) {
                                eNumRep[nAtual] = true;
                                System.out.print(nAtual + "  ");
                            }
                            System.out.print(nProx + "  ");
                        }
                    }
                }
                if (!eNumRep[nAtual]) {
                    System.out.println(" SEM REPETICAO");
                } else {
                    System.out.println("");
                }
            }
        }
    }
}
