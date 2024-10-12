import java.util.Arrays;

/** A classe java.util.Arrays fornece vários métodos para
 *  manipulação de array. Este arquivo utiliza alguns deles.
 */
public class Usando_Arrays {
	static int[] numeros = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 20}; // Instancia novo objeto do tipo int[];
	
	static public class Pessoa implements Comparable {
		public static int nextId;
		public int id;
		public String nome;
		
		public Pessoa(String nome) {
			this.id = nextId++;
			this.nome = nome;
		}
		
		public int compareTo(Object o) {
			if (o == null) {
				throw new NullPointerException();
			}
			
			Pessoa newO = (Pessoa)o;
			
			if (this.id == newO.id) {
				return 0;
			} else {
				return this.id - newO.id;
			}
		}
		public String toString() {
			return String.format("ID: %d | NOME: %s\n", this.id, this.nome);
		}
	}
	public static void main(String[] args) {
		
		/** Arrays.binarySearch(); BUSCANDO VALORES EM ARRAY
		 * OBS.: Array deve estar em ordem crescente.
		 *	Duas formas: (1) Array.binarySearch(T[] array, key)
		 *				 (2) Array.binarySearch(T[] array, fromIndex, toIndex, key)
		 *													   |	      \---- Exclusivo
		 *													   +==== Inclusivo
		 */
			int pos6 = Arrays.binarySearch(numeros, 6); // = 5
			int pos15 = Arrays.binarySearch(numeros, 15); // = -12;
			int pos3 = Arrays.binarySearch(numeros, 4, 6, 2); // = -5
		
		/** Arrays.sort(); ORDENA ARRAY EM ORDEM CRESCENTE
		* Duas formas: (1) Array.sort(T[] array) >> ordena parâmetro, nao retorna
		*			   (2) Array.sort(T[] array, fromIndex, toIndex)
        *										     |	      \---- Exclusivo
        *										     +==== Inclusivo
		*/	
			int[] random = new int[(int)(Math.random() * 1000)];
			for(int i=0; i<random.length; i++) {
				random[i] = (int)(Math.random() * 100000);
			}
			int [] sorted = random.clone(); // Retorna uma nova array contendo os mesmos números
			Arrays.sort(sorted); // Sorted está ordenado
			int[] partiallySorted = random.clone();
			Arrays.sort(partiallySorted, 0, 10);
			
			// Ordenando array de objetos usando interface Comparable
				Pessoa[] pessoas = new Pessoa[10];
				for (int i=0; i < pessoas.length;) {
					int randPos = (int)(Math.random() * pessoas.length);
					if (pessoas[randPos] == null) {
						pessoas[randPos] = new Pessoa("pessoa " + String.valueOf(randPos));
						i++;
					}
				}
			
				Arrays.sort(pessoas);
				System.out.print(Arrays.toString(pessoas));
			
		/** Arrays.copyOf(); Copia os elementos de um array
		* Duas formas: (1) Arrays.copyOf(T[] array, int N) >> retorna nova array
		*			   (2) Arrays.copyOfRange(T[] array, int fromIndex, int toIndex)
		*/	
			int[] copiaNumeros = Arrays.copyOf(numeros, 5);
			int[] meioNumeros = Arrays.copyOfRange(numeros, 9, numeros.length);
				
			
		/** Arrays.fill(); Preenche uma array com o valor fornecido;
		 * 
		 */
			int[] tudoUm = new int[10];
			Arrays.fill(tudoUm, 1);
			int[] meioDois = new int[10];
			Arrays.fill(meioDois, 4, meioDois.length, 2);
		
	}
	
}
