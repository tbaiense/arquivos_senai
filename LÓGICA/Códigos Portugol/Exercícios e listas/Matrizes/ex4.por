programa
{
	inclua biblioteca Util
	funcao inicio()
	{
		const inteiro numColunas = 4, numLinhas = 4
		inteiro matrizUm[numLinhas][numColunas], matrizDois[numLinhas][numColunas], matrizMaiores[numLinhas][numLinhas]

		//Preenche as tres matrizes
		para (inteiro l = 0; l < numLinhas; l++) {
			para (inteiro c = 0; c < numColunas; c++) {
				escreva("Digite o numero da posição ", l, ",", c, " da 1ª matriz: ")
				leia(matrizUm[l][c])
				//matrizUm[l][c] = Util.sorteia(0, 100)
				escreva("Digite o numero da posição ", l, ",", c, " da 2ª matriz: ")
				leia(matrizDois[l][c])
				//matrizDois[l][c] = Util.sorteia(0, 100)
				escreva("\n")

				se (matrizUm[l][c] > matrizDois[l][c]) {
					matrizMaiores[l][c] = matrizUm[l][c]
				} senao {
					matrizMaiores[l][c] = matrizDois[l][c]
				}
			}
		}
		limpa()
		
		//Exibir matrizes
		escreva("### MATRIZ UM ###\n")
		para (inteiro l = 0; l < numLinhas; l++) {
			para (inteiro c = 0; c < numColunas; c++) {
				escreva(matrizUm[l][c],"\t")
			}
			escreva("\n")
		}
		escreva("\n\n")

		escreva("### MATRIZ DOIS ###\n")
		para (inteiro l = 0; l < numLinhas; l++) {
			para (inteiro c = 0; c < numColunas; c++) {
				escreva(matrizDois[l][c],"\t")
			}
			escreva("\n")
		}
		escreva("\n\n")

		escreva("### MAIORES NUMEROS ###\n")
		para (inteiro l = 0; l < numLinhas; l++) {
			para (inteiro c = 0; c < numColunas; c++) {
				escreva(matrizMaiores[l][c],"\t")
			}
			escreva("\n")
		}
		escreva("\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1278; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {matrizUm, 7, 10, 8}-{matrizDois, 7, 43, 10}-{matrizMaiores, 7, 78, 13};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */