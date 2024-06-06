programa
{
/*

4) Crie um programa que preencha automaticamente (usando lógica, não apenas atribuindo diretamente)
um vetor numérico com 15 posições com os primeiros
elementos da sequência de Fibonacci:

1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987
 */

	inclua biblioteca Util --> u
	funcao inicio()
	{
		const inteiro numElem = 15
		inteiro fibo[numElem]
		inteiro atual, anterior, proximo
		atual = 1
		anterior = 1
		proximo = 1
		
		para (inteiro c = 0; c < numElem; c++) {
			se (c == 0) {
				fibo[0] = 1
			} senao {
				atual = proximo
				fibo[c] = atual
				proximo = atual + anterior
				anterior = atual	
			}
		}

		mostrarVetor(fibo)
		
	}

	funcao mostrarVetor(inteiro vetor[])
	{

		inteiro elementos = Util.numero_elementos(vetor)
		escreva("{")
		para (inteiro c = 0; c < elementos; c++) {
			escreva(" ", vetor[c])
			se (c > 0 e c < elementos - 1) {
				escreva(",")
			} senao {
				escreva(" ")
			}
		}
		escreva("} \n")
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 624; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */