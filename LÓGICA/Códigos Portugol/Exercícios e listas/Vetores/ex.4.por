programa
{
/*
3) Escreva um programa que leia 15 números e guarde-os em um vetor. 
	No final, mostre o vetor inteiro na tela e em seguida mostre em que posições foram
	digitados valores que são múltiplos de 10.
 */

	inclua biblioteca Util --> u
	funcao inicio()
	{
		const inteiro elem = 15 // num elementos do vetor
		inteiro vetor[elem]
		logico mult[elem]
		para (inteiro c = 0; c < elem; c++) {
			escreva(c+1, "- Digite o numero: ")
			leia(vetor[c])
			se (vetor[c] % 10 == 0) {
				mult[c] = verdadeiro
			} senao {
				mult[c] = falso
			}
		}
		escreva("\n# VETOR #\n")
		mostrarVetor(vetor)

		
		escreva("\n\n Posição dos múltiplos de dez: ")
		para (inteiro c = 0; c < elem; c++) {
			se (mult[c]) {
				escreva(c, " ")
			}
		}
		
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
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 291; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */