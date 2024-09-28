package thiago.ex16;

import java.io.DataInputStream;
import java.io.IOException;

/** 16. Uma empresa precisa realizar uma estatística do salário de seus funcionários. Para isto precisa de um
programa que leia uma lista contendo os salários dos funcionários da empresa, e imprima quantos
funcionários ganham salário acima da média. Sabe-se que a empresa possui 50 funcionários.
• Considerando que não há um número fixo de 50 funcionários, o programa pergunta no início quantos
funcionários possui a empresa e reliza o restante do processo.
 *
 * @author thiago
 */
public class Ex16 {

    public static void main(String[] args) throws IOException {
        System.out.println("Insira a quantidade funcionarios para a empresa: ");
        DataInputStream in = new DataInputStream(System.in);
        final int QTD = Integer.parseInt(in.readLine());
        
        Empresa.listaFuncionarios = new Funcionario[QTD];
        for (int f = 0; f < QTD; f++) {
            double salarioFunc = (Math.random() * (5501.0-1412.0)) + 1412.0;
            Empresa.listaFuncionarios[f] = new Funcionario(salarioFunc);
        }
        
        double mediaSal = Empresa.getMediaSal();
        int qtdAcimaMediaSal = 0;
        for(Funcionario f : Empresa.listaFuncionarios) {
            if (f.salario > mediaSal) {
                ++qtdAcimaMediaSal;
            }
        }
        
        System.out.printf("Media salarial: R$ %3.2f\nNa empresa, ha %d funcionarios com salario acima da media", mediaSal, qtdAcimaMediaSal);
    }
}

class Empresa {
    static Funcionario[] listaFuncionarios;
    
    static double getMediaSal() {
        int qtdFunc = Empresa.getQtdFunc();
        if (qtdFunc == 0) {
            return 0;
        }
        double somaSal=0;
        for (Funcionario f : listaFuncionarios) {
            if(f != null) {
                somaSal += f.salario;
            }
        }
        return somaSal / qtdFunc; // Garantido qtdFunc > 0
    }
    
    static int getQtdFunc() {
        if (listaFuncionarios != null)
            return listaFuncionarios.length;
        
        return 0;
    }
}

class Funcionario {
    double salario;
    
    Funcionario (double salario) {
        this.salario = salario;
    }
}