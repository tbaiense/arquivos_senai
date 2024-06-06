programa
{
	inclua biblioteca Arquivos
	inclua biblioteca Tipos
	inclua biblioteca Util

	const inteiro MODO_LEITURA = 0
	const inteiro MODO_ESCRITA = 1
	const inteiro MODO_ACRESCENTAR = 2

	const inteiro qntColunas = 5
	const inteiro qntLinhas = 5
	const inteiro numMin = 0
	const inteiro numMax = 99

	const cadeia CAMINHO_CARTELA = "./CARTELA_BINGO.txt"
	
	funcao inicio()
	{
		inteiro numGerados[qntLinhas][qntColunas], numAleatorio
		inteiro colunaVerificar = 0, linhaVerificar = 0
		inteiro endArquivoOriginal
		inteiro numMarcar, qntLinhasCartela = 0
		cadeia linhaEscrever
		logico eRepetido, marcarExiste
		inteiro idCartela

		//Preenchimento da matriz
		para (inteiro l = 0; l < qntLinhas; l++) {
			//Checagem e geração de elementos individuais
			para (inteiro c = 0; c < qntColunas; c++) {
				se (c == 0 e l == 0) {
					numGerados[0][0] = Util.sorteia(numMin, numMax)
				} senao {
					//Verifica se o número existe
					faca {
						eRepetido = falso
						numAleatorio = Util.sorteia(numMin, numMax)

						
						se (l == 0) {
							linhaVerificar = l
							colunaVerificar = c-1
						} senao se (l > 0) {
							se (c == 0) {
								linhaVerificar = l-1
								colunaVerificar = qntColunas-1
							} senao se (c > 0) {
								linhaVerificar = l
								colunaVerificar = c-1
							}
							
						}
						
						//Verifica toda a matriz do último número gerado até o primeiro
						para (inteiro l_ = linhaVerificar; l_ >= 0; l_--) {
							para (inteiro c_ = colunaVerificar; c_ >= 0; c_--) {
								se (numGerados[l_][c_] == numAleatorio) {
									eRepetido = verdadeiro
									pare
								}
							}

							se (eRepetido) {
								pare	
							} senao {
								se (l_ > 0) {
									colunaVerificar = qntColunas-1
								}
							}
						}
					} enquanto (eRepetido)
	
					//Atribuição do número disponível
					numGerados[l][c] = numAleatorio
				}
			}
		}

		//Criação do arquivo
		endArquivoOriginal = Arquivos.abrir_arquivo(CAMINHO_CARTELA, MODO_ESCRITA)

		//Escrever parte superior (decoração)
		Arquivos.escrever_linha(" -----------=======|  * BINGO * |=======------------", endArquivoOriginal)
		Arquivos.escrever_linha(" # =============================================== #", endArquivoOriginal)
		idCartela = Util.sorteia(1000, 9999)
		Arquivos.escrever_linha(" # ALUNO: THIAGO MOURA BAIENSE | ID. CARTELA: " + (Tipos.inteiro_para_cadeia(idCartela, 10)) + " #", endArquivoOriginal)
		Arquivos.escrever_linha(" # =============================================== #", endArquivoOriginal)
		Arquivos.escrever_linha(" #                                                 #", endArquivoOriginal)
		
		//Escrever números da matriz no arquivo
		para (inteiro l = 0; l < qntLinhas; l++) {
			Arquivos.escrever_linha(" #  +-------------------------------------------+  #", endArquivoOriginal)
			linhaEscrever = " #  |\t"
			para (inteiro n = 0; n < qntColunas; n++) {
				linhaEscrever += (Tipos.inteiro_para_cadeia(numGerados[l][n], 10) + "\t")
			}
			linhaEscrever += "|  #"
			Arquivos.escrever_linha(linhaEscrever, endArquivoOriginal)
			Arquivos.escrever_linha(" #  +-------------------------------------------+  #", endArquivoOriginal)
		}
		Arquivos.escrever_linha(" #                                                 #", endArquivoOriginal)
		Arquivos.escrever_linha(" -----------=======| ---|~~|--- |=======------------", endArquivoOriginal)
		
		Arquivos.fechar_arquivo(endArquivoOriginal)

		//Exibir arquivo
		endArquivoOriginal = Arquivos.abrir_arquivo(CAMINHO_CARTELA, MODO_LEITURA)
		enquanto (nao Arquivos.fim_arquivo(endArquivoOriginal)) {
			escreva(Arquivos.ler_linha(endArquivoOriginal), "\n")
		}
		Arquivos.fechar_arquivo(endArquivoOriginal)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 358; 
 * @DOBRAMENTO-CODIGO = [28];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {numGerados, 20, 10, 10};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */