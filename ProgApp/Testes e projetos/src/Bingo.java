import java.util.Scanner;
import static java.lang.System.out;

/**
 * This class generates a bingo game using pseudo-random numbers
 * and prints the numbers generated in a matrix format on the console.
 * @author t.baiense
 */
public class Bingo {
	/**
	 * Defines the number of rows to be shown for the game
	 */
	private static final short LINHAS = 5;
	private static final short COLUNAS = 5;
	private static final short MAX = 99;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int[] cartela = gerarCartela();
		System.out.println(imprimirCartela(cartela));
		out.println(extrairNum(console.nextLine()));
		/*
		 * receber numero
		 * se está na cartela
		 * 		cartela[indice numero] = 0
		 * 		exibir cartela
		 * se nao
		 * 		exibir erro
		 * repetir
		 *
		 * */



	}
	/**
	 * Generates an array of pseudo-random numbers to be used in the game.
	 * @return a new array consisting of the generated numbers.
	 */
	private static int[] gerarCartela() {
		int[] numerosCartela = new int[LINHAS * COLUNAS];
		if (MAX < numerosCartela.length) {
			System.out.print("ERRO: Número de números aleatórios inferior ao tamanho da cartela. Aumente a faixa de valores a serem gerados.");
			System.exit(1);
		}

		// Geração dos números
		numerosCartela[0] = (short)(Math.random()*MAX + 1);
		for (int i = 1; i < numerosCartela.length;) {
			short aleatorio = (short)(Math.random()*MAX + 1);
			boolean repetido = false;
			for (int verificado = i-1; verificado >= 0; --verificado) {
				if (numerosCartela[verificado] == aleatorio) {
					repetido = true;
					break;
				}
			}
			if (!repetido) {
				numerosCartela[i] = aleatorio;
				++i;
			}
		}

		return numerosCartela;
	}

	private static String imprimirCartela(int[] cartela) {
		String cartelaStr = "";
		for (int n = 0; n < cartela.length; n++) {
			if (n % COLUNAS == 0 && n != 0) // Garante a formatação das linhas e colunas
				cartelaStr += "\n";
			cartelaStr += String.format("%3d ", cartela[n]);
		}
		return cartelaStr;
	}

	private static String extrairNum(String entrada) {
		Scanner in = new Scanner(entrada);

		String idadeStr = null; // String de retorno. Se não for encontrado inteiro na entrada, permanece nulo.
		while (idadeStr == null) {
			if (in.hasNext())
				if (in.hasNextInt()) {
					idadeStr = in.next();
					break;
				}
				else
					in.next();
			else
				break;
		}

		return idadeStr;
	}

}
