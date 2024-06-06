programa
{
	inclua biblioteca Util --> u

	const inteiro TAM = 10000
	inteiro vetor[TAM]
	cadeia vetorOrd = ""
	logico ordenacaoInvalida = falso
	inteiro posOrdenacaoInvalida = 0
	
	funcao inicio()
	{
		//Sorteia os elementos do vetor
		para (inteiro i=0; i < TAM; i++) {
			vetor[i] = u.sorteia(1, 1000000)
		}

		//Ordenação
			bolha()
			//selecao()
			//insercao()

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
	
	funcao selecao() {
		inteiro posMenor, copia
		//Itera sobre os elementos da array que serão ou não substituidos
		para (inteiro atual=0; atual<TAM-1; atual++) {
			posMenor = atual
			para (inteiro procura = atual+1; procura<TAM; procura++) {
				se (vetor[procura] < vetor[posMenor]) {
					posMenor = procura
				}
			}
			se (posMenor != atual) {
				copia = vetor[atual]
				vetor[atual] = vetor[posMenor]
				vetor[posMenor] = copia
			}
		}
	}

	funcao insercao() {
		inteiro numAtual, posVerifica
		para (inteiro posAtual=1; posAtual<TAM; posAtual++) {
			numAtual = vetor[posAtual]
			posVerifica = posAtual-1
			enquanto (posVerifica >= 0 e numAtual < vetor[posVerifica]) {
				vetor[posVerifica+1] = vetor[posVerifica]
				posVerifica--
			}
			vetor[posVerifica+1] = numAtual
		}
	}

	funcao bolha() {
		inteiro copia
		para (inteiro i=1; i<=TAM-1; i++) {
			para (inteiro j=0; j<TAM-1; j++) {
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
 * @POSICAO-CURSOR = 343; 
 * @DOBRAMENTO-CODIGO = [43, 61];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */