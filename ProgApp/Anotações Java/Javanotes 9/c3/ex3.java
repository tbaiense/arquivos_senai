package com.mycompany;
import java.util.Scanner;
import java.util.InputMismatchException;
public class TesteJFX {

	public static void main(String[] args) {
		double valor1, valor2;
		char op;

		Scanner stdin = new Scanner(System.in);

		valor1 = valor2 = 0;
		while (true) {
			try {
				valor1 = stdin.nextDouble();
				if (valor1 == 0)
					break;
				op = stdin.next().charAt(0);
				valor2 = stdin.nextDouble();
			} catch (InputMismatchException e) {
				stdin.nextLine();
				System.out.print("Valores inválidos! Tente novamente: ");
				continue;
			}
			stdin.nextLine();

			double resultado;
			switch (op) {
				case '+' -> resultado = valor1 + valor2;
				case '-' -> resultado = valor1 - valor2;
				case '*' -> resultado = valor1 * valor2;
				case '/' -> resultado = valor1 / valor2;
				default -> {
					System.out.print("Operador inválido. Tente novamente: ");
					continue;
				}
			};

			System.out.println("Resultado "+ resultado);
		}

	}

}

