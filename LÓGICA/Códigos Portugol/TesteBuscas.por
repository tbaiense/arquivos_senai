programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Tipos --> t


	const inteiro TAM = 100
	inteiro vetor[TAM], entrada
	
	funcao inicio()
	{
		preencherVetor()
		selectionSort()
		mostrarVetor()
		escreva(">>> ")
		leia(entrada)
		escreva(indexSearch(entrada))
		//escreva(binarySearch(entrada))
	}

	funcao preencherVetor() {
		const inteiro ini = 0
		const inteiro fin = 100

		para (inteiro num= 0; num<TAM; num++) {
			vetor[num] = u.sorteia(ini, fin)
		}
	}
	funcao selectionSort() {
		inteiro posMenor, copia
		para (inteiro atual=0; atual<TAM-1; atual++) {
			posMenor = atual
			para (inteiro seguinte= atual+1; seguinte<TAM; seguinte++) {
				se (vetor[posMenor] > vetor[seguinte]) {
					posMenor = seguinte
				}
			}
			copia = vetor[posMenor]
			vetor[posMenor] = vetor[atual]
			vetor[atual] = copia
		}
	}
	funcao inteiro binarySearch(inteiro procurado) {
		inteiro ini=0, fin=TAM-1, meio
		enquanto (ini <= fin) {
			meio= t.real_para_inteiro(t.inteiro_para_real(ini+fin)/2)
			se (vetor[meio] == procurado) {
				retorne meio
			} senao se (vetor[meio] > procurado) {
				fin= meio -1
			} senao {
				ini= meio +1
			}
		}
		retorne -1 // Situação em que o número não foi encontrado
	}
	funcao inteiro indexSearch(inteiro procurado) {
		para (inteiro elem=0; elem<TAM; elem++) {
			se (vetor[elem] == procurado) {
				retorne elem
			}
		}
		retorne -1
	}
	funcao mostrarVetor() {
		cadeia texto = ""
		para (inteiro elem=0; elem<TAM; elem++) {
			texto += vetor[elem] + "\t"
			se (elem>0 e (elem+1) % 20 == 0) {
				texto += "\n"
			}
		}
		escreva(texto+"\n\n\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1526; 
 * @DOBRAMENTO-CODIGO = [28, 42, 56];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */