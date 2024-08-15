package com.mycompany.ex08_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
8. Sistema de Senha: Desenvolva um programa que solicite ao usuário uma senha e utilize
IF-ELSE para verificar se ela atende aos critérios de segurança (mínimo de 8 caracteres). O
programa deve permitir ao usuário tentar novamente até que uma senha válida seja
inserida.
 */
public class EX08_LISTA_COND_REP {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int tamMin = 8;
        String senha = "";
        boolean senhaValida = false;
        
        System.out.print("Digite uma senha com no mínimo " + tamMin + " caracteres:\n>>> ");
        while(!senhaValida){
            senha = console.nextLine();
            if (senha.length() < tamMin)
                System.out.print("Senha menor do que o tamanho mínimo especificado. Tente novamente:\n>>> ");
            else {
                senhaValida = true;
                System.out.println("Senha válida!");
            }
        }
    }
}
