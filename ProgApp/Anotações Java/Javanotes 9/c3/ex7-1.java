package com.mycompany;

public class TesteJFX {

	public static void main(String[] args) {
		int qntAniv = 3; // Quantidade de aniversários no mesmo dia para finalizar a procura
		int pessoas = 0; // Pessoas selecionadas até encontrar `qntAniv`
		int aniv; // Dia do aniversário da pessoa selecionada
		int[] encontrado = new int[365]; // Armazena os aniversários encontrados

		while(true) {
			aniv = (int)(Math.random() * 365);
			++pessoas;
			if (++encontrado[aniv] >= 3) {
				break;
			}

		}

		System.out.print(pessoas);
	}

}

