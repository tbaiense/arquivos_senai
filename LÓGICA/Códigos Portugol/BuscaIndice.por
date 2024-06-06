programa
{	
	inclua biblioteca Util
	const inteiro tam = 10
	funcao inicio()
	{
		inteiro vetor[tam], buscado
			
		para (inteiro i = 0; i < tam; i++) {
			vetor[i] = Util.sorteia(1, 100)
		}

		escreva("Digite um número para buscar: ")
		leia(buscado)
		
		//Algoritmo de busca por índice ou sequencial
		para (inteiro i = 0; i < tam; i++) {
			se (buscado == vetor[i]) {
				escreva("Achei o número na casa ", i)
			}
		}

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 419; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 7, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */