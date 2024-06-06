programa
{
	inclua biblioteca Arquivos
	inclua biblioteca Util

	const inteiro MODO_LEITURA = 0
	const inteiro MODO_ESCRITA = 1
	const inteiro MODO_ACRESCENTAR = 2

	const cadeia CAMINHO = "D:/Users/t.baiense/Documents/arquivos/meutexto.txt"
	
	funcao inicio()
	{
		inteiro acao, arquivo
		cadeia linha
		logico continuar


		escreva("Bem-vindo\nSelecione a operação (0 LER, 1 ESCRITA, 2 ACRÉSCIMO): ")
		leia(acao)
	
		escolha (acao) {
			caso MODO_LEITURA:
				se (Arquivos.arquivo_existe(CAMINHO)) {
					arquivo = Arquivos.abrir_arquivo(CAMINHO, MODO_LEITURA)
					linha = Arquivos.ler_linha(arquivo)
					Arquivos.fechar_arquivo(arquivo)
					escreva(linha)
				} senao {
					escreva("ERRO: arquivo inexistente. Reiniciando...")
					Util.aguarde(3000)
					limpa()
				}
			
				pare
			caso MODO_ESCRITA:
				escreva("Digite uma linha para inserir no arquivo: ")
				leia(linha)
				arquivo = Arquivos.abrir_arquivo(CAMINHO, MODO_ESCRITA)
				Arquivos.escrever_linha(linha, arquivo)
				Arquivos.fechar_arquivo(arquivo)
				escreva("Arquivo escrito com sucesso!")
				pare
			caso MODO_ACRESCENTAR:
				escreva("Digite o texto que gostaria de acrescentar ao arquivo \n'", CAMINHO, "':\n\n>>> ")
				leia(linha)
				arquivo = Arquivos.abrir_arquivo(CAMINHO, MODO_ACRESCENTAR)
				Arquivos.escrever_linha(linha, arquivo)
				Arquivos.fechar_arquivo(arquivo)
				limpa()
				
				arquivo = Arquivos.abrir_arquivo(CAMINHO, MODO_LEITURA)
				escreva("Conteúdo final do arquivo:\n")
				enquanto (nao Arquivos.fim_arquivo(arquivo)) {
					escreva(Arquivos.ler_linha(arquivo),"\n")
				}
				pare
			caso contrario:
			
				pare
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1588; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */