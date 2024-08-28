package com.mycompany;

public class TesteJFX {

	public static void main(String[] args) {
		int maior, maiorQnt, divisoresAtual;

		maior = 1; // O inteiro com o maior número de divisores será 1 inicialmente
		maiorQnt = 1;
		for(int i = 2; i <= 10000; i++) {
			divisoresAtual = 2;
			for (int d = i-1; d > 1; d--)
				if (i % d == 0)
					divisoresAtual++;
			if (divisoresAtual > maiorQnt) {
				maiorQnt = divisoresAtual;
				maior = i;
			}
		}

		System.out.print("I: " + maior + "(" + maiorQnt + ")");
	}

}
