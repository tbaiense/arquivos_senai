package pedidos;


public class Pedido {
	// member variables ou static variables ou class variables
	private static int cadastrados;
	
	// instance variables
	private String nomeCliente;
	private final int idCliente;
	private final int id;
	private String produto;
	private String qtdProduto;
	private String endereco;
	private String destinatario;
	
	public Pedido(final int idCliente, final String produto, final String qtdProduto, final String endereco) {
		this(idCliente, produto, qtdProduto, endereco, null);
	}
	
	public Pedido(final int idCliente, final String produto, final String qtdProduto, final String endereco, final String destinatario) {
		if (idCliente < 0 || ListaClientes.getCliente(idCliente) == null) {
			throw new IllegalArgumentException("Id do cliente nao encontrado");
		}
		
		if (produto == null || produto.length() < 2)
			throw new IllegalArgumentException("Produto devem ter 3 ou mais caracteres");
		
		this.nomeCliente = ListaClientes.getCliente(idCliente).getNome();
		this.idCliente = idCliente;
		this.produto = produto;
		this.qtdProduto = qtdProduto;
		this.endereco = endereco;
		this.destinatario = destinatario;
		this.id = cadastrados++;
	}
	
	//Getters
	public int getId() {
		return this.id;
	}
	
	public Cliente getCliente() {
		return ListaClientes.getCliente(idCliente);
	}
	
	public String getNomeCliente() {
		return this.nomeCliente;
	}
	
	public String getProduto() {
		return this.produto;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public String getDestinatario() {
		return this.destinatario;
	}
	
	@Override
	public String toString() {return String.format("ID PED.: %d -------------------\nNOME CLIENTE: %-10s ID CLIENTE: %-2d TEL. CLIENTE: %-12s  PRODUTO: %-10s  QTD: %s\nENDERECO: %s  DESTINATÁRIO: %s", 
			this.getId(), this.getNomeCliente(), this.getCliente().getId(), this.getCliente().getTel(), this.getProduto(), this.qtdProduto, this.getEndereco(), (this.getDestinatario() == null) ? "N/A" : this.destinatario);}
}
