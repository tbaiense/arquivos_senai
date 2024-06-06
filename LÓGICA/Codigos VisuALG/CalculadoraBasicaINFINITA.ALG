Algoritmo "semnome"
Var
   numUm, numDois, resultado: real
   op, finalizar: inteiro
   opCarac: caractere
Inicio
   finalizar <- -1
   escreval("Bem-vindo à calculadora!")
   repita
      escreva("Digite o primeiro número: ")
      leia(numUm)
      escreva("Digite o segundo número: ")
      leia(numDois)
      escreval("Selecione o operador matemático desejado, sendo:")
      escreval("1 Soma")
      escreval("2 Subtrai")
      escreval("3 Multiplica")
      escreval("4 Divide")
      leia(op)
      escolha (op)
      caso 1
         resultado <- numUm + numDois
         opCarac <- "+"
      caso 2
         resultado <- numUm - numDois
         opCarac <- "-"
      caso 3
         resultado <- numUm * numDois
         opCarac <- "*"
      caso 4
         se numDois=0 entao
            escreval("infinito (divisão por zero)")
         senao
            resultado <- numUm / numDois
            opCarac <- "/"
         fimse
      outrocaso
         escreval("Operador inválido. Tente novamente escolhendo 1, 2, 3 ou 4")
      fimescolha

      escrevaL(">> ", numUm, " ", opCarac, " ", numDois, " = ", resultado)
      escreval("---------------------")
      repita
         escreval("(Continuar?) 1- Sim ,0- Não ")
         leia(continuar)
      ate (continuar = 1) ou (continuar = 0)
      escreval("---------------------")
   ate continuar = 0
Fimalgoritmo