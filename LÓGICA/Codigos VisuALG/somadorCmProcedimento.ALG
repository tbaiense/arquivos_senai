Algoritmo "semnome"
Var
   numUm, numDois, resultado: inteiro
   controle : caractere
Inicio
procedimento receberNumeros
inicio
   escreval("Soma de n�meros:")
   escreva(">> ")
   leia(numUm)
   limpatela
   escreval("Soma de n�meros:")
   escreva(">> ", numUm," + ")
   leia(numDois)
   limpatela
fimprocedimento

procedimento somar_e_exibir(i, j: inteiro)
inicio
   resultado <- i + j
   escreval("Soma de n�meros:")
   escreval(">> ", numUm, " + ", numDois," = ", resultado)
fimprocedimento

procedimento checarContinua()
inicio
escreval("")
escreval("---------------------")
repita
   escreval("Deseja continuar? Digite 's' para continuar, e 'n' para n�o")
   leia(controle)
   controle <- Copia(controle, 1, 1)
   controle <- Maiusc(controle)
ate ((controle = "N") ou (controle = "S"))
fimprocedimento

escreval("### SOMA DE DOIS N�MEROS ###")
repita
   receberNumeros()
   somar_e_exibir(numUm, numDois)
   checarContinua()
ate controle = "N"

Fimalgoritmo