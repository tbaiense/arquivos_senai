/*
 * Sistema de gestão de concessionária
 * Autor: Thiago Moura Baiense
 * Turma: DDS-1-19
 * Versão 0.5.8
 * Data: 3 maio, 2024
 * 
 * Descrição:
 * 		Prótipo de sistema de gerenciamento de compra, venda e aluguel de carros para uma concessionária fantasia.
 * 	
 * Funcionamento:
 * 		É utilizada uma variável cadeia para controlar a transição entre as telas do sistema. O conteúdo
 * 	dessa variável, "tela_atual" mudará dependendo das ações do usuário. Dentro da função principal do 
 * 	programa, a informação contida nela direcionará a execução da função responsável por controlar a tela
 * 	desejada. O intuito é viabilizar a portabilidade para uma versão gráfica, que pode ou não existir. :-)
 * 	
 */
programa
{
	inclua biblioteca Arquivos --> arq
	inclua biblioteca Calendario --> cal
	inclua biblioteca Tipos --> tp
	inclua biblioteca Util --> u
	inclua biblioteca Texto --> txt
	inclua biblioteca Matematica --> m

	//Constantes de modo de acesso para o arquivo de operações
	const inteiro MODO_LEITURA = 0, MODO_ESCRITA = 1, MODO_ACRESCENTAR = 2 

	//Variáveis para controle do log
	const cadeia CAMINHO_LOG = "./operacoes.txt"
	inteiro end_log = 0
	const inteiro LOG_VENDA = 0, LOG_ALUGUEL = 1, LOG_COMPRA = 2

	//Variáveis de checagem de erro ou sucesso
	const inteiro MSG_SUCESSO = 0, ERRO_LIMITE_EXCEDIDO = -1, ERRO_CARRO_INEXISTENTE = -2, ERRO_MARCA_INEXISTENTE = -1, ERRO_MODELO_INEXISTENTE= -2, ERRO_DINHEIRO_INSUFICIENTE = -3

	//Variáveis do cliente
	const inteiro QNT_INICIAL_CARROS_CLIENTE = 10
	const inteiro QNT_MAX_CARROS_CLIENTE = 56
	const inteiro QNT_MAX_ALUGADOS = 5
	real dinheiro_cliente = tp.inteiro_para_real(u.sorteia(100000, 1200000))
	inteiro carros_cliente[QNT_MAX_CARROS_CLIENTE][3] //Carros dos cliente, sendo a primeira coluna a marca (linha da tabela fipe), a segunda coluna o modelo do carro (coluna na tabela fipe)
	inteiro carros_alugados[QNT_MAX_ALUGADOS][3] //Carros alugados pelo cliente, sendo a primeira coluna representando a marca (linha da tabela fipe), a segunda coluna representando o modelo do carro (coluna na tabela fipe), e a terceira quantos dias restam de aluguel
	inteiro qnt_carros_cliente = 0
	inteiro qnt_carros_alugados_cliente = 0
	
	//Variáveis da tabela
	const inteiro COLUNA_MARCA = 0, COLUNA_MODELO = 1, COLUNA_ESTOQUE = 2
	const inteiro COLUNA_DIAS_ALUGUEL = 2 //Usada para buscar a coluna de quantos dias restam de alugel na matriz carros_alugados[][]
	const inteiro COLUNA_PRECO = 3, QNT_CARROS_TABELA = 55
	const inteiro QNT_MAX_CARROS_COLUNA_MARCA = 6 // Quantidade máxima de carros de uma mesma marca
	const inteiro QNT_MARCAS = 11, BMW = 0, CHEVROLET = 1, FERRARI = 2, FIAT = 3, FORD = 4, HONDA = 5, HYUNDAI = 6, JEEP = 7, NISSAN = 8, TOYOTA = 9, VOLKSWAGEN = 10
	const real ACRESCIMO_COMPRA = 1.31
	const real DECRESCIMO_VENDA = 0.84
	const real ALUGUEL_POPULAR = 85.0
	const real ALUGUEL_PREMIUM = 120.0
	const real ALUGUEL_LUXO = 200.0

	//Armazena os modelos de carros, separando os carros por marca (linhas)
	cadeia tabela_carros[QNT_MARCAS][QNT_MAX_CARROS_COLUNA_MARCA]
	//Armazena os carros sem a marca
	real tabela_precos[QNT_MARCAS][QNT_MAX_CARROS_COLUNA_MARCA]

	//Variáveis da empresa
	const inteiro QNT_MAX_CARROS_EMPRESA = 56
	const inteiro QNT_INICIAL_CARROS_EMPRESA = 56
	inteiro carros_empresa[QNT_MAX_CARROS_EMPRESA][3] //Armazena os carros disponíveis da empresa |COLUNA_MARCA|POS_MODELO|POS_ESTOQUE
	inteiro qnt_carros_empresa = 0

	//Constantes de escreva e de seleção de matriz para remover e procurar carro
	const inteiro CLIENTE_POSSUI = 0, CLIENTE_ALUGADOS = 1, EMPRESA = 2, ALUGUEL = 3, CLIENTE_VENDER = 4

	//Sistema de telas
	const inteiro T_INICIO = 0, T_COMPRAR = 1, T_VENDER = 2, T_ALUGAR = 3, T_SAIR = -1, OP_VOLTAR = -2, OP_ACEITAR = 1
	inteiro tela_atual = T_INICIO
	
	funcao inicio()
	{
		inteiro marca, modelo
		//Inicialização das informações cruciais
		popular_carros()
		popular_precos()
		sortear_carros_cliente()
		sortear_carros_empresa()
		inicializar_carros_alugados()
		//Exibição da tela inicial
		tela_inicio()
		//Algoritmo de transição entre telas
		faca {
			limpa()
			escolha (tela_atual) {
				caso T_INICIO:
					tela_inicio()
					pare
				caso T_COMPRAR:
					tela_comprar()
					pare
				caso T_VENDER:
					tela_vender()
					pare
				caso T_ALUGAR:
					tela_alugar()
					pare
				caso T_SAIR:
					pare
				caso contrario:
					tela_atual = T_INICIO
			}
		} enquanto (tela_atual != T_SAIR)
		//Exibição da tela de encerramento
		limpa()
		cadeia telaFinal = ""
		telaFinal += " ---------=====|  * FINALIZANDO ! * |=====----------\n"
		telaFinal += " #                                                 #\n"
		telaFinal += " #  +-------------------------------------------+  #\n"
		telaFinal += " #  |	                 A                      |  #\n"
		telaFinal += " #  |	         CONCESSIONÁRIA C&G             |  #\n"
		telaFinal += " #  |	      AGRADECE PELA PREFERÊNCIA.        |  #\n"
		telaFinal += " #  |	       -~=> VOLTE SEMPRE! <=~-          |  #\n"
		telaFinal += " #  +-------------------------------------------+  #\n"
		telaFinal += " #                                                 #\n"
		telaFinal += " # =============================================== #\n"
		telaFinal += " #          $ C&G MANAGEMENT SYSTEM $              #\n"
		telaFinal += " #          |     VERSION: 0.5.7    |              #\n"
		telaFinal += " #          |    (COPYRIGHT 2024)   |              #\n"
		telaFinal += " #          $ ----------------------$              #\n"
		telaFinal += " # =============================================== #\n"
		telaFinal += " #                                                 #\n"
		telaFinal += " #                                                 #\n"
		telaFinal += " -----------=======| ---|~~|--- |=======------------\n"
		escreva(telaFinal)
		u.aguarde(3000)
	}

	//Escolhe QNT_INICIAL_CARROS_CLIENTE carros para o estoque do cliente
	funcao vazio sortear_carros_cliente() {
		inteiro marca_escolhida, modelo_escolhido
		logico eRepetido

		//Algoritmo de sorteio dos carros iniciais do cliente, sendo "carro" a identificação de qual está sendo gerado (refere-se à linha da matriz carros_cliente[][] na qual ele será colocado)
		para (inteiro carro = 0; carro < QNT_INICIAL_CARROS_CLIENTE; carro++) {
			faca {
				//Sorteia um carro para inserir em carros_cliente[][]
				eRepetido = falso
				marca_escolhida = u.sorteia(0, QNT_MARCAS-1)
				modelo_escolhido = u.sorteia(0, QNT_MAX_CARROS_COLUNA_MARCA-1)

				//Verifica se a marca sorteada já foi inserida e se o modelo é repetido
				para (inteiro verificar_carro = 0; verificar_carro < carro; verificar_carro++) {
					se (carros_cliente[verificar_carro][COLUNA_MARCA] == marca_escolhida) {
						se (carros_cliente[verificar_carro][COLUNA_MODELO] == modelo_escolhido) {
							eRepetido = verdadeiro
							pare
						}
					}
				}			
			} enquanto (eRepetido ou (nao (tabela_precos[marca_escolhida][modelo_escolhido] > 0)))

			carros_cliente[carro][COLUNA_MARCA] = marca_escolhida
			carros_cliente[carro][COLUNA_MODELO] = modelo_escolhido
			carros_cliente[carro][COLUNA_ESTOQUE] = 1
		}

		//Preenche o restante dos carros do cliente com -1 pra indicar espaço vazio
		para (inteiro i= QNT_INICIAL_CARROS_CLIENTE; i < QNT_MAX_CARROS_CLIENTE; i++) {
			carros_cliente[i][COLUNA_MARCA] = -1
			carros_cliente[i][COLUNA_MODELO] = -1
		}

		qnt_carros_cliente = QNT_INICIAL_CARROS_CLIENTE
		
		ordenar_marca(carros_cliente, CLIENTE_POSSUI)
		ordenar_modelo(carros_cliente, CLIENTE_POSSUI)
	}
	funcao vazio sortear_carros_empresa() {
		inteiro marca_escolhida, modelo_escolhido
		logico eRepetido

		//Algoritmo de sorteio dos carros iniciais da empresa, sendo "carro" a identificação de qual está sendo gerado (refere-se à linha da matriz carros_empresa[][] na qual ele será colocado)
		para (inteiro carro = 0; carro < QNT_INICIAL_CARROS_EMPRESA; carro++) {
			faca {
				//Sorteia um carro para inserir em carros_empresa[][]
				eRepetido = falso
				marca_escolhida = u.sorteia(0, QNT_MARCAS-1)
				modelo_escolhido = u.sorteia(0, QNT_MAX_CARROS_COLUNA_MARCA-1)

				//Verifica se a marca sorteada já foi inserida e se o modelo é repetido
				para (inteiro verificar_carro = 0; verificar_carro < carro; verificar_carro++) {
					se (carros_empresa[verificar_carro][COLUNA_MARCA] == marca_escolhida) {
						se (carros_empresa[verificar_carro][COLUNA_MODELO] == modelo_escolhido) {
							eRepetido = verdadeiro
							pare
						}
					}
				}			
			} enquanto (eRepetido ou (nao (tabela_precos[marca_escolhida][modelo_escolhido] > 0)))

			carros_empresa[carro][COLUNA_MARCA] = marca_escolhida
			carros_empresa[carro][COLUNA_MODELO] = modelo_escolhido
			carros_empresa[carro][COLUNA_ESTOQUE] = u.sorteia(1, 4)
		}

		//Preenche o restante dos carros da empresa com -1 pra indicar espaço vazio
		para (inteiro i= QNT_INICIAL_CARROS_EMPRESA; i < QNT_MAX_CARROS_EMPRESA; i++) {
			carros_empresa[i][COLUNA_MARCA] = -1
			carros_empresa[i][COLUNA_MODELO] = -1
		}

		qnt_carros_empresa = QNT_INICIAL_CARROS_EMPRESA
		ordenar_marca(carros_empresa, EMPRESA)
		ordenar_modelo(carros_empresa, EMPRESA)
	}
	funcao vazio popular_carros() {
	//Responsável por popular a tabela fipe com os modelos dos carros.
		//BMW
		tabela_carros[0][0] = "1 M"
		tabela_carros[0][1] = "116i"
		tabela_carros[0][2] = "118i"
		tabela_carros[0][3] = "120i"
		tabela_carros[0][4] = "125i"

		//Chevrolet
		tabela_carros[1][0] = "Astra Advantage 2.0"
		tabela_carros[1][1] = "Camaro 6.2 V8"
		tabela_carros[1][2] = "Celta LS 1.0"
		tabela_carros[1][3] = "COBALT LTZ 1.4"
		tabela_carros[1][4] = "CRUZE  LT 1.8"

				//Ferrari
		tabela_carros[2][0] = "F430 4.3"
		tabela_carros[2][1] = "F458 Italia F1 4.5"
		tabela_carros[2][2] = "FF F1 6.3"
		tabela_carros[2][3] = "PORTOFINO M 3.9"
		tabela_carros[2][4] = "SF 90 SPIDER 4.0"

				//Fiat
		tabela_carros[3][0] = "ARGO PRECISION"
		tabela_carros[3][1] = "CRONOS DRIVE 1.8"
		tabela_carros[3][2] = "Siena ELX 1.8"
		tabela_carros[3][3] = "Strada Trekking 1.8"
		tabela_carros[3][4] = "Toro Volcano 2.4"

		//Ford
		tabela_carros[4][0] = "Maverick Lariat Hybrid 2.5 Aut."
		tabela_carros[4][1] = "Mustang GT Performance 5.0 V8"
		tabela_carros[4][2] = "Ranger XL 2.0 4x4"
		tabela_carros[4][3] = "TERRITORY Titanium 1.5"
		tabela_carros[4][4] = "TRANSIT Minibus 15 Lug."

		//Honda
		tabela_carros[5][0] = "CITY Hatchback Touring 1.5"
		tabela_carros[5][1] = "Civic Sed.Touring 2.0"
		tabela_carros[5][2] = "Civic Type-R 2.0"
		tabela_carros[5][3] = "HR-V EXL 1.5"
		tabela_carros[5][4] = "NSX 3.0"

				//Hyundai
		tabela_carros[6][0] = "AZERA GLS 3.3"
		tabela_carros[6][1] = "Creta Ultimate 2.0"
		tabela_carros[6][2] = "HB20S Platinum Plus 1.0"
		tabela_carros[6][3] = "IONIQ 1.6"
		tabela_carros[6][4] = "Tucson GLS 1.6"
		
				//Jeep
		tabela_carros[7][0] = "Commander Longitude T270 1.3"
		tabela_carros[7][1] = "Commander Overland T270 1.3"
		tabela_carros[7][2] = "COMPASS SPORT T270 1.3"
		tabela_carros[7][3] = "Gladiator Rubicon 3.6"
		tabela_carros[7][4] = "Renegade S T270 1.3"

				//Nissan
		tabela_carros[8][0] = "MARCH SV 1.6"
		tabela_carros[8][1] = "GT-R 3.8 V6"
		tabela_carros[8][2] = "KICKS Special Ed.1.6"
		tabela_carros[8][3] = "Pathfinder SE 4.0"
		tabela_carros[8][4] = "X-TRAIL LE 2.0"

				//Toyota
		tabela_carros[9][0] = "COROLLA CROSS 2.0"
		tabela_carros[9][1] = "Corolla XEi 1.8"
		tabela_carros[9][2] = "ETIOS X Plus 1.5"
		tabela_carros[9][3] = "Hilux Chassi 4x4 2.8"
		tabela_carros[9][4] = "Hilux SW4 SRX 4x4 2.8"

				//VolksWagen
		tabela_carros[10][0] = "AMAROK Highline CD 3.0"
		tabela_carros[10][1] = "Gol 1.0 Flex 12V"
		tabela_carros[10][2] = "JETTA GLI 350 TSI 2.0"
		tabela_carros[10][3] = "Polo 1.0 TSI"
		tabela_carros[10][4] = "Saveiro Trendline 1.6"
		tabela_carros[10][5] = "VIRTUS Highline 200 TSI 1.0"
	}
	funcao vazio popular_precos() {
	//Responsável por popular a tabela fipe de preços dos carros. Ao inserir um novo preço, é necessário alterar as constantes relacionada para garantir o funcionamento do programa
		//BMW
		tabela_precos[0][0] = 675000.00
		tabela_precos[0][1] = 125780.00
		tabela_precos[0][2] = 219689.00
		tabela_precos[0][3] = 180500.00
		tabela_precos[0][4] = 220300.00

		//Chevrolet
		tabela_precos[1][0] = 35783.00
		tabela_precos[1][1] = 363036.00
		tabela_precos[1][2] = 26900.00
		tabela_precos[1][3] = 54481.00
		tabela_precos[1][4] = 57895.00

		//Ferrari
		tabela_precos[2][0] = 1299900.00
		tabela_precos[2][1] = 2523700.00
		tabela_precos[2][2] = 3025090.00
		tabela_precos[2][3] = 3394500.00
		tabela_precos[2][4] = 6594430.00

		//Fiat
		tabela_precos[3][0] = 67743.00
		tabela_precos[3][1] = 78017.00
		tabela_precos[3][2] = 16219.00
		tabela_precos[3][3] = 37891.00
		tabela_precos[3][4] = 125353.00

		//Ford
		tabela_precos[4][0] = 231030.00
		tabela_precos[4][1] = 529001.00
		tabela_precos[4][2] = 218326.00
		tabela_precos[4][3] = 200774.00
		tabela_precos[4][4] = 307457.00

		//Honda
		tabela_precos[5][0] = 126463.00
		tabela_precos[5][1] = 265728.00
		tabela_precos[5][2] = 419152.00
		tabela_precos[5][3] = 158028.00
		tabela_precos[5][4] = 300000.00

		//Hyundai
		tabela_precos[6][0] = 44252.00
		tabela_precos[6][1] = 184690.00
		tabela_precos[6][2] = 104681.00
		tabela_precos[6][3] = 144230.00
		tabela_precos[6][4] = 166380.00

		//Jeep
		tabela_precos[7][0] = 223140.00
		tabela_precos[7][1] = 223477.00
		tabela_precos[7][2] = 137745.00
		tabela_precos[7][3] = 396201.00
		tabela_precos[7][4] = 150437.00

		//Nissan
		tabela_precos[8][0] = 41250.00
		tabela_precos[8][1] = 1206570.00
		tabela_precos[8][2] = 82871.00
		tabela_precos[8][3] = 63653.00
		tabela_precos[8][4] = 45162.00

		//Toyota
		tabela_precos[9][0] = 176696.00
		tabela_precos[9][1] = 50476.00
		tabela_precos[9][2] = 71629.00
		tabela_precos[9][3] = 202937.00
		tabela_precos[9][4] = 346544.00

		//VolksWagen
		tabela_precos[10][0] = 238613.00
		tabela_precos[10][1] = 76388.00
		tabela_precos[10][2] = 224148.00
		tabela_precos[10][3] = 88515.00
		tabela_precos[10][4] = 95546.00
		tabela_precos[10][5] = 125386.00

	}
	funcao vazio inicializar_carros_alugados() {
		para (inteiro c = 0; c < QNT_MAX_ALUGADOS; c++) {
			carros_alugados[c][COLUNA_MARCA] = -1
			carros_alugados[c][COLUNA_MODELO] = -1
			carros_alugados[c][COLUNA_DIAS_ALUGUEL] = -1
		}
	}
	funcao cadeia info_carro(inteiro marca, inteiro modelo) {

		cadeia texto = "|", textoMarca
		textoMarca = nome_marca(marca)
		textoMarca = txt.preencher_a_esquerda(' ', 9, textoMarca)
		texto += textoMarca + txt.preencher_a_esquerda(' ', 8,("(" + tp.inteiro_para_cadeia(marca, 10) + ") | ")) + tabela_carros[marca][modelo] + txt.preencher_a_esquerda(' ', 11,("(" + tp.inteiro_para_cadeia(modelo, 10) + ") | R$ ")) + tabela_precos[marca][modelo] * ACRESCIMO_COMPRA + "\n"
		retorne texto
	}
	funcao cadeia nome_marca(inteiro marca) {
		cadeia textoMarca = ""
		
		escolha (marca) {
			caso BMW:
				textoMarca = "BMW"
				pare
			caso CHEVROLET:
				textoMarca = "CHEV."
				pare
			caso FERRARI:
				textoMarca = "FERRARI"
				pare
			caso FIAT:
				textoMarca = "FIAT"
				pare
			caso FORD:
				textoMarca = "FORD"
				pare
			caso HONDA:
				textoMarca = "HONDA"
				pare
			caso HYUNDAI:
				textoMarca = "HYUNDAI"
				pare
			caso JEEP:
				textoMarca = "JEEP"
				pare
			caso NISSAN:
				textoMarca = "NISSAN"
				pare
			caso TOYOTA:
				textoMarca = "TOYOTA"
				pare
			caso VOLKSWAGEN:
				textoMarca = "VOLKSW"
				pare
			caso contrario:
				textoMarca = "MARCA INVÁLIDA"
		}

		retorne textoMarca
	}
	funcao cadeia carros(inteiro matriz) {
	//Responsável por retornar a lista de carros de determinada matriz, contendo o estoque, a marca e o modelo. Usada na tela inicial.
		cadeia tabelaCarros = ""
		inteiro estoque = 0, marca = 0, modelo = 0, dias = 0
		
		inteiro linha = 0 //Variável de controle para o loop "enquanto" de verificação do carro a ser exibido
		escolha (matriz) {
			caso CLIENTE_POSSUI:
				tabelaCarros += "-------------------------------------------------\n"
				tabelaCarros += "<~~~~~-----======< MEUS CARROS >======-----~~~~~>\n"
				tabelaCarros += "-------------------------------------------------\n"
				tabelaCarros += " EST. |   MARCA  | MODELO\n"
				tabelaCarros += "-------------------------------------------------\n"
				enquanto (linha < qnt_carros_cliente) {
					estoque = carros_cliente[linha][COLUNA_ESTOQUE]
					marca = carros_cliente[linha][COLUNA_MARCA]
					modelo = carros_cliente[linha][COLUNA_MODELO]
					tabelaCarros += " " + txt.preencher_a_esquerda(' ', 3, tp.inteiro_para_cadeia(estoque, 10)) + "x |" + txt.preencher_a_esquerda(' ', 9, nome_marca(marca)) + " | " + tabela_carros[marca][modelo] + "\n"
					linha++
				}
				se (linha == 0) {tabelaCarros += "\n\n~ Você não tem nenhum carro em sua posse... ~\n\n"} 
				tabelaCarros += "-------------------------------------------------\n\n"
				pare
			caso CLIENTE_ALUGADOS:
				tabelaCarros += "-----------------------------------------------------\n"
				tabelaCarros += "<~~~-------======< CARROS ALUGADOS >======-------~~~>\n"
				tabelaCarros += "-----------------------------------------------------\n"
				tabelaCarros += "   MARCA  |            MODELO                | DIAS\n"
				tabelaCarros += "-----------------------------------------------------\n"
				enquanto (linha < qnt_carros_alugados_cliente) {
					dias = carros_alugados[linha][COLUNA_DIAS_ALUGUEL]
					marca = carros_alugados[linha][COLUNA_MARCA]
					modelo = carros_alugados[linha][COLUNA_MODELO]
					tabelaCarros += txt.preencher_a_esquerda(' ', 9, nome_marca(marca)) + " | " + txt.preencher_a_esquerda(' ', 32, tabela_carros[marca][modelo]) + " | " + txt.preencher_a_esquerda(' ', 2, tp.inteiro_para_cadeia(carros_alugados[linha][COLUNA_DIAS_ALUGUEL], 10)) + "\n"
					linha++
				}
				tabelaCarros += "-----------------------------------------------------\n\n"
				pare
			caso EMPRESA:
				tabelaCarros += "-------------------------------------------------------\n"
				tabelaCarros += "<~~~~~-----=======< CARROS À VENDA! >=======-----~~~~~>\n"
				tabelaCarros += "-------------------------------------------------------\n"
				tabelaCarros += " NUM | EST.|   MARCA  | MODELO\n"
				tabelaCarros += "-------------------------------------------------------\n"
				enquanto (linha < qnt_carros_empresa) {
					estoque = carros_empresa[linha][COLUNA_ESTOQUE]
					marca = carros_empresa[linha][COLUNA_MARCA]
					modelo = carros_empresa[linha][COLUNA_MODELO]
					tabelaCarros += " " + txt.preencher_a_esquerda(' ', 4,(linha+1) + ") ") + "|" + txt.preencher_a_esquerda(' ', 3, tp.inteiro_para_cadeia(estoque, 10)) + "x |" + txt.preencher_a_esquerda(' ', 9, nome_marca(marca)) + " | " + tabela_carros[marca][modelo] + "\n"
					linha++
				}
				tabelaCarros += "-------------------------------------------------------\n"
				
				pare
			caso contrario:
				escreva("ERRO")
		}

		retorne tabelaCarros
	}
	funcao cadeia carros_marca(inteiro marca, inteiro matriz) {
	//Retorna a cadeia com a lista dos carros referentes às matrizes selecioandas como argumento, exibindo o número da marca para seleção nos modos de venda, aluguel e compra, o estoque e o modelo.
		cadeia tabelaCarros = ""
		inteiro estoque = 0, modelo = 0, dias = 0, carrosExibidos = 0
		
		inteiro linha = 0 //Variável de controle para o loop "enquanto" de verificação do carro a ser exibido
		escolha (matriz) {
			caso CLIENTE_VENDER:
				tabelaCarros += "-------------------------------------------------\n"
				tabelaCarros += "<~~~~~-----======< MEUS CARROS >======-----~~~~~>\n"
				tabelaCarros += "-------------------------------------------------\n"
				tabelaCarros += " NUM | EST.| MODELO\n"
				tabelaCarros += "-------------------------------------------------\n"
				enquanto (linha < qnt_carros_cliente) {
					se (carros_cliente[linha][COLUNA_MARCA] == marca) {
							estoque = carros_cliente[linha][COLUNA_ESTOQUE]
							marca = carros_cliente[linha][COLUNA_MARCA]
							modelo = carros_cliente[linha][COLUNA_MODELO]
							tabelaCarros += " " + txt.preencher_a_esquerda(' ', 4,(modelo+1) + ") ") + "|" + txt.preencher_a_esquerda(' ', 3, tp.inteiro_para_cadeia(estoque, 10)) + "x | " + tabela_carros[marca][modelo] + "\n"
							carrosExibidos++
					}
					linha++
				}

				se (carrosExibidos == 0) {
					tabelaCarros += "\n\n+~-~+ Não há carros disponíveis desta marca +~-~+\n\n"
				}
				tabelaCarros += "-------------------------------------------------------\n"
				pare
				
			caso EMPRESA:
				tabelaCarros += "-------------------------------------------------------\n"
				tabelaCarros += "<~~~~~-----=======< CARROS À VENDA! >=======-----~~~~~>\n"
				tabelaCarros += "-------------------------------------------------------\n"
				tabelaCarros += " NUM | EST.| MODELO\n"
				tabelaCarros += "-------------------------------------------------------\n"
				enquanto (linha < qnt_carros_empresa) {
					se (carros_empresa[linha][COLUNA_MARCA] == marca) {
							estoque = carros_empresa[linha][COLUNA_ESTOQUE]
							marca = carros_empresa[linha][COLUNA_MARCA]
							modelo = carros_empresa[linha][COLUNA_MODELO]
							tabelaCarros += " " + txt.preencher_a_esquerda(' ', 4,(modelo+1) + ") ") + "|" + txt.preencher_a_esquerda(' ', 3, tp.inteiro_para_cadeia(estoque, 10)) + "x | " + tabela_carros[marca][modelo] + "\n"
							carrosExibidos++
					}
					linha++
				}

				se (carrosExibidos == 0) {
					tabelaCarros += "\n\n+~-~+ Não há carros disponíveis desta marca +~-~+\n\n"
				}
				tabelaCarros += "-------------------------------------------------------\n"
				
				pare

			caso ALUGUEL:
				tabelaCarros += "-------------------------------------------------------\n"
				tabelaCarros += "<~~~~~-----=====< CARROS PARA ALUGUEL >=====-----~~~~~>\n"
				tabelaCarros += "-------------------------------------------------------\n"
				tabelaCarros += " NUM | EST.| MODELO\n"
				tabelaCarros += "-------------------------------------------------------\n"
				enquanto (linha < qnt_carros_empresa) {
					se (carros_empresa[linha][COLUNA_MARCA] == marca) {
							estoque = carros_empresa[linha][COLUNA_ESTOQUE]
							marca = carros_empresa[linha][COLUNA_MARCA]
							modelo = carros_empresa[linha][COLUNA_MODELO]
							tabelaCarros += " " + txt.preencher_a_esquerda(' ', 4,(modelo+1) + ") ") + "|" + txt.preencher_a_esquerda(' ', 3, tp.inteiro_para_cadeia(estoque, 10)) + "x | " + tabela_carros[marca][modelo] + "\n"
							carrosExibidos++
					}
					linha++
				}

				se (carrosExibidos == 0) {
					tabelaCarros += "\n\n+~-~+ Não há carros disponíveis desta marca +~-~+\n\n"
				}
				tabelaCarros += "-------------------------------------------------------\n"
				
				pare
			caso contrario:
				escreva("ERRO")
		}

		retorne tabelaCarros
	}
	funcao inteiro cliente_compra(inteiro marca, inteiro modelo) {
	//Função responsável pelas operações de compra. Realiza as checagens relacionadas ao dinheiro, ao limite de carros e se o carro existe na matriz selecionada como argumento.
		inteiro linhaCarroEmpresa = 0 //Linha em que o carro se encontra na matriz carros_empresa[][]
		inteiro linhaCarroCliente = 0
		real precoFinal = 0.0
		
		//Procura o carro na tabela do cliente para saber se ele já está adicionado ou não
		linhaCarroCliente = procurar_carro(marca, modelo, CLIENTE_POSSUI)
		
		//Verifica se o número máximo de carros do cliente não foi excedido
		se (qnt_carros_cliente >= QNT_MAX_CARROS_CLIENTE e linhaCarroCliente == ERRO_CARRO_INEXISTENTE) {
			retorne ERRO_LIMITE_EXCEDIDO //Código de erro para limite excedido
		} senao {
			//Retorna a linha do carro na matriz da empresa caso encontre. Se não o valor será ERRO_CARRO_INEXISTENTE (-2) 
			linhaCarroEmpresa = procurar_carro(marca, modelo, EMPRESA)
	
			//Gerencia o carro na matriz do cliente e da empresa
			se (linhaCarroEmpresa == ERRO_CARRO_INEXISTENTE) { 
				retorne ERRO_CARRO_INEXISTENTE
				
			//Situação em que o carro existe na matriz da empresa
			} senao {
				precoFinal = tabela_precos[marca][modelo] * ACRESCIMO_COMPRA

				// Debita o valor do carro no dinheiro do cliente
				se (dinheiro_cliente < precoFinal) {
					retorne ERRO_DINHEIRO_INSUFICIENTE
				}
				
				dinheiro_cliente -= precoFinal
				escrever_log(LOG_COMPRA, marca, modelo, precoFinal, 0)
				
				//Situação em que o carro não existe na matriz do cliente e deve ser adicionado
				se (linhaCarroCliente == ERRO_CARRO_INEXISTENTE) {
				 	linhaCarroCliente = qnt_carros_cliente //Determina a linha em que o carro deverá ser inserido (última vaga)
				 	carros_cliente[linhaCarroCliente][COLUNA_ESTOQUE] = 1

					//Insere o carro em questão na linha selecionada
					carros_cliente[linhaCarroCliente][COLUNA_MARCA] = carros_empresa[linhaCarroEmpresa][COLUNA_MARCA]
					carros_cliente[linhaCarroCliente][COLUNA_MODELO] = carros_empresa[linhaCarroEmpresa][COLUNA_MODELO]

					qnt_carros_cliente++
					ordenar_marca(carros_cliente, CLIENTE_POSSUI)
					ordenar_modelo(carros_cliente, CLIENTE_POSSUI)
				//Carro existe na matriz do cliente e o estoque deve ser incrementado
				} senao { 
				 	carros_cliente[linhaCarroCliente][COLUNA_ESTOQUE]++
				}

				//Verifica se o carro no estoque da empresa é o ultimo ou nao para decrementar ou retirá-lo da lista
				se (carros_empresa[linhaCarroEmpresa][COLUNA_ESTOQUE] <= 1) {
					remover_carro(linhaCarroEmpresa, EMPRESA)
					retorne MSG_SUCESSO
				} senao {
					carros_empresa[linhaCarroEmpresa][COLUNA_ESTOQUE]--
					retorne MSG_SUCESSO
				}
			}
		}

	}
	funcao inteiro cliente_vende(inteiro marca, inteiro modelo) {
	//Função responsável pelas operações de venda. Realiza as checagens relacionadas ao dinheiro, ao limite de carros e se o carro existe na matriz selecionada como argumento.
		inteiro linhaCarroEmpresa = 0 //Linha em que o carro se encontra na matriz carros_empresa[][]
		inteiro linhaCarroCliente = 0
		real precoFinal = 0.0

		//Procura o carro na tabela da empresa para saber se ele já está adicionado ou não
		linhaCarroEmpresa = procurar_carro(marca, modelo, EMPRESA)
		
		//Verifica se o número máximo de carros da empresa não foi excedido
		se (qnt_carros_empresa >= QNT_MAX_CARROS_EMPRESA e linhaCarroEmpresa == ERRO_CARRO_INEXISTENTE) {
			retorne ERRO_LIMITE_EXCEDIDO //Código de erro para limite excedido
		} senao {
			//Retorna a linha do carro na matriz da empresa caso encontre. Se não o valor será ERRO_CARRO_INEXISTENTE (-2) 
			linhaCarroCliente = procurar_carro(marca, modelo, CLIENTE_POSSUI)
	
			//Gerencia o carro na matriz do cliente e da empresa
			se (linhaCarroCliente == ERRO_CARRO_INEXISTENTE) { 
				retorne ERRO_CARRO_INEXISTENTE
				
			//Situação em que o carro existe na matriz do cliente
			} senao {
				precoFinal = tabela_precos[marca][modelo] * DECRESCIMO_VENDA
				dinheiro_cliente += precoFinal
				escrever_log(LOG_VENDA, marca, modelo, precoFinal, 0)
				
				//Situação em que o carro não existe na matriz da empresa e deve ser adicionado
				se (linhaCarroEmpresa == ERRO_CARRO_INEXISTENTE) {
				 	linhaCarroEmpresa = qnt_carros_empresa //Determina a linha em que o carro deverá ser inserido (última vaga)
				 	carros_empresa[linhaCarroEmpresa][COLUNA_ESTOQUE] = 1

					//Insere o carro em questão na linha selecionada
					carros_empresa[linhaCarroEmpresa][COLUNA_MARCA] = carros_cliente[linhaCarroCliente][COLUNA_MARCA]
					carros_empresa[linhaCarroEmpresa][COLUNA_MODELO] = carros_cliente[linhaCarroCliente][COLUNA_MODELO]

					qnt_carros_empresa++
					ordenar_marca(carros_empresa, EMPRESA)
					ordenar_modelo(carros_empresa, EMPRESA)
				//Carro existe na matriz da empresa e o estoque deve ser incrementado
				} senao { 
				 	carros_empresa[linhaCarroEmpresa][COLUNA_ESTOQUE]++
				}
				
				//Verifica se o carro no estoque do cliente é o ultimo ou nao para decrementar ou retirá-lo da lista
				se (carros_cliente[linhaCarroCliente][COLUNA_ESTOQUE] <= 1) {
					remover_carro(linhaCarroCliente, CLIENTE_POSSUI)
					retorne MSG_SUCESSO
				} senao {
					carros_cliente[linhaCarroCliente][COLUNA_ESTOQUE]--
					retorne MSG_SUCESSO
				}
			}
		}

	}
	funcao inteiro cliente_aluga(inteiro marca, inteiro modelo, inteiro dias) {
	//Função responsável pelas operações de aluguel. Realiza as checagens relacionadas ao dinheiro, ao limite de carros e se o carro existe na matriz selecionada como argumento.
		
		inteiro linhaCarroEmpresa = 0 //Linha em que o carro se encontra na matriz carros_empresa[][]
		inteiro linhaCarroAluguel = 0
		real precoFinal = 0.0
		
		//Verifica se o número máximo de carros alugados pelo cliente não foi excedido
		se (qnt_carros_alugados_cliente >= QNT_MAX_ALUGADOS) {
			retorne ERRO_LIMITE_EXCEDIDO //Código de erro para limite excedido
		} senao {
			//Retorna a linha do carro na matriz da empresa caso encontre. Se não o valor será ERRO_CARRO_INEXISTENTE (-2) 
			linhaCarroEmpresa = procurar_carro(marca, modelo, EMPRESA)
	
			//Gerencia o carro na matriz do cliente e da empresa
			se (linhaCarroEmpresa == ERRO_CARRO_INEXISTENTE) { 
				retorne ERRO_CARRO_INEXISTENTE
				
			//Situação em que o carro existe na matriz da empresa
			} senao {
					precoFinal = valor_aluguel(marca, modelo) * dias
					se (dinheiro_cliente < precoFinal) {
						retorne ERRO_DINHEIRO_INSUFICIENTE
					}
					
					escrever_log(LOG_ALUGUEL, marca, modelo, precoFinal, dias)
					dinheiro_cliente -= precoFinal
				 	linhaCarroAluguel = qnt_carros_alugados_cliente //Determina a linha em que o carro deverá ser inserido (última vaga)
					
					//Insere o carro em questão na linha selecionada
					carros_alugados[linhaCarroAluguel][COLUNA_MARCA] = carros_empresa[linhaCarroEmpresa][COLUNA_MARCA]
					carros_alugados[linhaCarroAluguel][COLUNA_MODELO] = carros_empresa[linhaCarroEmpresa][COLUNA_MODELO]
					carros_alugados[linhaCarroAluguel][COLUNA_DIAS_ALUGUEL] = dias

					qnt_carros_alugados_cliente++
					ordenar_marca(carros_cliente, CLIENTE_POSSUI)
					ordenar_modelo(carros_cliente, CLIENTE_POSSUI)
				//Verifica se o carro no estoque da empresa é o ultimo ou nao para decrementar ou retirá-lo da lista
				se (carros_empresa[linhaCarroEmpresa][COLUNA_ESTOQUE] <= 1) {
					remover_carro(linhaCarroEmpresa, EMPRESA)
					retorne MSG_SUCESSO
				} senao {
					carros_empresa[linhaCarroEmpresa][COLUNA_ESTOQUE]--
					retorne MSG_SUCESSO
				}
			}
		}

	}
	funcao vazio escrever_log(inteiro tipo_log, inteiro marca, inteiro modelo, real preco_log, inteiro dias_aluguel_log) {
	/*Adiciona entrada no arquivo de log com base no tipo de log (venda, alugel, compra), 
	 * qual o carro em questão, o preço da operação e a quantidade de dias de aluguel (n/a = 0)
	 */
		/* FORMATO DO LOG
		|[25/12/2024] --------------------------------------------------------------------
		| 18h:45min:16s > [VENDA] Chevrolet, Onix Turbo 1.6 (R$ 55000.35)
		|________________________________________________________________________________
		 */
		inteiro dia_log = cal.dia_mes_atual()
		inteiro mes_log = cal.mes_atual()
		inteiro ano_log = cal.ano_atual()
		inteiro hora_log = cal.hora_atual(falso)
		inteiro minuto_log = cal.minuto_atual()
		inteiro segundo_log = cal.segundo_atual()

		cadeia cabecalho = "|[" + dia_log + "/" + mes_log + "/" + ano_log + "] -----------------------------------------------------------------------------------------------------"
		cadeia info = "| " + hora_log + "h:" + minuto_log + "min:" + segundo_log + "s > "
		cadeia rodape = "|_________________________________________________________________________________________________________________"

		//Define a identificação da linha de informação do log
		escolha (tipo_log) {
			caso LOG_ALUGUEL:
				info += "[ALUGUEL] "
				pare
			caso LOG_COMPRA:
				info += "[COMPRA] "
				pare
			caso LOG_VENDA:
				info += "[VENDA] "
				pare
			caso contrario:
				info += "[TIPO DESCONHECIDO] "
				pare
		}

		//TODO: Descreve o carro no log
		info += nome_marca(marca) + ", " + tabela_carros[marca][modelo]

		//Descreve o preço relacionado à operação
		info += " (R$ " + preco_log + ") "

		se (dias_aluguel_log > 0) {
			info += "[" + dias_aluguel_log + " DIAS]"
		}
		
		end_log = arq.abrir_arquivo(CAMINHO_LOG, MODO_ACRESCENTAR)
		arq.escrever_linha(cabecalho, end_log)
		arq.escrever_linha(info, end_log)
		arq.escrever_linha(rodape, end_log)
		arq.escrever_linha("", end_log)
		arq.fechar_arquivo(end_log)
	}
	funcao inteiro procurar_carro(inteiro marca, inteiro modelo, inteiro matriz) {
	/*Funcao que retorna a linha do veículo na matriz selecionada,
	  caso exista. Se não existir, retorna ERRO_CARRO_INEXISTENTE (-2)

	  valores possíveis para matriz:
	  	- CLIENTE_POSSUI = 0
	  	- CLIENTE_ALUGADOS = 1
	  	- EMPRESA = 2
	  */
	  	
	  	logico carroExisteCliente = falso
	  	logico carroExisteAluguel = falso
	  	logico carroExisteEmpresa = falso
		inteiro linhaCarroEmpresa = 0
		inteiro linhaCarroCliente = 0
		inteiro linhaCarroAluguel = 0

		
		//Usa o parâmetro matriz pra definir em qual matriz o carro será buscado	
		escolha (matriz) {
			//CLIENTE_POSSUI
			caso 0: 
				se (qnt_carros_cliente > 0) {
					//Verifica se o carro já existe na matriz do cliente
					para (inteiro i = 0; i < qnt_carros_cliente; i++) {
						se (carros_cliente[i][COLUNA_MARCA] == marca) {
							se (carros_cliente[i][COLUNA_MODELO] == modelo) {
								linhaCarroCliente = i
								carroExisteCliente = verdadeiro
								pare
							}
						}
					}
				}
				pare
			//CLIENTE_ALUGADOS
			caso 1:
				se (qnt_carros_alugados_cliente > 0) {
					//Verifica se o carro já existe na matriz de alugados do cliente
					para (inteiro i = 0; i < qnt_carros_alugados_cliente; i++) {
						se (carros_alugados[i][COLUNA_MARCA] == marca) {
							se (carros_alugados[i][COLUNA_MODELO] == modelo) {
								linhaCarroAluguel = i
								carroExisteAluguel = verdadeiro
								pare
							}
						}
					}
				}
				pare
			//EMPRESA
			caso 2:
				se (qnt_carros_empresa > 0) {
					//Verifica se o carro já existe na matriz da empresa
					para (inteiro i = 0; i < qnt_carros_empresa; i++) {
						se (carros_empresa[i][COLUNA_MARCA] == marca) {
							se (carros_empresa[i][COLUNA_MODELO] == modelo) {
								linhaCarroEmpresa = i
								carroExisteEmpresa = verdadeiro
								pare
							}
						}
					}
				}
				pare
			caso contrario:
				escreva("ERRO!")
				pare
		}

		se (carroExisteCliente) {
			retorne linhaCarroCliente 
		} senao se (carroExisteAluguel) {
			retorne linhaCarroAluguel
		} senao se (carroExisteEmpresa) {
			retorne linhaCarroEmpresa
		} senao {
			retorne ERRO_CARRO_INEXISTENTE
		}
	}
	funcao vazio remover_carro(inteiro linha, inteiro matriz) {
	// Funçao responsável por retirar os carros das matrizes e reorganizá-las
		escolha (matriz) {
			caso EMPRESA:
				para (inteiro l = linha; l < qnt_carros_empresa-1; l++) {
					carros_empresa[l][COLUNA_MARCA] = carros_empresa[l+1][COLUNA_MARCA]
					carros_empresa[l][COLUNA_MODELO] = carros_empresa[l+1][COLUNA_MODELO]
					carros_empresa[l][COLUNA_ESTOQUE] = carros_empresa[l+1][COLUNA_ESTOQUE]
				}
				qnt_carros_empresa--
				
				carros_empresa[qnt_carros_empresa][COLUNA_MARCA] = -1
				carros_empresa[qnt_carros_empresa][COLUNA_MODELO] = -1
				carros_empresa[qnt_carros_empresa][COLUNA_ESTOQUE] = -1
				pare

			caso CLIENTE_POSSUI:
				para (inteiro l = linha; l < qnt_carros_cliente-1; l++) {
					carros_cliente[l][COLUNA_MARCA] = carros_cliente[l+1][COLUNA_MARCA]
					carros_cliente[l][COLUNA_MODELO] = carros_cliente[l+1][COLUNA_MODELO]
					carros_cliente[l][COLUNA_ESTOQUE] = carros_cliente[l+1][COLUNA_ESTOQUE]
				}
				qnt_carros_cliente--
				
				carros_cliente[qnt_carros_cliente][COLUNA_MARCA] = -1
				carros_cliente[qnt_carros_cliente][COLUNA_MODELO] = -1
				carros_cliente[qnt_carros_cliente][COLUNA_ESTOQUE] = -1
				pare

			caso CLIENTE_ALUGADOS:
				para (inteiro l = linha; l < qnt_carros_alugados_cliente-1; l++) {
					carros_alugados[l][COLUNA_MARCA] = carros_alugados[l+1][COLUNA_MARCA]
					carros_alugados[l][COLUNA_MODELO] = carros_alugados[l+1][COLUNA_MODELO]
					carros_alugados[l][COLUNA_ESTOQUE] = carros_alugados[l+1][COLUNA_ESTOQUE]
				}
				qnt_carros_alugados_cliente--
				
				carros_alugados[qnt_carros_alugados_cliente][COLUNA_MARCA] = -1
				carros_alugados[qnt_carros_alugados_cliente][COLUNA_MODELO] = -1
				carros_alugados[qnt_carros_alugados_cliente][COLUNA_ESTOQUE] = -1
				pare
			caso contrario:
				escreva("ERRO REMOVER CARRO")
		}
	}
	funcao real valor_aluguel(inteiro marca, inteiro modelo) {
	//Calcula o valor do aluguel de um veículo
		se (tabela_precos[marca][modelo] <= 80000.0) {
			retorne ALUGUEL_POPULAR
		} senao se (tabela_precos[marca][modelo] <= 200000.0) {
			retorne ALUGUEL_PREMIUM
		} senao {
			retorne ALUGUEL_LUXO
		}
		
	}
	funcao inteiro receber_entrada(inteiro inicial, inteiro final, cadeia informacao) {
	// Função responsável por tratar todas as entradas do programa recebendo um valor num intervalo entre inicial e final, além de mostrar a tela respectiva à entrada por meio da cadeia "informacao"
		
		cadeia entradaNaoTrat
		inteiro entradaTrat = 0
		logico entradaInvalida

		faca {
			//Recebe a entrada como cadeia, para fazer as checagens e depois converter para inteiro
			escreva(informacao)
			leia(entradaNaoTrat)

			//Garante que a entrada não é vazia (uma entrada vazia quebra a função de checagem se é inteiro)
			se (txt.numero_caracteres(entradaNaoTrat) == 0) {
				entradaInvalida = verdadeiro
			} senao {
				se (tp.cadeia_e_inteiro(entradaNaoTrat, 10)) {
					//Garante que a entrada está entre o intervalo definido
					se (tp.cadeia_para_inteiro(entradaNaoTrat, 10) >= inicial e tp.cadeia_para_inteiro(entradaNaoTrat, 10) <= final) {
						entradaInvalida = falso
						entradaTrat = tp.cadeia_para_inteiro(entradaNaoTrat, 10) //Converte a entrada para inteiro
						pare
					} senao {
						entradaInvalida = verdadeiro
					}
				} senao { //Se a entrada não for um número, recebe uma opção de escolha (útil para recusar ou aceitar uma proposta)
					caracter op = txt.obter_caracter(txt.caixa_alta(entradaNaoTrat),0)
					escolha (op) {
						caso 'V':
							retorne OP_VOLTAR
						caso 'N':
							se (inicial == 0 e final == 0) {
								retorne OP_VOLTAR
							} senao {
								entradaInvalida = verdadeiro
							}
						caso 'S':
							se (inicial == 0 e final == 0) {
								retorne OP_ACEITAR
							} senao {
								entradaInvalida = verdadeiro
							}
							pare
						caso contrario:
							entradaInvalida = verdadeiro
					}
				}
			}
			
			limpa()
			se (entradaInvalida == verdadeiro) {
				escreva("ERRO: OPÇÃO INVÁLIDA. TENTE NOVAMENTE...\n\n")
				u.aguarde(2500)
				limpa()
			}
		} enquanto (entradaInvalida)
		retorne entradaTrat
	}
	funcao vazio ordenar_marca(inteiro &matriz[][], inteiro infoMatriz) {
	/* Ordena a matriz especificada com as constantes CARROS_CLIENTE_POSSUI, EMPRESA, CLIENTE_ALUGADOS, ALUGUEL, CLIENTE_VENDER.
	 *  Primeiro, ordena agrupando carros de marcas iguais em linhas próximas
	 *  Segundo, ordena os grupos de carros da mesma marca em ordem crescente de número de modelo
	 */
		
		inteiro qntCarros = 0//Responsável por controlar laços de repetição de ordenação
		inteiro posMenor, copia[3] //Variáveis de ordenação
		inteiro linhaInicial= 0, linhaFinal= 0
		//Determina o valor para variável `qntCarros`
		escolha (infoMatriz) {
			caso ALUGUEL:
				qntCarros = qnt_carros_empresa
				pare
			caso EMPRESA:
				qntCarros = qnt_carros_empresa
				pare
			caso CLIENTE_VENDER:
				qntCarros = qnt_carros_cliente
				pare	
			caso CLIENTE_POSSUI:
				qntCarros = qnt_carros_cliente
				pare
			caso CLIENTE_ALUGADOS:
				qntCarros = qnt_carros_alugados_cliente
				pare	
			caso contrario:
				escreva("ERRO MATRIZ INVÁLIDA DE ORDENAÇÃO")
				retorne
		}
		//Ordenação e agrupamento de marcas na matriz
		para (inteiro posAtual=0; posAtual < qntCarros-1; posAtual++) {
			posMenor = posAtual
			para (inteiro posVerificar = posAtual+1; posVerificar < qntCarros; posVerificar++) {
				se (matriz[posVerificar][COLUNA_MARCA] < matriz[posMenor][COLUNA_MARCA]) {
					posMenor = posVerificar
				}
			}
			//Transfere os carros de linha na matriz caso seja encontrado um de número menor
			se (posMenor != posAtual) {
				copia[COLUNA_MARCA] = matriz[posAtual][COLUNA_MARCA]
				copia[COLUNA_MODELO] = matriz[posAtual][COLUNA_MODELO]
				copia[2] = matriz[posAtual][COLUNA_ESTOQUE]
						
				matriz[posAtual][COLUNA_MARCA] = matriz[posMenor][COLUNA_MARCA]
				matriz[posAtual][COLUNA_MODELO] = matriz[posMenor][COLUNA_MODELO]
				matriz[posAtual][2] = matriz[posMenor][2]
				
				matriz[posMenor][COLUNA_MARCA] = copia[COLUNA_MARCA]
				matriz[posMenor][COLUNA_MODELO] = copia[COLUNA_MODELO]
				matriz[posMenor][2] = copia[2]	
			}
		}
	}
	funcao vazio ordenar_modelo(inteiro &matriz[][], inteiro infoMatriz) {
		inteiro qntCarros = 0//Responsável por controlar laços de repetição de ordenação
		inteiro posMenor, copia[2] //Variáveis de ordenação
		inteiro linhaFinal= 0
		//Determina o valor para variável `qntCarros`
		escolha (infoMatriz) {
			caso ALUGUEL:
				qntCarros = qnt_carros_empresa
				pare
			caso EMPRESA:
				qntCarros = qnt_carros_empresa
				pare
			caso CLIENTE_VENDER:
				qntCarros = qnt_carros_cliente
				pare	
			caso CLIENTE_POSSUI:
				qntCarros = qnt_carros_cliente
				pare
			caso CLIENTE_ALUGADOS:
				qntCarros = qnt_carros_alugados_cliente
				pare	
			caso contrario:
				escreva("ERRO MATRIZ INVÁLIDA DE ORDENAÇÃO")
				retorne
		}
		//Ordenação de modelos por número de coluna na tabela fipe
		para (inteiro linhaInicial = 0; linhaInicial < qntCarros; linhaInicial+=0) {
			linhaFinal = linhaInicial
			//Determina até qual linha da matriz a mesma marca se estende, para ordenar somente o intevalo da mesma marca
			para (inteiro linhaVerificar=linhaInicial+1; linhaVerificar < qntCarros; linhaVerificar++) {
				se (matriz[linhaVerificar][COLUNA_MARCA] == matriz[linhaInicial][COLUNA_MARCA]) {
					linhaFinal = linhaVerificar
				} senao {
					pare
				}
			}
			
			se (linhaFinal != linhaInicial) {
				//Selection Sort
				para (inteiro linhaOrdenar = linhaInicial; linhaOrdenar < linhaFinal; linhaOrdenar++) {
					posMenor = linhaOrdenar
					para (inteiro linhaVerificar = linhaOrdenar+1; linhaVerificar <= linhaFinal; linhaVerificar++) {
						se (matriz[posMenor][COLUNA_MODELO] > matriz[linhaVerificar][COLUNA_MODELO]) {
							posMenor = linhaVerificar
						}
					}
					se (posMenor != linhaOrdenar) {
						copia[0] = matriz[linhaOrdenar][1]
						copia[1] = matriz[linhaOrdenar][2]

						matriz[linhaOrdenar][1] = matriz[posMenor][1]
						matriz[linhaOrdenar][2] = matriz[posMenor][2]
						matriz[posMenor][1] = copia[0]
						matriz[posMenor][2] = copia[1]
					}
				}
			}
			
			linhaInicial = linhaFinal+1 //Determina que a próxima procura de marcas continue a partir da linha seguinte do grupo de marcas anterior
			
		}
	}

	funcao vazio tela_inicio () {
		//Concatela a cadeia com os carros que o cliente possui. Se o cliente possuir carros alugados, eles são exibidos
		cadeia textoTela = carros(CLIENTE_POSSUI)
		se (qnt_carros_alugados_cliente >= 1) {
			textoTela += (carros(CLIENTE_ALUGADOS))
		}

		textoTela += "\nO que deseja fazer?\n\n1- Comprar\n2- Vender\n3- Alugar\n\n[V- VOLTAR/SAIR]\n\n>>> "
		inteiro entrada = receber_entrada(1, 3, textoTela)
		//Sistema de gerenciamento de telas
		escolha (entrada) {
			caso T_COMPRAR:
				tela_atual = T_COMPRAR
				pare
			caso T_VENDER:
				tela_atual = T_VENDER
				pare
			caso T_ALUGAR:
				tela_atual = T_ALUGAR
				pare
			caso OP_VOLTAR:
				tela_atual = T_SAIR
				pare
			caso contrario:
				tela_atual = T_INICIO
		}
		
	}
	
	funcao vazio tela_comprar () {
		inteiro modeloComprar, marcaComprar, linha
		cadeia textoTela = "Marcas disponíveis:\n\n"
		//Concatena a cadeia com as marcas disponíveis
		para (inteiro m = 0; m < QNT_MARCAS; m++) {
			textoTela += (m+1) +"- " + nome_marca(m) + "\n"
		}
		
		textoTela += "\n\nDigite o número da marca que deseja comprar. [V- VOLTAR/SAIR]\n\n>>> "
		marcaComprar = receber_entrada(1, QNT_MARCAS, textoTela)

		se (marcaComprar == OP_VOLTAR) {
			limpa()
			tela_atual = T_INICIO
			retorne
		}
		marcaComprar-- // Reduz em 1 a marca selecionada para ser representativa do valor da marca na tabela fipe (coluna na tabela_carros e tabela_precos)
		
		limpa()
		textoTela = carros_marca(marcaComprar, EMPRESA) //Concatena a cadeia com a lista dos carros da empresa relacionados à marca selecionada
		textoTela += "\n\n| Dinheiro: R$ " + m.arredondar(dinheiro_cliente, 2) + " |"
		textoTela += "\nInforme número do modelo que deseja comprar. [V- VOLTAR/SAIR]\n\n>>> "

		faca {
			modeloComprar = receber_entrada(1, QNT_MAX_CARROS_COLUNA_MARCA, textoTela)
			
			se (modeloComprar == OP_VOLTAR) {
				limpa()
				tela_atual = T_COMPRAR
				retorne
			} 
			modeloComprar-- //Mesma coisa da marca
			
			linha = procurar_carro(marcaComprar, modeloComprar, EMPRESA) //Verifica se o carro selecionado está na matriz da empresa
			
			se (linha == ERRO_CARRO_INEXISTENTE) {
					limpa()
					escreva("Não foi possível selecionar esse modelo. Tente novamente com outro valor...")
					u.aguarde(2500)
			}

			limpa()
		} enquanto (linha == ERRO_CARRO_INEXISTENTE)
		
		textoTela = "Carro selecionado:\n" + "~~> "+ nome_marca(marcaComprar) + " " + tabela_carros[marcaComprar][modeloComprar]+ "\n\n"
		textoTela += "VALOR DE COMPRA: R$ " +  m.arredondar((tabela_precos[marcaComprar][modeloComprar] * ACRESCIMO_COMPRA), 2) + "\n\n"
		textoTela += "Deseja prosseguir com a compra?\n[S - SIM] [V - RECUSAR/VOLTAR]\n\n>>> "
		inteiro retAceitar = receber_entrada(0,0, textoTela) //Recebe entrada de aceitar ou recusar a oferta
		limpa()

		
		escolha (retAceitar) {
			caso OP_ACEITAR:
				inteiro retCompra = cliente_compra(marcaComprar, modeloComprar) //Realiza a operação de compra
				escolha (retCompra) {
					caso MSG_SUCESSO:
						escreva("Carro comprado com sucesso!")
						pare
					caso ERRO_DINHEIRO_INSUFICIENTE:
						escreva("ERRO: você não possue o dinheiro para comprar este carro.\nQuantia faltante: R$ ", tabela_precos[marcaComprar][modeloComprar] * ACRESCIMO_COMPRA - dinheiro_cliente)
						pare
					caso ERRO_LIMITE_EXCEDIDO:
						escreva("ERRO: limite de carros excedido. Venda um carro para liberar espaço.")
						pare
					caso contrario:
						escreva("ERRO DESCONHECIDO.")
				}

				tela_atual = T_COMPRAR
				u.aguarde(2500)
				retorne
				
			caso OP_VOLTAR:
				limpa()
				tela_atual = T_COMPRAR
				retorne
				
			caso contrario:
				limpa()
				escreva("ERRO: OPERAÇÃO INVÁLIDA! Retornando à tela de compra...")
				u.aguarde(2500)
				tela_atual = T_COMPRAR
				retorne
		}	
	}
	
	funcao vazio tela_vender () {

		inteiro modeloVender, marcaVender, linha
		cadeia textoTela = "Marcas disponíveis:\n\n"
		//Mostra as marcas disponíveis
		para (inteiro m = 0; m < QNT_MARCAS; m++) {
			textoTela += (m+1) +"- " + nome_marca(m) + "\n"
		}
		
		textoTela += "\n\nDigite o número da marca que deseja vender. [V- VOLTAR/SAIR]\n\n>>> "
		marcaVender = receber_entrada(1, QNT_MARCAS, textoTela) //Avalia se a marca entrada é valida

		se (marcaVender == OP_VOLTAR) {
			limpa()
			tela_atual = T_INICIO
			retorne
		}
		marcaVender-- // Reduz em 1 a marca selecionada para ser representativa do valor da marca na tabela fipe (coluna na tabela_carros e tabela_precos)
		
		limpa()
		textoTela = carros_marca(marcaVender, CLIENTE_VENDER) // Concatena a lista de carros da marca selecionada
		textoTela += "\nInforme número do modelo que deseja vender. [V- VOLTAR/SAIR]\n\n>>> "

		//Recebe o modelo e verifica que o carro existe na matriz do cliente
		faca {
			modeloVender = receber_entrada(1, QNT_MAX_CARROS_COLUNA_MARCA, textoTela)
			
			se (modeloVender == OP_VOLTAR) {
				limpa()
				tela_atual = T_VENDER
				retorne
			} 
			modeloVender-- //Idem do da marca
			
			linha = procurar_carro(marcaVender, modeloVender, CLIENTE_POSSUI) //Verifica se o carro selecionado está na matriz do cliente
			
			se (linha == ERRO_CARRO_INEXISTENTE) {
					limpa()
					escreva("Não foi possível selecionar esse modelo. Tente novamente com outro valor...")
					u.aguarde(2500)
					limpa()
			}
		} enquanto (linha == ERRO_CARRO_INEXISTENTE)
		
		limpa()
		textoTela = "Carro selecionado:\n" + "~~> "+ nome_marca(marcaVender) + " " + tabela_carros[marcaVender][modeloVender]+ "\n\n"
		textoTela += "VALOR DE VENDA: R$ " +  m.arredondar((tabela_precos[marcaVender][modeloVender] * DECRESCIMO_VENDA), 2) + "\n\n"
		textoTela += "Deseja prosseguir com a venda?\n[S - SIM] [V - RECUSAR/VOLTAR]\n\n>>> "
		inteiro retAceitar = receber_entrada(0,0, textoTela) //Recebe entrada de aceitar ou recusar a oferta
		limpa()
		
		escolha (retAceitar) { //Toma uma decisão com base na ação do cliente
			caso OP_ACEITAR:
				inteiro retCompra = cliente_vende(marcaVender, modeloVender) //Realiza a operação de venda
				escolha (retCompra) {// Toma uma ação com base no retorno da função de compra
					caso MSG_SUCESSO:
						escreva("Carro vendido com sucesso!")
						pare
					caso ERRO_LIMITE_EXCEDIDO:
						escreva("ERRO: limite de carros excedido.")
						pare
					caso contrario:
						escreva("ERRO DESCONHECIDO.")
				}

				tela_atual = T_VENDER
				u.aguarde(2500)
				retorne
				
			caso OP_VOLTAR:
				limpa()
				tela_atual = T_VENDER
				retorne
				
			caso contrario:
				limpa()
				escreva("ERRO: OPERAÇÃO INVÁLIDA! Retornando à tela de compra...")
				u.aguarde(2500)
				tela_atual = T_VENDER
				retorne
		}	
	}

	funcao vazio tela_alugar () {
		inteiro marcaAlugar, modeloAlugar, linha
		cadeia textoTela = "Marcas disponíveis:\n\n"
		//Concatena as marcas disponíveis
		para (inteiro m = 0; m < QNT_MARCAS; m++) {
			textoTela += (m+1) +"- " + nome_marca(m) + "\n"
		}
		
		textoTela += "\n\nDigite o número da marca que deseja alugar. [V- VOLTAR/SAIR]\n\n>>> "
		marcaAlugar = receber_entrada(1, QNT_MARCAS, textoTela) //Verifica a marca inserida

		se (marcaAlugar == OP_VOLTAR) {
			limpa()
			tela_atual = T_INICIO
			retorne
		}
		marcaAlugar-- // Reduz em 1 a marca selecionada para ser representativa do valor da marca na tabela fipe (coluna na tabela_carros e tabela_precos)
		
		limpa()
		textoTela = carros_marca(marcaAlugar, ALUGUEL)
		textoTela += "\n\n| Dinheiro: R$ " + m.arredondar(dinheiro_cliente, 2) + " |"
		textoTela += "\nInforme número do modelo que deseja alugar. [V- VOLTAR/SAIR]\n\n>>> "
		faca {
			modeloAlugar = receber_entrada(1, QNT_MAX_CARROS_COLUNA_MARCA, textoTela)
			
			se (modeloAlugar == OP_VOLTAR) {
				limpa()
				tela_atual = T_COMPRAR
				retorne
			} 
			modeloAlugar-- //Idem marca
			
			linha = procurar_carro(marcaAlugar, modeloAlugar, EMPRESA) //Verifica se o carro selecionado está na matriz da empresa
			
			se (linha == ERRO_CARRO_INEXISTENTE) {
					limpa()
					escreva("Não foi possível selecionar esse modelo. Tente novamente com outro valor...")
					u.aguarde(2500)
			}
			
			limpa()
		} enquanto (linha == ERRO_CARRO_INEXISTENTE)
		textoTela = "Carro selecionado:\n" + "~~> "+ nome_marca(marcaAlugar) + " " + tabela_carros[marcaAlugar][modeloAlugar]+ "\n\n"

		//Define qual a marca do veículo
		cadeia categoriaCarro = ""
		se (tabela_precos[marcaAlugar][modeloAlugar] <= 80000.0) {
			categoriaCarro = "POPULAR"
		} senao se (tabela_precos[marcaAlugar][modeloAlugar] <= 200000.0) {
			categoriaCarro = "PREMIUM"
		} senao {
			categoriaCarro = "LUXO"
		}

		real precoAluguel = valor_aluguel(marcaAlugar, modeloAlugar) //Recebe o valor do aluguel do carro
		textoTela += "Categoria do carro: " + categoriaCarro + "(R$ " + precoAluguel + "/DIA)\n\n"

		inteiro diasAluguel = receber_entrada (1, 30, textoTela+"Informe por quantos dias deseja alugar. [V- VOLTAR/SAIR]\n\n>>> ")
		limpa()
		textoTela += "PERÍODO DE ALUGUEL: " + diasAluguel + " dias\n\n"
		textoTela += "VALOR TOTAL DO ALUGUEL: R$ " + precoAluguel * diasAluguel + "\n\n"
		
		textoTela += "Deseja prosseguir com o aluguel?\n[S - SIM] [V - RECUSAR/VOLTAR]\n\n>>> "
		inteiro retAceitar = receber_entrada(0,0, textoTela) //Recebe entrada de aceitar ou recusar a oferta
		limpa()
		
		escolha (retAceitar) {
			caso OP_ACEITAR:
				inteiro retCompra = cliente_aluga(marcaAlugar, modeloAlugar, diasAluguel) //Realiza a operação de aluguel
				escolha (retCompra) {
					caso MSG_SUCESSO:
						escreva("Carro alugado com sucesso!")
						pare
					caso ERRO_DINHEIRO_INSUFICIENTE:
						escreva("ERRO: você não possue o dinheiro para alugar este carro.\nQuantia faltante: R$ ", precoAluguel * diasAluguel - dinheiro_cliente)
						pare
					caso ERRO_LIMITE_EXCEDIDO:
						escreva("ERRO: limite de carros alugados excedido. Não é possível alugar mais veículos.")
						pare
					caso contrario:
						escreva("ERRO DESCONHECIDO.")
				}

				tela_atual = T_ALUGAR
				u.aguarde(2500)
				retorne
				
			caso OP_VOLTAR:
				limpa()
				tela_atual = T_ALUGAR
				retorne
				
			caso contrario:
				limpa()
				escreva("ERRO: OPERAÇÃO INVÁLIDA! Retornando à tela de aluguel...")
				u.aguarde(2500)
				tela_atual = T_ALUGAR
				retorne
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1598; 
 * @DOBRAMENTO-CODIGO = [89, 77, 136, 175, 213, 293, 374, 381, 389, 432, 492, 575, 636, 691, 740, 793, 873, 918, 929, 987, 1041, 1104, 1133, 1219, 1302];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {carros_empresa, 68, 9, 14};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */