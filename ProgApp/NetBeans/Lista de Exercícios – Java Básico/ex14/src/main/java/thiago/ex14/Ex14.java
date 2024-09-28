package thiago.ex14;

import java.io.DataInputStream;
import java.io.IOException;

/** 14. Escreva um programa que leia o nome e salário atual de um funcionário. O programa deve calcular seu
novo salário (segundo a tabela abaixo) e mostrar o nome, o salário atual e o salário reajustado do
funcionário: 
 *
 * @author thiago
 */
public class Ex14 {

    public static void main(String[] args) throws IOException {
        double somaAtual=0, somaReaj=0;
        DataInputStream in;
        
        while(true) {
            System.out.print("Insira o nome do funcionario: ");
            in = new DataInputStream(System.in);
            String nome = in.readLine().trim().toUpperCase();
            if (nome.equals("FIM")) {
                break;
            }
                
            System.out.printf("Insira o salário de %s: ", nome);
            in = new DataInputStream(System.in);
            double salario = Double.parseDouble(in.readLine());
            
            Funcionario func = new Funcionario(nome, salario);
            
            somaAtual += func.salario;
            double salarioReajustado = func.reajustado();
            somaReaj += salarioReajustado;
            
            System.out.printf("""
                               \nNOVO CADASTRO: --------------------
                               %s
                               SALARIO REAJUSTADO: R$ %4.2f\n
                               """, func.toString(), salarioReajustado);
        }
        
        System.out.printf("""
                          \nSOMA DOS SALARIOS -------------------
                          ATUAIS: R$ %4.2f
                          REAJUSTADOS: R$ %4.2f (DIFERENCA DE R$ R$ %4.2f)
                          
                          """, somaAtual, somaReaj, somaReaj-somaAtual);
    }
    
}

class Funcionario {
    String nome;
    double salario;
    
    Funcionario (final String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    /** Aplica reajuste no salario atual com base no salario atual, e retorna o novo salario.
     * @return novo salário, com o reajuste aplicado.
    */
    double reajustado() {
        float taxa;
        if (this.salario > 600.0) {
            taxa = 1.10f;
        } else if (this.salario > 300) {
            taxa = 1.15f;
        } else if (this.salario > 150) {
            taxa = 1.20f;
        } else {
            taxa = 1.25f;
        }
        return (this.salario * taxa);
    }
    @Override
    public String toString() {
        return String.format("NOME: %-6s| SALARIO: R$ %4.2f", nome, salario);
    }
}

