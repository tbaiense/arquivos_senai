Algoritmo "semnome"
//Programa de lanchonete:
// 1) Permite a cria��o de uma conta de editor de card�pio e de caixa com
// senhas
// 2) Permite adicionar itens ao card�pio (m�ximo 3) com seus respectivos nomes,
// pre�os, e c�digos
// 3) Permite fazer pedidos m�ltiplos e mostrar o subtotal, com o c�digo do
// pedido para ser pago no caixa
// 4) Permite ser o caixa para o pagamento dos c�gidos dos pedidos em aberto


Var
   i, j, k: inteiro
   senha_contaEditor: caractere
   senha_contaCaixa: caractere
   qntMax_produtos, qnt_produtosDisponiveis: inteiro
   nomeProduto: vetor [1.. 3] de caracter
   precoProduto: vetor [1.. 3] de real
   codigoProduto: vetor [1.. 3] de inteiro
Inicio
   qntMax_produtos <- 3
   para i de 1 ate qntMax_produtos faca
      nomeProduto[i] <- "NULO"
      precoProduto[i] <- 0
      codigoProduto[i] <- 0
   fimpara

//####################### FUN��ES E PROCEDIMENTOS ############################

// 1. ETAPA DE CADASTRO DE CONTAS:
procedimento cadastrar_contas()
var
   continuar: caractere
inicio
   // 1.1 CONTA DE EDITOR DE CARD�PIO ---------
   // 1.1.1 DEFINI��O DE SENHA
   repita
      escreva("Digite a senha para a conta editor: ")
      leia(senha_contaEditor)
      escreva(">> Senha cadastrada com sucesso!")
      limpatela
      // 1.2 CONTA DE CAIXA ----------------------
      // 1.2.1 DEFINI��O DE SENHA
      escreva("Digite a senha para a conta caixa: ")
      leia(senha_contaCaixa)
      escreva(">> Senha cadastrada com sucesso!")
      limpatela

      escreval("---CADASTRO CONCLU�DO---")
      escreval("Senha do Editor: ", senha_contaEditor)
      escreval("Senha do Caixa: ", senha_contaCaixa)

      escreval("")
      escreval("Proceguir? (S)im ou (N)�o: ")
      repita
         leia(continuar)
         continuar <- Copia(continuar, 1, 1)
         continuar <- Maiusc(continuar)
         escolha (continuar)
         caso "S"
            limpatela
            escreval("Informa��es de conta definidas. Prosseguindo...")
         caso "N"
            limpatela
            escreval("")
            escreval("Redefinindo senhas...")
         outrocaso
            escreval("ERRO: Op��o inv�lida. Tente novamente digitando 'S' ou 'N'.")
            escreva(">> ")
         fimescolha
      ate ((continuar = "S") ou (continuar = "N"))
      limpatela
   ate (continuar = "S")
fimprocedimento
// ---------------------------------------------------------------------------
// 2. ETAPA DE ESCOLHA DO MODO DE OPERA��O:
procedimento escolher_modoOperacao()
var
   modo: inteiro
   senha: caractere
inicio
   escreval("##### MODO DE OPERA��O ####")
   escreval("1- Ponto de venda")
   escreval("2- Caixa")
   escreval("3- Editor de card�pio")
   escreva(">> Digite o modo de opera��o desejado: ")
   leia(modo)

   escolha (modo)
   caso 1
      limpatela
      escreval("MODO PDV")
   caso 2
      limpatela
      escreval("Digite a senha do caixa: ")
      leia(senha)
      se (senha = senha_contaCaixa) entao
         limpatela
         escreval("MODO CAIXA")
      senao
         limpatela
         escreval("ERRO: Senha para o modo caixa inv�lida.")
         escolher_modoOperacao()
      fimse
   caso 3
      limpatela
      escreval("Digite a senha do editor: ")
      leia(senha)
      se (senha = senha_contaEditor) entao
         limpatela
         modo_edicao()
      senao
         limpatela
         escreval("ERRO: Senha para o modo editor inv�lida.")
         escolher_modoOperacao()
      fimse
   outrocaso
      limpatela
      escreval("ERRO: Modo de opera��o inv�lido. Tente novamente")
      escreval("")
      escolher_modoOperacao()
   fimescolha

fimprocedimento
// ---------------------------------------------------------------------------
// 3. ETAPA DO MODO DE OPERA��O:
// 3.1 PDV -> modo_pdv() ------------------------
// 3.1.0 GERAR NOVO PEDIDO -> gerar_pedido(n)
// 3.1.1 MOSTRAR CARD�PIO -> mostrar_cadardapio()
// 3.1.2 SELECIONAR ITEM(NS) E QUANTIDADE(S) -> selecionar_itens()
// 3.1.3 FINALIZAR PEDIDO -> finalizar_pedido() -------------------
// 3.1.3.1 MOSTRAR OS ITENS NO PEDIDO E O TOTAL -> mostrar_pedido_atual()
// 3.1.3.2 CONFIRMAR FINALIZA��O DO PEDIDO -> confirmar_finalizar_pedido()
// 3.1.3.3 GERAR C�DIGO DE PEDIDO -> gerar_codigo_pedido()
// 3.1.3.4 CONFIRMAR NOVO PEDIDO -> confirmar_gerar_novo_pedido()

// 3.2 CAIXA modo_caixa()   ------------------
// 3.2.1 RECEBER C�DIGO DO PEDIDO
// 3.2.2 MOSTRAR OS ITENS NO PEDIDO E O TOTAL
// 3.2.3 ESCOLHER M�TODO DE PAGAMENTO
// 3.2.3 RECEBER PAGAMENTO
// 3.2.4 MOSTRAR COMPROVANTE + TROCO (SE HOUVER)
// 3.2.5 CONCLUS�O DO PEDIDO

// 3.3 EDI��O DE CARD�PIO modo_edicao() -----
procedimento modo_edicao()
var
   acao_cardapio: inteiro
inicio
   repita
      escreval("####### EDI��O DE CARD�PIO #######")
      escreval("")
      mostrar_cardapio()
      escreval("")
      se (qnt_produtosDisponiveis < qntMax_produtos) entao
         escreva("[1- NOVO PRODUTO]")
         se (qnt_produtosDisponiveis > 0) entao
            escreva("   |   ")
         fimse
      fimse
      se (qnt_produtosDisponiveis > 0) entao
         escreval("[2- EXCLUIR PRODUTO]")
      senao
         escreval("")
      fimse
      escreval("[0- SAIR]")
      escreval("")
      
      // 3.3.0 ESCOLHER CADASTRAR OU EXCLUIR PRODUTO
      repita
         escreva(">> O que deseja fazer?: ")
         leia(acao_cardapio)
         escolha (acao_cardapio)
         caso 0
            se (qnt_produtosDisponiveis > 0) entao //Voltar ao menu de modo de opera��o
               limpatela
            senao
               escreval("ERRO: Cadastre ao menos um produto antes de sair.")
               acao_cardapio <- -1
            fimse
         caso 1
            se ((qnt_produtosDisponiveis >= 0) e (qnt_produtosDisponiveis < qntMax_produtos)) entao
               limpatela
               cadastrar_produto()
            senao
               limpatela
               escreval("ERRO: N�mero m�ximo de produtos atingidos.")
               acao_cardapio <- -1
            fimse
         caso 2
            se (qnt_produtosDisponiveis > 0) entao
               limpatela
               excluir_produto()
            senao
               escreval("ERRO: N�o h� produtos para excluir.")
               acao_cardapio <- -1
            fimse
         outrocaso
            escreval("Op��o inv�lida. Tente novamente.")
            acao_cardapio <- -1
         fimescolha
      ate ((acao_cardapio = 0) ou (acao_cardapio = 1) ou (acao_cardapio = 2))
   ate (acao_cardapio = 0)
fimprocedimento

procedimento mostrar_cardapio()
inicio
   escreval("--------=====| CARD�PIO |=====--------")
   se (qnt_produtosDisponiveis > 0) entao
      para i de 1 ate qnt_produtosDisponiveis faca
         escreval(" ", codigoProduto[i]:5, "   ", nomeProduto[i]:20, " R$ ", precoProduto[i])
      fimpara
   senao
      escreval(".~ Nenhum produto cadastrado ~.")
   fimse
   escreval("--------=====| ---||--- |=====--------")
fimprocedimento

// 3.3.1 CADASTRAR NOVO PRODUTO
procedimento cadastrar_produto()
var
   entrada_nome: caractere
   entrada_preco: real
   entrada_codigo, produto_atual: inteiro
   acao_cadastrar: inteiro
inicio
   repita
      produto_atual <- qnt_produtosDisponiveis + 1
      // Checa se n�o atingiu o qntMax_produtos
      se ((qnt_produtosDisponiveis >= 0) e (qnt_produtosDisponiveis < qntMax_produtos)) entao
         escreval("####### CADASTRO DE PRODUTO #######")
         // Defini��o do nome
         repita
            escreva(">> Nome: ")
            leia(entrada_nome)
            se ((Compr(entrada_nome) > 3) e (Compr(entrada_nome) <= 20)) entao
               entrada_nome <- Maiusc(entrada_nome)
               nomeProduto[produto_atual] <- entrada_nome
            senao
               escreval("ERRO: Defina um nome maior que 3 e menor que 21 caracteres.")
            fimse
         ate (nomeProduto[produto_atual] <> "NULO")

         // Defini��o do pre�o
         repita
            escreva(">> Pre�o: R$ ")
            leia(entrada_preco)
            se (entrada_preco <= 0) entao // evita que o pre�o seja negativo
               escreval("ERRO: Defina um nome maior que R$ 0.")
            fimse
            precoProduto[produto_atual] <- entrada_preco
         ate (entrada_preco > 0)

         // Defini��o do c�digo
         repita
            escreva(">> C�digo num�rico: ")
            leia(entrada_codigo)
            se (entrada_codigo > 0) entao // evita que o pre�o seja negativo
               se (produto_atual = 1) entao
                  codigoProduto[produto_atual] <- entrada_codigo
               senao
                  para i de 1 ate qnt_produtosDisponiveis faca
                     se (entrada_codigo = codigoProduto[i]) entao
                        escreval("ERRO: C�digo indispon�vel. Especifique outro.")
                        entrada_codigo <- 0
                        interrompa
                     fimse
                  fimpara
               fimse
            senao
               escreval("ERRO: C�digo inv�lido. Especifique outro.")
               entrada_codigo <- 0
            fimse
         ate (entrada_codigo > 0)
         codigoProduto[produto_atual] <- entrada_codigo

         escreval("")

         escreval("### Concluir cadastro do produto atual? ###")
         escreval("[1- CONCLUIR]  |  [2- REFAZER]  |  [3- CANCELAR]")
         repita
            escreva(">> Op��o: ")
            leia(acao_cadastrar)
            escolha (acao_cadastrar)
            // concluir produto
            caso 1
               qnt_produtosDisponiveis <- qnt_produtosDisponiveis + 1
               limpatela
               // voltar ao modo_edicao()
               
            // refazer produto
            caso 2
               nomeProduto[produto_atual] <- "NULO"
               precoProduto[produto_atual] <- 0
               codigoProduto[produto_atual] <- 0
               limpatela
               //voltar reiniciar o procedimento com produto atual anulado
            caso 3
               nomeProduto[produto_atual] <- "NULO"
               precoProduto[produto_atual] <- 0
               codigoProduto[produto_atual] <- 0
               limpatela
               // voltar ao modo_edicao()
               
            outrocaso
               escreval("ERRO: Op��o inv�lida. Tente novamente.")
            fimescolha
         ate ((acao_cadastrar = 1) ou (acao_cadastrar = 2) ou (acao_cadastrar = 3))
      senao
         limpatela
         escreval("ERRO: N�mero m�ximo de produtos atingidos.")
         modo_edicao()
      fimse

   ate ((acao_cadastrar = 1) ou (acao_cadastrar = 3)) // sai e volta ao modo_edicao() se concluir ou cancelar
fimprocedimento

// 3.3.2 EXCLUIR PRODUTO
procedimento excluir_produto()
var
   excluir_produto_codigo, excluir_produto_numero, proximo_produto_numero: inteiro
   codigo_existente: logico
inicio
   repita
      codigo_existente <- FALSO
      se (qnt_produtosDisponiveis > 0) entao
         limpatela
         escreval("####### EXCLUS�O DE PRODUTO #######")
         mostrar_cardapio()
         escreval("")
         escreval("[0- VOLTAR]")
         repita
            escreva(">> C�digo do produto a ser exclu�do: ")
            leia(excluir_produto_codigo)
            escolha (excluir_produto_codigo)
            caso 0
               limpatela
               // voltar ao modo_edicao()
            outrocaso
               // loop de consulta se o c�digo existe
               para i de 1 ate qnt_produtosDisponiveis faca
                  se (excluir_produto_codigo = codigoProduto[i]) entao
                     codigo_existente <- VERDADEIRO
                     excluir_produto_numero <- i
                  fimse
               fimpara

               se (codigo_existente = VERDADEIRO) entao
                  nomeProduto[excluir_produto_numero] <- "NULO"
                  precoProduto[excluir_produto_numero] <- 0
                  codigoProduto[excluir_produto_numero] <- 0
                  se ((qnt_produtosDisponiveis > 1) e (excluir_produto_numero < qnt_produtosDisponiveis)) entao // organizacao apos exclusao
                     para i de excluir_produto_numero ate (qnt_produtosDisponiveis - 1) faca
                        se (codigoProduto[i] = 0) entao
                           proximo_produto_numero <- i + 1
                           nomeProduto[i] <- nomeProduto[proximo_produto_numero]
                           nomeProduto[proximo_produto_numero] <- "NULO"
                           precoProduto[i] <- precoProduto[proximo_produto_numero]
                           precoProduto[proximo_produto_numero] <- 0
                           codigoProduto[i] <- codigoProduto[proximo_produto_numero]
                           codigoProduto[proximo_produto_numero] <- 0
                        fimse
                     fimpara
                  fimse
                  qnt_produtosDisponiveis <- qnt_produtosDisponiveis - 1
                  limpatela
                  // reinicia o procedimento excluir_produto()
               senao
                  escreval("ERRO: N�o foi poss�vel localizar esse produto. Tente outro c�digo.")
               fimse
            fimescolha
         ate ((codigo_existente = VERDADEIRO) ou (excluir_produto_codigo = 0))
      senao
         limpatela
         excluir_produto_codigo <- 0
         // voltar ao modo_edicao()
      fimse
   ate (excluir_produto_codigo = 0)
fimprocedimento

procedimento msg_encerrar_programa()
inicio
   escreval("")
   escreval("########### FINALIZANDO EXECU��O ###########")
   escreval("Obrigado por utilizar o LancheSYSTEM!")
fimprocedimento
// #############################################################################

// ########################## PROGRAMA PRINCIPAL ###############################
escreval("Bem-vindo ao LancheSYSTEM!")
cadastrar_contas()
modo_edicao()
escolher_modoOperacao() // destrinchar para funcionar no programa principal usando loop
msg_encerrar_programa()

Fimalgoritmo