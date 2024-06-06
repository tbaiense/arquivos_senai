programa
{
	inclua biblioteca Util
	const inteiro linhas = 5, colunas = 5
	funcao inicio()
	{
		inteiro vetor[linhas][colunas], procurado
		logico foiEncontrado = falso
		
		para (inteiro l = 0; l < linhas; l++) {
			para (inteiro c = 0; c < colunas; c++) {
				//escreva("Valor da posicao ", l, ",", c, ": ")
				//leia(vetor[l][c])
				vetor[l][c] = Util.sorteia(1, 10)
			}
		}

		escreva("Digite o número a ser procurado: ")
		leia(procurado)

		//Busca sequencial
		para (inteiro l = 0; l < linhas; l++) {
			para (inteiro c = 0; c < colunas; c++) {
				se (vetor[l][c] == procurado) {
					foiEncontrado = verdadeiro
					escreva("O número procurado foi encontrado na posição ", l, ",", c, " do vetor.\n")
				}
			}
		}

		se (nao foiEncontrado) {
			escreva("O valor ", procurado, " não foi encontrado no vetor.\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 821; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 7, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */