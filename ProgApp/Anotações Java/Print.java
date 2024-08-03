import java.util.Scanner

public class Projeto {
	public static void main() {
		Scanner ler = new Scanner(System.in)
		/*							^^^^
									Direciona de onde a entrada virá
		*/
		int n = ler.nextInt(); //Ler até o primeiro inteiro
		float preco = ler.nexttFloat();
		double salario = ler.nextDouble();
		String palavra = ler.next(); // Ler string até espaço
		String nome_completo = ler.nextLine(); // Ler string até uma nova linha, esvaziando o buffer.
	}
}