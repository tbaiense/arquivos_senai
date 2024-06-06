programa
{
//Soma duas matrizes e mostra a matriz resultante
	inclua biblioteca Util
	funcao inicio()
	{
		const inteiro NUM_MIN = 0
		const inteiro NUM_MAX = 10
		const inteiro qntLinhas = 2
		const inteiro qntColunas = 3

		//const inteiro qntLinhasSegunda = qntColunasPrimeira //Obrigatório que seja o mesmo número de colunas da primara para a multiplicação de matrizes
		const inteiro qntColunasSegunda= 4

		inteiro matrizUm[qntLinhas][qntColunas]
		inteiro matrizDois[qntLinhas][qntColunas]
		inteiro matrizResultado[qntLinhas][qntColunas]
		inteiro soma

		para (inteiro l = 0; l < qntLinhas; l++) {
			para (inteiro c = 0; c < qntColunas; c++) {
				matrizUm[l][c] = Util.sorteia(NUM_MIN, NUM_MAX)
			}
		}

		para (inteiro l = 0; l < qntLinhas; l++) {
			para (inteiro c = 0; c < qntColunas; c++) {
				matrizDois[l][c] = Util.sorteia(NUM_MIN, NUM_MAX)
			}
		}

		para (inteiro l = 0; l < qntLinhas; l++) {
			para (inteiro c = 0; c < qntColunas; c++) {
				matrizResultado[l][c] = matrizUm[l][c] + matrizDois[l][c]
			}
		}

		//Exibir matrizes
		escreva("### MATRIZ UM ###\n")
		para (inteiro l = 0; l < qntLinhas; l++) {
			para (inteiro c = 0; c < qntColunas; c++) {
				escreva(matrizUm[l][c],"\t")
			}
			escreva("\n")
		}
		escreva("\n\n")

		escreva("### MATRIZ DOIS ###\n")
		para (inteiro l = 0; l < qntLinhas; l++) {
			para (inteiro c = 0; c < qntColunas; c++) {
				escreva(matrizDois[l][c],"\t")
			}
			escreva("\n")
		}
		escreva("\n\n")

		escreva("### MATRIZES SOMADAS ###\n")
		para (inteiro l = 0; l < qntLinhas; l++) {
			para (inteiro c = 0; c < qntColunas; c++) {
				escreva(matrizResultado[l][c],"\t")
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
 * @POSICAO-CURSOR = 1497; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {qntColunasSegunda, 13, 16, 17}-{matrizUm, 15, 10, 8}-{matrizDois, 16, 10, 10}-{matrizResultado, 17, 10, 15}-{soma, 18, 10, 4}-{l, 20, 16, 1}-{c, 21, 17, 1}-{l, 26, 16, 1}-{c, 27, 17, 1}-{l, 32, 16, 1}-{c, 33, 17, 1}-{l, 40, 16, 1}-{c, 41, 17, 1}-{l, 49, 16, 1}-{c, 50, 17, 1}-{l, 58, 16, 1}-{c, 59, 17, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */