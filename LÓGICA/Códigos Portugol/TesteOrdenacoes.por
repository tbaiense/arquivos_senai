programa
{
	inclua biblioteca Util --> u

	const inteiro TAM = 100000
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
			//bolha()
			selecao()

		//Concatena os elementos do vetor, já ordenado, na cadeia de exibição
		/*
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
		*/
		escreva(vetorOrd)
		
		//Checa se há alguma parte não ordenada e exibe uma mensagem mostrando o local da última ocorrência
		se (ordenacaoInvalida) {
			escreva("\n\nORDENAÇÃO INVÁLIDA!\nEncontrado entre as posições "+ posOrdenacaoInvalida+ " ("+vetor[posOrdenacaoInvalida]+") .. "+ (posOrdenacaoInvalida+1)+ " ("+ vetor[posOrdenacaoInvalida+1]+ ")")
		}
	}
	
	funcao bolha() {
		inteiro copia
		//Ordenação bolha
		para (inteiro iteracao=1; iteracao <= TAM-1/*Na pior da situações, será necessário iterar a ordenação uma vez a menos do que a quantidade de elementos do vetor*/; iteracao++) {
			//Corre o vetor ordenando de dois em dois
			para (inteiro j=0; j<TAM-1; j++) {
				se (vetor[j]>vetor[j+1]) {
					copia = vetor[j]
					vetor[j] = vetor[j+1]
					vetor[j+1] = copia
				}
			}
		}
	}

	funcao selecao() {
		inteiro copia, posMenor
		//Ordenação seleção
		para (inteiro posTroca=0; posTroca<TAM-1; posTroca++) {
			posMenor=posTroca //Define que o menor valor seja o atual, apenas para iniciar a verificação dos elementos subsequentes
			para (inteiro posVerifica=posTroca+1; posVerifica<TAM; posVerifica++) {
				se (vetor[posMenor] > vetor[posVerifica]) {
					posMenor = posVerifica
				}
			}
			se (posMenor != posTroca) {
				copia = vetor[posTroca]
				vetor[posTroca] = vetor[posMenor]
				vetor[posMenor] = copia
			}
			
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 338; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */