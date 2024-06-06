programa
{
	inclua biblioteca Util
	const inteiro numL = 3, numC = 4
	funcao inicio()
	{
		inteiro matriz[numL][numC]
		para (inteiro c = 0; c < numC; c++) {
			para (inteiro l = 0; l < numL; l++) {
				escreva("## MATRIZ ", numL, "x", numC, " ##\n>>> Digite o valor na posição ", l, "x", c, ": ")
				matriz[l][c] = Util.sorteia(1, 50)
				limpa()
			}
		}

		escreva("## MATRIZ NORMAL ", numL, "x", numC, " ##\n")
		para (inteiro c = 0; c < numL; c++) {
			escreva("|\t")
			para (inteiro l = 0; l < numC; l++) {
				escreva(matriz[c][l], "\t")
			}
			escreva("|\n")
		}
	
		escreva("\n\n## MATRIZ TRANSPOSTA ", numC, "x", numL, " ##\n")
		para (inteiro c = 0; c < numC; c++) {
			escreva("|\t")
			para (inteiro l = 0; l < numL; l++) {
				escreva(matriz[l][c], "\t")
			}
			escreva("|\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 763; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {matriz, 7, 10, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */