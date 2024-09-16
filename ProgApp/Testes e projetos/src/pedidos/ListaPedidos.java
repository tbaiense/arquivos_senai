package pedidos;


public class ListaPedidos {
	private static Pedido[] pedidos;
	private static int cadastrados; // Quantidade de pedidos cadastrados
	
	// Getters
	public static int getCadastrados() {
		return cadastrados;
	}
	
	public static Pedido getPedido(int idPedido) {
		if (idPedido < 0) {
			throw new IllegalArgumentException("Id do pedido procurado deve ser maior que zero");
		}
		
		if (pedidos != null && idPedido <= cadastrados) { // Se existem pedidos cadastrados
			for(Pedido p : pedidos) {
				if (p != null && p.getId() == idPedido) {
					return p;
				}
			}
		}
		
		return null; // Caso não encontre
	}
	
	public static Pedido getLastPedidoFromCliente(final int idCliente) {
		if (idCliente < 0 || ListaClientes.getCliente(idCliente) == null) {
			return null;
		}
		
		for(int i = cadastrados-1; i >= 0; i--) {
			Pedido p = ListaPedidos.pedidos[i];
			if (p != null && p.getCliente().getId() == idCliente) {
				return p;
			}
		}
		
		return null;
	}
	// Setters
	static int push(Pedido newPedido) {
		if (newPedido == null) {
			throw new NullPointerException("Pedido a ser inserido nao pode ser nulo");
		}
		
		if (pedidos == null) {
			pedidos = new Pedido[2];
		} else if (pedidos.length == cadastrados) {
			Pedido[] copia = pedidos.clone();
			pedidos = new Pedido[pedidos.length+1];
			
			for (int i=0; i < copia.length; i++) {
				pedidos[i] = copia[i];
			}
		}
		
		pedidos[cadastrados] = newPedido;
		
		return ++cadastrados;
	}
}
