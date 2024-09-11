package org.thiago;

class Usuario {
	String nome;
	
	Grupo[] grupos;
	
	Usuario(String nome, Grupo[] grupos) {
		this.nome = nome;
		this.grupos = new Grupo[grupos.length+1]; // Adiciona espaço para grupos adicionados + 1 (grupo todos)
		
		String[] permissoesTODOS = new String[2];
		permissoesTODOS[0] = "pedido.consultar";
		permissoesTODOS[1] = "pedido.editar.*";
		
		this.grupos[0] = new Grupo("TODOS", permissoesTODOS);
		for(int i=1; i<grupos.length && grupos[i] != null; i++) {
			this.grupos[i] = new Grupo(grupos[i].nome, grupos[i].permissoes);
		}
	}
	
	Usuario(String nome) {
		this.nome = nome;
		this.grupos = new Grupo[1]; // Adiciona espaço para 1 (grupo todos)
		
		String[] permissoesTODOS = new String[2];
		permissoesTODOS[0] = "pedido.consultar";
		permissoesTODOS[1] = "pedido.editar.*";
		
		this.grupos[0] = new Grupo("TODOS", permissoesTODOS);
		for(int i=1; i<grupos.length && grupos[i] != null; i++) {
			this.grupos[i] = new Grupo(grupos[i].nome, grupos[i].permissoes);
		}
	}
	
}

class Grupo {
	private static int grupos_cadastrados = 0;
	int id;
	String nome;
	String[] permissoes;
	
	Grupo(String nome, String[] permissoes) {
		this.id = grupos_cadastrados++;
		this.nome = nome;
		this.permissoes = new String[permissoes.length];
		
		for(int i=0; i<permissoes.length && permissoes[i] != null; i++) {
			this.permissoes[i] = permissoes[i];
		}
	}
}

public class ControlePermissao {
	public static void main(String args[]) {
		Usuario thiago = new Usuario("thiagooooo");
		if (temPermissao(thiago, "pedido.cadastrar", "pedido.*")) {
			System.out.print("permissao concedida");
		} else {
			System.out.print("permissao NEGADA");
		}
	}
	
	/**
	 * Verifica se determinado usuário possui permissão em seu objeto.
	 * @param usr - Objeto do tipo Usuario.
	 * @param permissao - String contendo a permissão a ser procurada.
	 * @return true se for encontrado em algum, false se não for encontrada.
	 */
	public static boolean temPermissao(Usuario usr, String permissao, String coringa) {
		for(int g=0; g<usr.grupos.length; g++) {
			Grupo grupoUsr=usr.grupos[g];
			
			for(int i=0; i<grupoUsr.permissoes.length && grupoUsr.permissoes[i] != null; i++) {
				if(grupoUsr.permissoes[i].equals(permissao) || grupoUsr.permissoes[i].equals(coringa)) {
					return true;
				}
			}
		}

		return false;
	}
}
