programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		const inteiro elem = 10
		inteiro vetor[elem], copia
		
		escreva("Vetor original:\n")
		para (inteiro i = 0; i < elem; i++) {
			vetor[i] = Util.sorteia(0 , 100)
			escreva(vetor[i], "  ")
		}
		
		// ordena o vetor
		para (inteiro j = 0; j < elem; j++) {
			para (inteiro i = 0; i < elem-1; i++) {
				se (vetor[i] > vetor[i + 1]) {
						copia = vetor[i]
						vetor[i] = vetor[i+1]
						vetor[i+1] = copia 
				}
			}
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
 * @POSICAO-CURSOR = 312; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */