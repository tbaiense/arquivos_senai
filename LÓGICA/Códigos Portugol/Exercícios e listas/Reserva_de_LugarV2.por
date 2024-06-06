programa
{
	inclua biblioteca Util
	inclua biblioteca Tipos
	
	const inteiro tam = 10
	const inteiro numFileiras = 23
	
	logico assentos[numFileiras][tam]
	inteiro entrada, repetir
	
	funcao inicio()
	{
		//Inicializa a array assentos[]
		para (inteiro i = 0; i < numFileiras; i++) {
			para (inteiro j = 0 < tam; j++) {
				assentos[i][j] = falso //Inicializa os assentos como não-reservados
			}
			
		}
		faca {
			escreva("Bem-vindo ao cinema!\nPara começar, escolha um assento dentre os disponíveis para reservar :\n| Assentos disponíveis -----------------------------------------\n| ")
			
			para (inteiro i = 0; i < numFileiras; i++) {
				para (inteiro j = 0; j < tam; j++) {
					se (assentos[j]) {
						escreva("[--]  ")
					} senao {
						escreva("[")
						escolha (i) {
							caso 0: 
								escreva("A")
								pare
							caso 1:
								escreva("A")
								pare
							caso 2: 
								escreva("A")
								pare
							caso x:
								escreva("A")
								pare
							caso 0: 
								escreva("A")
								pare
							caso x:
								escreva("A")
								pare
							caso 0: 
								escreva("A")
								pare
							caso x:
								escreva("A")
								pare
							caso 0: 
								escreva("A")
								pare
							caso x:
								escreva("A")
								pare
							caso 0: 
								escreva("A")
								pare
							caso x:
								escreva("A")
								pare
							caso 0: 
								escreva("A")
								pare
							caso x:
								escreva("A")
								pare
							caso 0: 
								escreva("A")
								pare
							caso x:
								escreva("A")
								pare
						}
					}
				}
			}

				escreva("\n\n>>> Assento escolhido: ")
				entrada = receberInteiro()
				entrada-- //Acerta o número para procurar na posicao da array
				
				se (entrada > tam-1 ou entrada < 0) { //entrada inválida
					limpa()
					escreva("\n\nAssento inválido! Por favor, escolha outro.\n\n")
					Util.aguarde(1000)
					repetir = 1
				} senao { // entrada valida
					se (nao assentos[entrada]) { //Assento não reservado
						 assentos[entrada] = verdadeiro //Reserva o assento
	
						faca {
							limpa()
							escreva("\n\nO assento escolhido foi reservado! Deseja escolher outro? (1 SIM, 0 NÃO)\n>>> ")
							repetir = receberInteiro()
							se (repetir == -1 ou (repetir != 1 e repetir != 0)) {
								faca {
									se (repetir != 1 ou repetir != 0) {
										escreva("\nOpção inválida! Tente novamente digitando '1' ou '0'.\n>>> ")
										repetir = receberInteiro()
									}
								
								} enquanto (repetir != 1 e repetir != 0)	
							}
						} enquanto (repetir != 1 e repetir != 0)
					
					} senao { //Assento reservado
						limpa()
						escreva("\n\nO assento L", entrada, " já está reservado. Por favor, escolha outro a seguir..." )
						Util.aguarde(1000)
						repetir = 1 //Força o programa a repetir
					}	
				}
				
				limpa()
		} enquanto (repetir == 1)
	}

	funcao inteiro receberInteiro () {
		cadeia inputFuncao
		inteiro resultado

		leia(inputFuncao)
		se (Tipos.cadeia_e_inteiro(inputFuncao, 10)) {
			resultado = Tipos.cadeia_para_inteiro(inputFuncao, 10)
			retorne resultado 
		} senao {
			resultado = -1
			retorne resultado
		}
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 899; 
 * @DOBRAMENTO-CODIGO = [87, 93];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */