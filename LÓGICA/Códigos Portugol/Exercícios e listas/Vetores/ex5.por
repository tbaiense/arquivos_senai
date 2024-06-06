programa
{
/*

5) Faça um algoritmo que preencha um vetor de 30 posições com números entre 1 e 15 sorteados pelo computador.
Depois disso, peça para o usuário digitar um número (chave) e seu programa deve mostrar em que posições essa chave foi encontrada.
Mostre também quantas vezes a chave foi sorteada.
 */

	inclua biblioteca Util --> u

	funcao inicio() {
		inteiro chave, qntChave
		qntChave = 0
		const inteiro elementos = 30
		inteiro vetor[elementos]
		
		para (inteiro c = 0; c < elementos; c++) {
			vetor[c] = u.sorteia(1, 15)
		}
		escreva("## VETOR GERADO ##\n{ ")
		para (inteiro c = 0; c < elementos; c++) {
			escreva(vetor[c], "  ")
		}
		escreva("}\n\nDigite a chave desejada para procurar: ")
		leia(chave)

		
		escreva("Posições encontradas no vetor:  ")
		para (inteiro c = 0; c < elementos; c++) {
			se (vetor[c] == chave) {
				escreva(c, "  ")
				qntChave++
			}
		}

		escreva("\nNúmero de chaves encontradas no vetor: ", qntChave)
	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 959; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */