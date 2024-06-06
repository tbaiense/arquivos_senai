programa
{
	const inteiro tam = 8
	funcao inicio()
	{
		inteiro vetor[tam], valor, x, y
		
		para (inteiro i = 0; i < tam; i++) {
			escreva("Digite o valor da ", i, "a posição do vetor: ")
			leia(valor)
			vetor[i] = valor
		}

		escreva("Vetor:\n")
		para (inteiro j = 0; j < tam; j++) {
			escreva(vetor[j], "  ")
		}
		escreva("\n\n")

		escreva("A posição do primeiro valor a ser somado: ")
		leia(x)
		escreva("A posição do segundo valor a ser somado: ")
		leia(y)

		escreva("A soma dos valores nas posições '", x, "'(", vetor[x], ") e '", y, "'(", vetor[y], ") é igual a ", vetor[x] + vetor[y])
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 224; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */