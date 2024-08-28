package com.mycompany;

public class TesteJFX {

	public static void main(String[] args) {
		int qntAniv = 365; // Quantidade de aniversários restantes a encontrar
		boolean[] encontrado = new boolean[365]; // Armazena os aniversários encontrados
		int pessoas = 0; // Pessoas selecionadas até encontrar um aniversário para todos os dias do ano

		for (pessoas = 0; qntAniv > 0; ++pessoas) {
			int aniv = (int)(Math.random() * 365); // Dia do aniversário da pessoa selecionada
			if (encontrado[aniv] == false) {
					--qntAniv;
					encontrado[aniv] = true;
			}
		}
		System.out.print("Pessoas avaliadas até encontrar todos os aniversários: " + pessoas);
	}

}
