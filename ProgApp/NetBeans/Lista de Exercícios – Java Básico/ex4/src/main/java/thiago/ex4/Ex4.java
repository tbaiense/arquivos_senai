package thiago.ex4;
import java.io.DataInputStream;
import java.io.IOException;

/**4.Escreva um programa que leia três números reais e informe se eles constituem os lados de um triângulo.
Em caso afirmativo, informe se o triângulo é equilátero, isósceles ou escaleno. Para que três números
formem um triângulo deve ocorrer que a soma dos dois lados menores deve ser maior que o lado maior.
Para resolver essa questão verifique como funcionam os operadores lógicos and e or.
 *
 * @author thiago
 */
public class Ex4 {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        double [] l = new double[3]; 
        short maiorL=0;
        
        for (short i = 0; i < 3; i++) {
            System.out.print("Insira o " + (i+1) + ". lado do triangulo: ");
            l[i] = Double.parseDouble(in.readLine());
            if(l[i] > l[maiorL])
                maiorL = i;
        }
        
        short m1, m2;
        switch(maiorL) {
            case 0 -> {
                m1=1;
                m2=2;
            }
            case 1 -> {
                m1=0;
                m2=2;
            }
            default -> {
                m1=0;
                m2=1;
            }
        }
        
        if(l[m1] + l[m2] > l[maiorL]) {
            if (l[0] == l[1] && l[0] == l[2]) {
                System.out.println("Lados constituem um triangulo equilatero");
            } else if(l[0] == l[1] || l[0] == l[2]) {
                System.out.println("Lados constituem um triangulo isosceles");
            } else {
                System.out.println("Lados constituem um triangulo escaleno");
            }
            return;
        }
        
        System.out.println("Lados nao constituem um triangulo");
    }
}
