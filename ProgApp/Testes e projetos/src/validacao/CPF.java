package validacao;

/** Esta classe tem como objetivo permitir o armazenamento
 * de CPFs e a conversão e validação de Strings 
 * para o formato aceitável de CPF.
 */

public class CPF {
	
	/** Armazena informação de CPF no formato puramente numérico, 
	 * sem nenhuma pontuação.
	 */
	private String numerico;
	
	public static final int DIG_VERIFICACAO = 2;
	public static final int DIG_ID = 9;
	public static final int TAM_CPF = DIG_ID+DIG_VERIFICACAO;
	
	/** Transforma str em um objeto CPF. O parametro deve ser válido,
	 * contendo apenas numeros e '.' e '-' possivelmente. Espaços são
	 * removidos do início e final da String de parâmetro.
	 */
	public CPF(String str) {
		String numerico = toNumerico(str); // Retira pontuacao, se houver
		if(!eValido(numerico)) {
			throw new IllegalArgumentException("CPF invalido");
		}
		this.numerico = numerico;
	}
	// Getters
	public String getNumerico() {return this.numerico;}
	
	// Converters
	public static String toNumerico(String str) {
		if(str == null) {
			return null;
		}
		
		StringBuilder newStr = new StringBuilder();
		
		for (int i=0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(Character.isDigit(c)) {
				newStr.append(c);
			}
		}
		
		return newStr.toString();
	}
	
	// Checkers
	public static boolean eValido(String str) { // Deve receber um cpf contendo somente os numeros
		if (str == null) {
			throw new NullPointerException("String de verificacao nao pode ser null");
		} else if (str.length() < TAM_CPF) {
			return false;
		}
		
		str = str.trim();
		if (str.length() < TAM_CPF || str.length() > TAM_CPF) {
			return false;
		}
		
		//String strNumerico = toNumerico(str); // Garante conversao para String contendo somente com numeros
		
		for (int d=1; d <= DIG_VERIFICACAO; d++) { // Valida os digitos verificadores
			short soma=0;
			for (int m=DIG_ID+d,i=0; m >=2; m--, i++) {// Avança nos números do CPF e soma cada um à multiplicacao por m
				int valor = Character.digit(str.charAt(i), 10); // Valor em inteiro do numero sendo verificado
				soma += valor * m;
			}
			int resto = soma % 11;
			int digVerificador = Character.digit(str.charAt(DIG_ID+d-1), 10);
			
			if(resto < 2 && digVerificador != 0) {
				return false;
			} else if (resto >= 2 && digVerificador != (TAM_CPF - resto)) {
				return false;
			}
		}
		return true;
	}
	
	// Equals
	public boolean equals(String str) {
		String numerico = toNumerico(str);
		return this.numerico.equals(numerico);
	}
	
	public boolean equals(CPF outroCPF) {
		if (outroCPF == null) {
			return false;
		}
		
		return this.equals(outroCPF.getNumerico());
	}
}

