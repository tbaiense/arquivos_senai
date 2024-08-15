package com.mycompany.ex04_lista_cond_rep;
import java.util.Scanner;

/** ALUNO: Thiago Moura Baiense
4. Sistema de Login: Desenvolva um programa que simule um sistema de login simples. O
programa deve solicitar o nome de usuário e senha, e permitir até 3 tentativas. Utilize
WHILE para controlar o número de tentativas e IF-ELSE para verificar a autenticidade dos
dados.
 */
public class EX04_LISTA_COND_REP {

    public static void main(String[] args) {
        String usuario = "admin";
        String senha = "adminPa55";
        boolean valido = false;
        short tentativas = 3;
        Scanner console = new Scanner(System.in);
        
        while(tentativas-- > 0 && !valido) {
            System.out.print("""
                             LOGIN -------------
                             Usuário:""" + " ");
            if (usuario.equals(console.next()))
                valido = true;
            
            System.out.print("Senha: ");
            if ( senha.equals(console.next()) && valido )
                System.out.println("SUCESSO!\n");
            else {
                valido = false;
                System.out.println("ERRO: CREDENCIAIS INVÁLIDAS!");
            }
        }
    }
}