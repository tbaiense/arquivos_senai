programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		const inteiro elem = 100
		inteiro vetor[elem], posMenor, copia
		
		escreva("Vetor original:\n")
		para (inteiro i = 0; i < elem; i++) {
			vetor[i] = Util.sorteia(0 , 100)
			escreva(vetor[i], "  ")
		}

		para (inteiro pos = 0; pos < elem-1; pos++) {
			posMenor = pos
			para (inteiro posAdiante = pos+1; posAdiante < elem; posAdiante++) {
				se (vetor[posMenor] > vetor[posAdiante]) {
					posMenor = posAdiante
				}
			}
			
			copia = vetor[pos]
			vetor[pos] = vetor[posMenor]
			vetor[posMenor] = copia
		}
		
		
		///*
		escreva("\n\nVetor Ordenado:\n")
		para (inteiro i = 0; i < elem; i++) {
			escreva(vetor[i], "  ")
		}
		//*/
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 700; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */