package com.mycompany;

public class TesteJFX {

	public static void main(String[] args) {
		int vezes = 0;
		int d1, d2;

		while(true) {
			vezes++;
			d1 = (int)(Math.random() * 6 + 1);
			d2 = (int)(Math.random() * 6 + 1);
			if (d1 == d2 && d1 == 1)
				break;
		}

		System.out.print("Quantidade de vezes " + vezes);
	}

}

