package com.mycompany.ex16_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
16. Verificação de Palíndromo: Desenvolva um programa que solicite ao usuário uma
palavra e utilize um laço FOR para verificar se ela é um palíndromo. Utilize IF para
comparar os caracteres da palavra e determinar o resultado.
* 
*  Ovo matam atta ooppoo anã
 */
public class EX16_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String palavra;
        boolean ePalindromo = true;
        int indiceLetraOposta; // Armazena o índice da letra que deve ser verificada do lado oposto
        int indiceParada; // ìndice em que o loop FOR deve terminar de avançar para letra seguinte na verificação, exclusive.
        char letraComeco, letraOposta; // Armazena as letras verificadas
        
        System.out.print("Digite uma palavra para verificar se é um palíndromo:\n>>> ");
        palavra = console.next().toLowerCase();
        
        // Definição dos índices de verificação
        indiceLetraOposta = palavra.length() - 1; // Primeira letra a ser verificada é a última
        indiceParada = palavra.length() / 2; // Divisão inteira, sem resto
        
        for (int i=0; i < indiceParada && ePalindromo; ++i) {
            letraComeco = palavra.charAt(i);
            letraComeco = switch(letraComeco) {
                case 'ã', 'â', 'á', 'à' -> 'a';
                case 'õ', 'ô', 'ó', 'ò' -> 'o';
                case 'ẽ', 'ê', 'é', 'è' -> 'e';
                case 'ĩ', 'î', 'í', 'ì' -> 'i';
                case 'ũ', 'û', 'ú', 'ù' -> 'u';
                default -> letraComeco;
            };
            
            letraOposta = palavra.charAt(indiceLetraOposta);
            letraOposta = switch(letraOposta) {
                case 'ã', 'â', 'á', 'à' -> 'a';
                case 'õ', 'ô', 'ó', 'ò' -> 'o';
                case 'ẽ', 'ê', 'é', 'è' -> 'e';
                case 'ĩ', 'î', 'í', 'ì' -> 'i';
                case 'ũ', 'û', 'ú', 'ù' -> 'u';
                default -> letraOposta;
            };
            
            if (letraComeco != letraOposta) {
                ePalindromo = false;
                System.out.print("NÃO É PALÍNDROMO!");
            } else
                --indiceLetraOposta;
        }
        
        if (ePalindromo)
            System.out.print("É PALÍNDROMO!");
    }
}
