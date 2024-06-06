programa
{
	inclua biblioteca Util
	funcao inicio() {
		loading()
	}

	funcao loading()
	{
		cadeia simbolos[] = {"  \\\  ", "  |  ", "  /  ", "  —  "}
		inteiro velocidade = 1000

		para (inteiro c = 0; c < 30; c++) {
			// Mostrar todos os símbolos da array
			para (inteiro elem = 0; elem < Util.numero_elementos(simbolos); elem++) {
				
				escolha (elem) {
					caso 3:
						escreva("... ")
						pare
					caso 2:
						escreva("..  ")
						pare
					caso 1:
						escreva(".   ")
						pare
					caso contrario:
						escreva("    ")
				}
				
				escreva("<",simbolos[elem], ">")
				Util.aguarde(velocidade)
				limpa()

			}
		}
	}


	funcao mostrarVetor(inteiro vetor[])
	{
		para (inteiro c = 0; c < Util.numero_elementos(vetor); c++) {
			escreva(vetor[c],"\n")
		}
		escreva("FIM!")
		escreva("\n")
	}

	funcao bubbleSort(inteiro vetor[])
	{
		inteiro temp, elem
		elem = Util.numero_	elementos(vetor)

		para (inteiro outer = 0; outer < elem - 1; outer++) {
			para (inteiro inner = outer + 1; inner < elem; inner++) {
				se (vetor[outer] > vetor[inner]) {
					temp = vetor[outer]
					vetor[outer] = vetor[inner]
					vetor[inner] = temp
				}
			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 903; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */