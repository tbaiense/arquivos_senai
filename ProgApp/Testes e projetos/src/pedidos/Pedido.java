package pedidos;

import validacao.CPF;

public class Pedido {
	// member variables ou static variables ou class variables
	private static int cadastrados;
	
	// instance variables
	private String nomeCliente;
	private int idCliente;
	private int id;
	private String produto;
	private String qtdProduto;
	private String endereco;
	private String destinatario;
	private String cpf;
	
	private Pedido() {}
	
	public Pedido(final int idCliente) {
		this.idCliente = idCliente;
	}

	
	public Pedido(final int idCliente, final String produto, final String qtdProduto, final String endereco) {
		validateCliente(idCliente);
		validateProduto(produto);
		validateQuantidade(qtdProduto);
		validateEndereco(endereco);
		
		this.nomeCliente = ListaClientes.getCliente(idCliente).getNome();
		this.idCliente = idCliente;
		this.produto = produto;
		this.qtdProduto = qtdProduto;
		this.endereco = endereco;
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
	
	public String getCpf() {
		return this.cpf;
	}
	
	//Setters
	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
	}
	
	public void setProduto(String produto) {
		validateProduto(produto);
		this.produto = produto;
	}
	
	public void setQuantidade(String quantidade) {
		validateQuantidade(quantidade);
		this.qtdProduto = quantidade;
	}
	
	public void setEndereco(String endereco) {
		validateEndereco(endereco);
		this.endereco = endereco;
	}
	
	public void setDestinatario(String destinatario) {
		if (destinatario == null || destinatario.length() < 2)
			destinatario = null;
		this.destinatario = destinatario;
	}
	
	public void setCpf(CPF cpf) {
		if (cpf == null) {
			this.cpf = null;
			return;
		}
		
		this.cpf = cpf.getNumerico();
	}
	
	// Validadores
	static void validateProduto(String produto) {
		produto = produto.trim();
		if (produto == null || produto.length() < 3 ) {
			throw new IllegalArgumentException("produto deve ter 3 ou mais caracteres");
		}
	}
	
	static void validateCliente(int idCliente) {
		if (idCliente < 0 || ListaClientes.getCliente(idCliente) == null) {
			throw new IllegalArgumentException("Id do cliente nao encontrado");
		}
	}
	
	static void validateEndereco(String endereco) {
		endereco = endereco.trim();
		if (endereco == null || endereco.length() < 10 ) {
			throw new IllegalArgumentException("endereco deve ter 10 ou mais caracteres");
		}
	}
	
	static void validateQuantidade(String quantidade) {
		quantidade = quantidade.trim();
		if (quantidade == null || quantidade.length() < 1 ) {
			throw new IllegalArgumentException("quantidade deve ter 1 ou mais caracteres");
		}
	}
	
	@Override
	public String toString() {return String.format("ID PED.: %d -------------------\nNOME CLIENTE: %-10s ID CLIENTE: %-2d TEL. CLIENTE: %-12s  PRODUTO: %-10s  QTD: %s\nENDERECO: %s  DESTINATÁRIO: %s  CPF: %s", 
			this.getId(), this.getNomeCliente(), this.getCliente().getId(), this.getCliente().getTel(),
			this.getProduto(), this.qtdProduto, this.getEndereco(), 
			(this.getDestinatario() == null) ? "N/A" : this.destinatario,
			(this.cpf == null) ? "N/A" : String.format("%,d-%s", Long.parseLong(this.cpf.substring(0, CPF.DIG_ID)), this.cpf.substring(CPF.DIG_ID)));}
}
