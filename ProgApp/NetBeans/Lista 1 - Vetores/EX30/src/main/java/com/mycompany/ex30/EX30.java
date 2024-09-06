package com.mycompany.ex30;
import java.io.DataInputStream;
import java.io.IOException;

/**
30. Escreva um algoritmo que faça uma agenda de contatos com opções de: inserção e
listagem de todos os contatos. Para cada contato deve ser possível armazenar nome, telefone
e email.
 * @author thiago
 */

class Contato {
    String nome, email, telefone;
    
    Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    @Override
    public String toString() {return String.format("NOME: %-12s | TEL.: %-11s | EMAIL: %-18s", nome, telefone, email);}
}

class Agenda {
    Contato[] contatos;
    int qntContatos;
    
    Agenda() {
        this.contatos = new Contato[16];
        this.qntContatos = 0;
    }
    
    public Contato inserirContato(String nome, String telefone, String email) {
        try {
            //Verifica formato de telefone
            for (int c=0; c < telefone.length(); c++) {
                if( !Character.isDigit(telefone.charAt(c)) ) {
                    System.out.println("\nERRO: telefone invalido.");
                    return null;
                }
            }
            Contato novo = new Contato(nome, telefone, email);
            contatos[this.qntContatos] = novo;
            this.qntContatos = this.qntContatos + 1;
            return novo;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERRO: limite de contatos excedidos.");
            return null;
        }
    }
    
    public static String listarContatos(Agenda agenda) {
        String strContatos = "";
        if (agenda.qntContatos == 0) { // Se não houver contatos na agenda
            return null;
        }
        
        for(int c=0; c < agenda.qntContatos; ++c) {
            strContatos += agenda.contatos[c] + "\n"; // Invoca o método toString() de Contatos
        }
        
        return strContatos;
    }
}

public class EX30 {

    public static void main(String[] args) throws IOException {
        DataInputStream in;
        Agenda agenda = new Agenda();
        
        for (int c = 0; c < agenda.contatos.length;) {
            System.out.println("\n# CONTATO " + (c+1) + "---------------------------");
            System.out.print("NOME: ");
            in = new DataInputStream(System.in);
            String nome = in.readLine();

            System.out.print("TEL: ");
            in = new DataInputStream(System.in);
            String telefone = in.readLine();

            System.out.print("EMAIL: ");
            in = new DataInputStream(System.in);
            String email = in.readLine();
            
            if(agenda.inserirContato(nome, telefone, email) == null) {
                System.out.println("NÃO FOI POSSIVEL INSERIR ESTE CONTATO.");
            } else {
                ++c;
            }
            
            System.out.print("\nDESEJA INSERIR OUTRO CONTATO?\nSIM ou NAO >>> ");
            in = new DataInputStream(System.in);
            String entrada = in.readLine().trim();
            
            if (entrada.length() == 0 || entrada.length() > 0 && Character.toUpperCase(entrada.charAt(0)) != 'S') {
                break;
            }
        }
        
        String strContatos = Agenda.listarContatos(agenda);
        System.out.println("\n# CONTATOS REGISTRADOS ---------------------------\n"
                +  ((strContatos != null) ? strContatos : "Nenhum contato registrado"));
    }
}
