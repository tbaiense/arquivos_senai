programa
{
		
	inclua biblioteca Texto
	
	funcao inicio()
	{
		const inteiro numQuestoes = 5
		const inteiro numAlunos = 3
		cadeia nomes[numAlunos]
		inteiro notas[numAlunos]
		cadeia questoes[numQuestoes] 
		cadeia resposta = ""

		//Inserir os gabaritos
		para (inteiro i = 0; i < numQuestoes; i++) {
			escreva("Insira o gabarito da ", i+1, "# questão: ")
			leia(questoes[i])
			questoes[i] = Texto.caixa_alta(questoes[i])
		}
		escreva("\n")

		//Recebe as informações do aluno
		para (inteiro i = 0; i < numAlunos; i++) {
			escreva(i+1, "- Nome:")
			leia(nomes[i])
			para (inteiro j = 0; j < numQuestoes; j++) {
				escreva("\n####", j+1, "- Questão ####\n\n>>> Resposta: ")
				leia(resposta)
				
				se (Texto.caixa_alta(resposta) == questoes[j]) {
					notas[i]+=2
				}
			}
			escreva("\n")
		}

		//Mostra os nomes
		escreva("\n\n ### NOTAS ###\n")
		para (inteiro i = 0; i < numAlunos; i++) {
			escreva("Aluno: ", nomes[i], " (nota: ", notas[i], ")\n")
		}

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 784; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {nomes, 10, 9, 5}-{notas, 11, 10, 5}-{questoes, 12, 9, 8};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */