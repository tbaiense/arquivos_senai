programa
{
/*
 * 1) Crie um programa que preencha automaticamente (usando lógica, não apenas atribuindo diretamente) 
 * um vetor numérico com 10 posições e depois mostre os valores gerados na tela.
 */

	inclua biblioteca Util --> u
	funcao inicio()
	{
		const inteiro elem = 10 // num elementos do vetor
		inteiro vetor[elem]
		para (inteiro c = 0; c < elem; c++) {
			vetor[c] = u.sorteia(0, 100)
		}
		escreva(" # VETOR ORIGINAL #\n")
		mostrarVetor(vetor)


		escreva("\n\n # VETOR ORDENADO #\n")
		bubbleSort(vetor)
		mostrarVetor(vetor)
	}

	funcao mostrarVetor(inteiro vetor[])
	{

		inteiro elementos = Util.numero_elementos(vetor)
		escreva("{")
		para (inteiro c = 0; c < elementos; c++) {
			escreva(" ", vetor[c])
			se (c > 0 e c < elementos - 1) {
				escreva(",")
			} senao {
				escreva(" ")
			}
		}
		escreva("} \n")
	}

	funcao bubbleSort(inteiro vetor[])
	{
		inteiro temp, elem
		elem = Util.numero_elementos(vetor)

		para (inteiro outer = 0; outer < elem - 1; outer++) {
			para (inteiro inner = outer + 1; inner < elem; inner++) {
				se (vetor[outer] > vetor[inner]) {
					temp = vetor[outer]
					vetor[outer] = vetor[inner]
					vetor[inner] = temp
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
 * @POSICAO-CURSOR = 807; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */