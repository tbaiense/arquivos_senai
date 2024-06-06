programa
{
//Multiplica duas matrizes e mostra a matriz resultante
	inclua biblioteca Util
	funcao inicio()
	{
		const inteiro NUM_MIN = 0
		const inteiro NUM_MAX = 10
		const inteiro qntLinhasPrimeira = 2
		const inteiro qntColunasPrimeira = 3

		//const inteiro qntLinhasSegunda = qntColunasPrimeira //Obrigatório que seja o mesmo número de colunas da primara para a multiplicação de matrizes
		const inteiro qntColunasSegunda= 4

		inteiro matrizUm[qntLinhasPrimeira][qntColunasPrimeira]
		inteiro matrizDois[qntColunasPrimeira][qntColunasSegunda]
		inteiro matrizResultado[qntLinhasPrimeira][qntColunasSegunda]
		inteiro soma

		para (inteiro l = 0; l < qntLinhasPrimeira; l++) {
			para (inteiro c = 0; c < qntColunasPrimeira; c++) {
				matrizUm[l][c] = Util.sorteia(NUM_MIN, NUM_MAX)
			}
		}

		para (inteiro l = 0; l < qntColunasPrimeira; l++) {
			para (inteiro c = 0; c < qntColunasSegunda; c++) {
				matrizDois[l][c] = Util.sorteia(NUM_MIN, NUM_MAX)
			}
		}
		
		soma = 0
		para (inteiro l = 0; l < qntLinhasPrimeira; l++) {
			para (inteiro c = 0; c < qntColunasSegunda; c++) {
				soma = 0
				//Corre a primeira matriz coluna por coluna e depois linha por linha
				para (inteiro i = 0; i < qntColunasPrimeira; i++) { //Corre as colunas da primeira matriz e linhas da segunda
					soma += matrizUm[l][i] * matrizDois[i][c]
				}
				matrizResultado[l][c] = soma
			}
		}

		//Exibir matrizes
		escreva("### MATRIZ UM ###\n")
		para (inteiro l = 0; l < qntLinhasPrimeira; l++) {
			para (inteiro c = 0; c < qntColunasPrimeira; c++) {
				escreva(matrizUm[l][c],"\t")
			}
			escreva("\n")
		}
		escreva("\n\n")

		escreva("### MATRIZ DOIS ###\n")
		para (inteiro l = 0; l < qntColunasPrimeira; l++) {
			para (inteiro c = 0; c < qntColunasSegunda; c++) {
				escreva(matrizDois[l][c],"\t")
			}
			escreva("\n")
		}
		escreva("\n\n")

		escreva("### MATRIZES MULTIPLICADAS ###\n")
		para (inteiro l = 0; l < qntLinhasPrimeira; l++) {
			para (inteiro c = 0; c < qntColunasSegunda; c++) {
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
 * @POSICAO-CURSOR = 1888; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {qntLinhasPrimeira, 9, 16, 17}-{qntColunasPrimeira, 10, 16, 18}-{qntColunasSegunda, 13, 16, 17}-{matrizUm, 15, 10, 8}-{matrizDois, 16, 10, 10}-{matrizResultado, 17, 10, 15}-{soma, 18, 10, 4}-{l, 64, 16, 1}-{c, 21, 17, 1}-{l, 64, 16, 1}-{c, 21, 17, 1}-{l, 64, 16, 1}-{c, 21, 17, 1}-{l, 64, 16, 1}-{c, 21, 17, 1}-{l, 64, 16, 1}-{c, 21, 17, 1}-{l, 64, 16, 1}-{c, 21, 17, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */