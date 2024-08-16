package com.mycompany.ex17_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
17. Contagem de Vogais: Crie um programa que solicite ao usuário uma frase e utilize um
laço FOR para contar o número de vogais presentes. Utilize IF para verificar cada caractere e
determinar se é uma vogal.
*/
public class EX17_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String frase;
        int qntVogais = 0, tamFrase;
        char c = '\0';
        
        System.out.print("Digite uma frase:\n>>> ");
        frase = console.nextLine().trim().toLowerCase();
        
        tamFrase = frase.length();
        for (int i=0; i < tamFrase; i++) {
            c = frase.charAt(i);
            c = switch(c) {
                case 'ã', 'â', 'á', 'à' -> 'a';
                case 'õ', 'ô', 'ó', 'ò' -> 'o';
                case 'ẽ', 'ê', 'é', 'è' -> 'e';
                case 'ĩ', 'î', 'í', 'ì' -> 'i';
                case 'ũ', 'û', 'ú', 'ù' -> 'u';
                default -> c;
            };
            
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                ++qntVogais;
        }
        
        System.out.println("Nº VOGAIS: "+ qntVogais);
    }
}
