programa
{
	inclua biblioteca Util
	funcao inicio()
	{
		const inteiro tam = 10
		inteiro vetor[tam], copia

		para (inteiro i = 0; i < tam; i++) {
			vetor[i] = Util.sorteia(1, 100)
		}

		para (inteiro iteracao = 0; iteracao < tam; iteracao++) { //Itera a ordenação
			para (inteiro j = 0; j < tam-1; j++) { //Corre a array uma vez ordenando-a
				se (vetor[j] > vetor[j+1]) {
					copia = vetor[j]
					vetor[j] = vetor[j+1]
					vetor[j+1] = copia
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
 * @POSICAO-CURSOR = 349; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 7, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */