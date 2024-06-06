programa
{
	inclua biblioteca Util --> u

	const inteiro TAM = 1000
	inteiro vetor[TAM]
	cadeia vetorOrd = ""
	logico ordenacaoInvalida = falso
	inteiro posOrdenacaoInvalida = 0
	
	funcao inicio()
	{
		//Sorteia os elementos do vetor
		para (inteiro i=0; i < TAM; i++) {
			vetor[i] = u.sorteia(1, 10000)
		}

		//Ordenação
			//bolha()
			//selecao()
			insercao()

		//Concatena os elementos do vetor, já ordenado, na cadeia de exibição
		para (inteiro i=0; i < TAM; i++) {
			se (i > 0 e i%20 == 0) {
				vetorOrd += "\n"
			}
			se (i != TAM-1 e vetor[i] > vetor[i+1]) {
				ordenacaoInvalida = verdadeiro
				posOrdenacaoInvalida = i
				pare
			}
			vetorOrd += vetor[i]+",	"
		}
		
		escreva(vetorOrd)
		
		//Checa se há alguma parte não ordenada e exibe uma mensagem mostrando o local da última ocorrência
		se (ordenacaoInvalida) {
			escreva("\n\nORDENAÇÃO INVÁLIDA!\nEncontrado entre as posições "+ posOrdenacaoInvalida+ " ("+vetor[posOrdenacaoInvalida]+") .. "+ (posOrdenacaoInvalida+1)+ " ("+ vetor[posOrdenacaoInvalida+1]+ ")")
		}
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1050; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */