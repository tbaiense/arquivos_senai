package thiago.ex5;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

/**5. Escreva um programa que leia o nome de um lutador e seu peso. Em seguida informe a categoria         
 * a que pertence o lutador, conforme a tabela ao lado (note que a tabela foi criada para efeito deste      
 * exercício e não condiz com qualquer categoria de luta). A saída do programa deve exibir em um TEXT      
 * uma frase no seguinte padrão:                                                                         
 *                                                                                                          
 * Nome fornecido: Pepe Jordão                                                                            
 * Peso fornecido: 73.4                                                                                    
 * Saída exibida no TXT: O lutador Pepe Jordão pesa 73.4 kg e se enquadra na categoria Ligeiro
 * 
 * @author thiago
 */
public class Ex5 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        System.out.print("Nome do lutador: ");
        String nome = in.readLine();
        in = new DataInputStream(System.in);
        System.out.print("Peso do lutador: ");
        double peso = Double.parseDouble(in.readLine());
        String categoria;
        
        if (peso >= 100.0) {
            categoria="Pesado";
        } else if (peso >= 93) {
            categoria="Meio Pesado";
        } else if (peso >= 86) {
            categoria="Medio";
        } else if (peso >= 79) {
            categoria="Meio Medio";
        } else if (peso >= 72) {
            categoria="Ligeiro";
        } else if (peso >= 65) {
            categoria="Leve";
        } else {
            categoria="Pena";
        }
        
        final String nomeArquivo = String.format("%s.txt", nome);
        FileWriter fileWriter = new FileWriter(nomeArquivo); // Diretório do projeto
        PrintWriter printerWriter = new PrintWriter(fileWriter);
        String saida = String.format("O lutador %s pesa %3.1f kg e se enquadra na categoria %s", nome, peso, categoria);
        printerWriter.printf(saida);
        fileWriter.close();
        
        System.out.printf("""
                        \nNome fornecido: %s                                                                           
                        Peso fornecido: %3.1f                                                                                   
                        Saída exibida no TXT: %s
                          """, nome, peso, saida);
        
        
    }
}
