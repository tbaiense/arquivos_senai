programa
{
	inclua biblioteca Util
	const inteiro linhas = 4, colunas = 4
	const inteiro procurado = 10
	funcao inicio()
	{
		inteiro vetor[linhas][colunas]
		inteiro ocorrProcurado = 0
		para (inteiro l = 0; l < linhas; l++) {
			para (inteiro c = 0; c < colunas; c++) {
				escreva("Digite o valor para a posição ", l, ",", c, " da matriz: ")	
				leia(vetor[l][c])
				//vetor[l][c] = Util.sorteia(5, 20)
			}
		}

		//Contar quantos números são maiores do que o procurado
		para (inteiro l = 0; l < linhas; l++) {
			para (inteiro c = 0; c < colunas; c++) {
				se (vetor[l][c] > procurado) {
					ocorrProcurado++
				}
			}
		}

		escreva("\n\nForam encontrados ", ocorrProcurado, " ocorrencias de valores maiores que ", procurado, ".") 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 354; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 8, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */