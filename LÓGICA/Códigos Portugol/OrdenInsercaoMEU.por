programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		const inteiro elem = 10
		inteiro vetor[elem], indice, copia
		
		escreva("Vetor original:\n")
		para (inteiro i = 0; i < elem; i++) {
			vetor[i] = Util.sorteia(0 , 100)
			escreva(vetor[i], "  ")
		}
		
		// ordena o vetor
		para (inteiro i = 1; i < elem; i++) {
			copia = vetor[i]
			indice = i
			enquanto (indice > 0 e vetor[indice-1] > copia) {
				vetor[indice] = vetor[indice - 1]
				indice--
			}
			vetor[indice] = copia
 			
		}

		escreva("\n\nVetor Ordenado:\n")
		para (inteiro i = 0; i < elem; i++) {
			escreva(vetor[i], "  ")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 98; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 8, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */