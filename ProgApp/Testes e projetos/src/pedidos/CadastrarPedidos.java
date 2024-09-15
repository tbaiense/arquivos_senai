package pedidos;

import java.io.DataInputStream;
import java.io.IOException;

public class CadastrarPedidos {
	private static Pedido lastPedidoFromCliente = null; 
	
	public static void main(String[] args) throws IOException {
		
		ListaClientes.push(new Cliente("anonimo", "xxxx-xxxx"));
		//System.out.print("LOG >>> ID DO CLIENTE CADASTRADO NO PEDIDO: " + telaReceberCliente());
		while (true) {
			System.out.println("[ NOVO PEDIDO ] ======================>");
			final int idCliente = telaReceberCliente();
			lastPedidoFromCliente = ListaPedidos.getLastPedidoFromCliente(idCliente);
			final String produto = telaReceberProduto();
			
			System.out.print("quantidade: ");
			DataInputStream in = new DataInputStream(System.in);
			final String quantidade = in.readLine();
			
			final String endereco = telaReceberEndereco();
			
			final String destinatario = telaReceberDestinatario();
			
			Pedido novoPedido;
			if (destinatario == null) {
				novoPedido = new Pedido(idCliente, produto, quantidade, endereco);
			} else {
				novoPedido = new Pedido(idCliente, produto, quantidade, endereco, destinatario);
			}
			lastPedidoFromCliente = null;
			ListaPedidos.push(novoPedido);
			System.out.println("\nLOG NOVO PEDIDO >>> " + novoPedido + "\n");
		}
	}
	// Retorna id do cliente para o pedido
	private static int telaReceberCliente() throws IOException{
		String nome, tel;
		
		System.out.print("telefone do cliente: ");
		tel = receberTelefone();
		/*Controle de registro de clientes
		 * Se cliente com o mesmo telefone existir
		 * 		referenciar o id do cliente
		 * Senao
		 * 		criar novo cliente e referenciar o id*/
		
		// Procurar cliente na lista
		Cliente clienteEncontrado = ListaClientes.getCliente(tel); // Retorna nulo se não encontrar
		if (clienteEncontrado != null) { // Cliente já existente na lista
			System.out.print("\nNOME ENCONTRADO: " + clienteEncontrado.getNome() 
					+ "\nManter nome?\n SIM ou NAO >>> ");
			
			if (!readYORN()) { // Se for alterar nome do cliente
				System.out.print("\n[novo] nome do cliente: ");
				nome = receberNome();
				clienteEncontrado.setNome(nome);
				//System.out.println("\nLOG >>> ALTERADO COM SUCESSO! (" + clienteEncontrado + ")");
			}
			return clienteEncontrado.getId();
			
		} else { // Não existe na lista
			System.out.print("nome do cliente: ");
			nome = receberNome();
			Cliente novoCliente = new Cliente(nome, tel);
			ListaClientes.push(novoCliente);
			return novoCliente.getId();
		}
	}
	
	private static String telaReceberProduto() throws IOException {
		String produto = null;

		if (lastPedidoFromCliente != null) { // Se houver pedido cadastrado para o cliente
			String lastProduto = lastPedidoFromCliente.getProduto();
			System.out.print("\nUltimo produto do cliente: " + lastProduto 
			+ "\nUsar mesmo produto?\nSIM ou NAO >>> ");
			if (readYORN()) {
				produto = lastProduto;
				System.out.println();
			}
		}
		
		if (produto == null) {
			// Novo pedido para novo cliente
			System.out.print("produto: ");
			DataInputStream in = new DataInputStream(System.in);
			produto = in.readLine();
		}

		return produto;
	}
	
	private static String telaReceberEndereco() throws IOException {
		String endereco = null;

		if (lastPedidoFromCliente != null) { // Se houver pedido cadastrado para o cliente
			String lastEndereco = lastPedidoFromCliente.getEndereco();
			System.out.print("\nUltimo endereco do cliente: " + lastEndereco
			+ "\nUsar mesmo endereco?\nSIM ou NAO >>> ");
			if (readYORN()) {
				endereco = lastEndereco;
				System.out.println();
			}
		}
		
		if (endereco == null) {
			// Novo endereco
			System.out.print("endereco: ");
			DataInputStream in = new DataInputStream(System.in);
			endereco = in.readLine();
		}

		return endereco;
	}
	
	private static String telaReceberDestinatario() throws IOException {
		String destinatario = null;
		
		if (lastPedidoFromCliente != null) { // Se houver pedido cadastrado para o cliente
			String lastDestinatario = lastPedidoFromCliente.getDestinatario();
			if (lastDestinatario != null) {
				System.out.print("\nUltimo destinatario do cliente: " + lastDestinatario
						+ "\nUsar o mesmo destinatario?\nSIM ou NAO >>> ");
				if (readYORN()) {
					destinatario = lastDestinatario;
					System.out.println();
				}
			}
		}
		
		if (destinatario == null) {
			// Novo destinario
			System.out.print("destinatario: ");
			DataInputStream in = new DataInputStream(System.in);
			destinatario = in.readLine();
			
			if (destinatario.length() < 2)
				destinatario = null;
		}

		return destinatario;
	}
	
	private static String receberTelefone() throws IOException {
		do {// Receber tel do cliente
			try {
				DataInputStream in = new DataInputStream(System.in);
				String tel = in.readLine();
				Cliente.validateTel(tel); // Checa se telefone maior que 8 caracteres
				return tel;
			} catch (IllegalArgumentException e) {
				System.out.print("ERRO: " + e.getMessage() + "\nTente novamente: ");
			}
		} while (true);
	}
	
	private static String receberNome() throws IOException {
		do {// Receber novo nome do cliente
			try {
				DataInputStream in = new DataInputStream(System.in);
				String nome = in.readLine();
				Cliente.validateNome(nome); // Checa se telefone maior que 8 caracteres
				return nome;
			} catch (IllegalArgumentException e) {
				System.out.print("ERRO: " + e.getMessage() + "\nTente novamente: ");
			}
		} while (true);
	}
	
	private static boolean readYORN() throws IOException {
		while (true) {
			DataInputStream in = new DataInputStream(System.in);
			String entrada = in.readLine();
			if (entrada != null && entrada.length() > 0) {
				char c = Character.toUpperCase(entrada.trim().charAt(0));
				if (c == 'S') {
					return true;
				} else if (c == 'N') {
					return false;
				}
			} else {
				System.out.print("Escolha inválida. Digite SIM ou NAO >>> ");
			}
		}
 	}
}
