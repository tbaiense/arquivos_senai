package jogo;

import java.util.ArrayList;

public class Jogo {
	public final TipoJogo tipo;
	public final int MAX_JOGADORES;
	public final int TEMPO_LIMITE;
	public int tempoRestante;
	public ArrayList<Jogo.Jogador> jogadores;
	
	Jogo(TipoJogo tipo, int maxJog, int tempoLim) {
		this.tipo = tipo;
		this.MAX_JOGADORES = maxJog;
		this.TEMPO_LIMITE = tempoLim;
		this.tempoRestante = this.TEMPO_LIMITE;
	}
	
	public class Jogador {
		String nome;
		int idade;
		static qtdCriado;
		int id;
		
		Jogador(String nome, int idade) {
			this.nome = nome;
			this.idade = idade;
			this.id = ++qtdCriado;
		}
		
		public String getNome() {
			return this.nome;
		}
	}
	
	public void add(Jogador j) {
		this.jogadores.add(j);
	}
	
}

Jogador eu = new Jogador("thiago", 22, "sub20");
Jogador eu2 = new Jogador("thiago", 22, "sub10");
eu.id;
Jogador.quantidadeCriado;
