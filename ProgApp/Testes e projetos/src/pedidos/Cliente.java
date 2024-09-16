package pedidos;


public class Cliente {
	private static int cadastrados;
	
	private String nomeCliente;
	private final String telCliente;
	private final int id;
	
	public Cliente(final String nomeCliente, final String telCliente) {
		validateNome(nomeCliente);
		validateTel(telCliente);
		
		this.nomeCliente = nomeCliente;
		this.telCliente = telCliente;
		this.id = cadastrados++;
	}
	
	
	// Getters
	public int getId() {return this.id;}
	public String getNome() {return this.nomeCliente;}
	public String getTel() {return this.telCliente;}
	
	//Setters
	public void setNome(final String newNome) {
		Cliente.validateNome(newNome);
		this.nomeCliente = newNome;
	}
	
	// Validadores
	static void validateNome(String nomeCliente) {
		if (nomeCliente == null || nomeCliente.length() < 3 ) {
			throw new IllegalArgumentException("Nome do cliente deve ter 3 ou mais caracteres");
		}
	}
	
	static void validateTel(String telCliente) {
		if (telCliente == null || telCliente.length() < 8) {
			throw new IllegalArgumentException("Telefone deve ter 8 ou mais caracteres");
		}
	}
	
	@Override
	public String toString() {
		return String.format("ID: %3d  CLIENTE: %-12s  TEL: %-12s", this.id, this.nomeCliente, this.telCliente);
	}
}
