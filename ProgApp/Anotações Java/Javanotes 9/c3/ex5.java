package com.mycompany;
import java.util.Scanner;

public class TesteJFX {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		double valorTotal = 0.0;
		int naoDisponivel = 0;
		String entrada;
		while ((entrada = stdin.nextLine()).length() > 1) {
			int i = entrada.indexOf(':');
			if (i >= 0) {
				try {
					valorTotal += Double.parseDouble(entrada.substring(i + 1));
				} catch (NumberFormatException e) {
					System.out.println("Valor inválido!");
					++naoDisponivel;
				}
			} else
				System.out.println("Delimitador não encontrado!");
		}
		System.out.print("Total: " + valorTotal + " | Não disponíveis: " + naoDisponivel);
	}

}

