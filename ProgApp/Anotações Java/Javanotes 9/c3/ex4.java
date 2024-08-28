package com.mycompany;
import java.util.Scanner;

public class TesteJFX {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		String texto = entrada.nextLine();
		String resultado = "";
		boolean didCR= false;

		for(int i = 0; i < texto.length(); i++) {
			char c= texto.charAt(i);
			if (Character.isLetter(c)) {
				resultado += c;
				didCR = false;
			} else if (!didCR){
				resultado += '\n';
				didCR = true;
			}
		}

		System.out.print(resultado);

	}

}

