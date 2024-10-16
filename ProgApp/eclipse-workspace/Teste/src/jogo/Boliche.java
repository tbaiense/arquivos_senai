package jogo;

import java.util.ArrayList;

public class Boliche extends Jogo {
	
	public ArrayList<Boliche.Jogador> jogadores;
	
	Boliche() {
		super(TipoJogo.BOLICHE, 10, 60);
		this.jogadores = new ArrayList<Boliche.Jogador>();
	}
	
	public class Jogador extends Jogo.Jogador {
		int bolas;
		
		Jogador(String nome, int idade, int bolas) {
			super(nome, idade);
			this.bolas = bolas;
		}
		
		
	}
	
	public void getTempoRestante() {
		System.out.print(super.tempoRestante);
	}
}
