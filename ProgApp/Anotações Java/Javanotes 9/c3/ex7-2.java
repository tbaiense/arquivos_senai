package com.mycompany;

public class TesteJFX {

	public static void main(String[] args) {
		int qntAniv = 0; // Quantidade de aniversários diferentes encontrados
		int[] encontrado = new int[365]; // Armazena os aniversários encontrados

		for (int pessoas = 365; pessoas > 1; --pessoas) {
			int aniv = (int)(Math.random() * 365); // Dia do aniversário da pessoa selecionada
			if (encontrado[aniv] == 0)
				++qntAniv;
			++encontrado[aniv];
		}
		System.out.print("Aniversários diferentes: " + qntAniv);
	}

}
