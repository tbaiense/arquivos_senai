programa
{	
	inclua biblioteca Util
	inclua biblioteca Tipos
	const inteiro tam = 10
	funcao inicio()
	{
		inteiro vetor[tam], buscado, posMenor, copia
		inteiro inicial, final, meio = 0
		logico encontrado = falso
			
		para (inteiro i = 0; i < tam; i++) {
			vetor[i] = Util.sorteia(1, 100)
		}

		// Ordenação Seleção
		para (inteiro pos = 0; pos < tam-1; pos++) {
			posMenor = pos
			para (inteiro posAdiante = pos+1; posAdiante < tam; posAdiante++) {
				se (vetor[posMenor] > vetor[posAdiante]) {
					posMenor = posAdiante
				}
			}
			
			copia = vetor[pos]
			vetor[pos] = vetor[posMenor]
			vetor[posMenor] = copia
		}

		escreva("Digite um número para buscar: ")
		leia(buscado)
		
		//Algoritmo de busca por binária
		inicial = 0
		final = Util.numero_elementos(vetor) - 1

		enquanto (inicial <= final e nao encontrado) {
			meio = Tipos.real_para_inteiro((Tipos.inteiro_para_real(inicial + final)) / 2)
			se (vetor[meio] == buscado) {
				encontrado = verdadeiro 
			} senao se (vetor[meio] > buscado) {
				final = meio - 1
			} senao {
				inicial = meio + 1
			}
		}

		se (encontrado == verdadeiro) {
			escreva("Eu achei na posição ", meio)
		} senao {
			escreva("Não achei o número pedido.")
		}

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 791; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 8, 10, 5}-{meio, 9, 26, 4};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */