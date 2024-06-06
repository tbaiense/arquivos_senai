programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		const inteiro elem = 10000
		inteiro vetor[elem], posMenor, copia
		
		escreva("Vetor original:\n")
		para (inteiro i = 0; i < elem; i++) {
			vetor[i] = Util.sorteia(0 , 100)
			escreva(vetor[i], "  ")
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
 * @POSICAO-CURSOR = 270; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */