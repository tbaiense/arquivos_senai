package jogo;

public class NovoJogo {
	public static void main(String[] args) {
		Jogo j = new Jogo(TipoJogo.BOLICHE, 10, 10);
		Boliche boliche = new Boliche();
		Boliche.Jogador jb = boliche.new Jogador("thuiagoi", 10, 3);
		Jogo.Jogador b =  j.new Jogador("thiago", 1);
		boliche.getTempoRestante();
		System.out.print("Meu nome é " + jb.getNome());
	}
}
