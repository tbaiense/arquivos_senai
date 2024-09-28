package thiago.ex9;
import java.io.DataInputStream;
import java.io.IOException;

/**9.Refaça o exercício 8 armazenando cada um dos valores válidos (dentro do intervalo [Min, Max]) em um
vetor de números inteiros. Apresente na tela todos os valores contidos no vetor, bem como o total e a
quantidade correta de valores fornecidos. Responda a seguinte questão: Qual problema pode ocorrer neste
exercício, referente ao preenchimento do vetor à medida que os valores de X são digitados?
 * RESPOSTA: 
 *      Se não for aplicado uma solução, não será possível inserir valores indefinitivamente, por conta
 *      dos vetores serem instanciados com valor fixo de tamanho.
 * @author thiago
 */
public class Ex9 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        int[] vetor = new int[10];
        
        int inserido=0, soma=0;
         int Max, Min;

        System.out.print("Numero Max: ");
        Max = Integer.parseInt(in.readLine());
        System.out.print("Numero Min: ");
        in = new DataInputStream(System.in);
        Min = Integer.parseInt(in.readLine());
        
        if (Max < Min) {
            int copia = Max;
            Max = Min;
            Min = copia;
            System.out.println("Atencao: Max e menor que Min. Os números foram invertidos.");
        }
        
        while (true) {
            System.out.print("Digite um número (0 para sair): ");
            in = new DataInputStream(System.in);
            int digitado = Integer.parseInt(in.readLine());
            if (digitado == 0) {
                break;
            }
            if(digitado <= Max && digitado >= Min) {
                soma += vetor[inserido++] = digitado;
                if(inserido == vetor.length) { // aumenta espaços no vetor
                    int[] novoVetor = new int[vetor.length+10];
                    for (int i = 0; i < vetor.length; i++) {
                        novoVetor[i] = vetor[i];
                    }
                    vetor=novoVetor;
                }
            } else {
                System.out.printf("Valor fora do intervalo [%d, %d] ignorado na totalização\n", Min, Max);
            }

        }
        
        StringBuilder strVetor = new StringBuilder();
        strVetor.append("Vetor: {");
        if (inserido > 0) {
            for(int n : vetor) {
                if(n == 0)
                    break;
                strVetor.append("  " + n);
            }
            strVetor.append("  }\n");
            System.out.printf("""
                           \nResultados -------------------------
                            %s
                            Total: %d
                            Quantidade inserida: %d
                            """, strVetor.toString(), soma, inserido);
        } else {
            System.out.println("Não foi inserido nenhum numero");
        }
    }
}
