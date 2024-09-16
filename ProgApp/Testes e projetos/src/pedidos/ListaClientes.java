package pedidos;


public class ListaClientes {
	private static Cliente[] clientes;
	private static int cadastrados=0; // Quantidade de clientes cadastrados
	
	// Getters
	public static int getCadastrados() {
		return cadastrados;
	}
	
	public static Cliente getCliente(final String telCliente) {
		Cliente.validateTel(telCliente); // Garante não ser nulo e estar dentro dos requisitos de telefone
		if (clientes != null) {
			for(Cliente c : clientes) {
				if (c != null && c.getTel().equals(telCliente)) {
					return c;
				}
			}	
		}		
		return null; // Caso não encontre
	}
	
	public static Cliente getCliente(final int idCliente) {
		if (idCliente < 0) {
			throw new IllegalArgumentException("Id do cliente procurado deve ser maior que zero");
		}
		
		if (clientes != null && idCliente <= cadastrados) { // Se existem pedidos cadastrados
			for(Cliente c : clientes) {
				if (c.getId() == idCliente) {
					return c;
				}
			}
		}
		
		return null; // Caso não encontre
	}
	// Setters
	static int push(final Cliente newCliente) { // Retorna id do cliente inserido
		if (newCliente == null) {
			throw new NullPointerException("Cliente a ser inserido nao pode ser nulo");
		}
		
		if (clientes == null) {
			clientes = new Cliente[2];
		} else if (clientes.length == cadastrados) {
			Cliente[] copia = clientes.clone();
			clientes = new Cliente[clientes.length+1];
			
			for (int i=0; i < copia.length; i++) {
				clientes[i] = copia[i];
			}
		}
		
		clientes[cadastrados++] = newCliente;
		
		return newCliente.getId();
	}
}
