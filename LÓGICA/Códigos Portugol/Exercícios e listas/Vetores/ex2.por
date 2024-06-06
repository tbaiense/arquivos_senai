programa
{
/*
 * 2) Faça um programa que leia 7 nomes de pessoas e guarde-os em um vetor. 
 * No final, mostre uma listagem com todos os nomes informados, na ordem inversa
   daquela em que eles foram informados.
 */

	inclua biblioteca Util --> u
	funcao inicio()
	{
		const inteiro elem = 7 // num elementos do vetor
		cadeia vetor[elem]
		para (inteiro c = 0; c < elem; c++) {
			escreva(c, "- Digite o nome: ")
			leia(vetor[c])
		}
		escreva(" # VETOR INVERTIDO #\n")
		mostrarVetor(vetor)
	}

	funcao mostrarVetor(cadeia vetor[])
	{

		inteiro elementos = Util.numero_elementos(vetor)
		escreva("{")
		para (inteiro c = elementos - 1; c >= 0; c--) {
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
 * @POSICAO-CURSOR = 494; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */