programa
{
	inclua biblioteca Tipos
	
	funcao inicio()
	{
		inteiro entrada, soma, pessoas, maior, menor
		real media
		soma = 0
		pessoas = 0
		maior = 0
		menor = 0

		faca
		{
			escreva("Digite sua entrada: ")
			leia(entrada)
			
			se (entrada != 0)
			{
				soma = soma + entrada
				pessoas++
				
				se (pessoas == 1)
				{
					menor = entrada
				}

				se (entrada > maior)
				{
					maior = entrada
				}
				
				se (pessoas == 1 ou entrada < menor)
				{
					menor = entrada
				}
			}
			
		} enquanto (entrada != 0)

		media = Tipos.inteiro_para_real(soma) / Tipos.inteiro_para_real(pessoas)

		escreva("\n# FINALIZANDO INSERÇÃO DE DADOS... #\n")
		escreva("Idades cadastradas: ", pessoas, " Idade média: ", media, " Menor: ", menor, " Maior: ", maior, "\n")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 634; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {pessoas, 7, 25, 7}-{maior, 7, 34, 5}-{menor, 7, 41, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */