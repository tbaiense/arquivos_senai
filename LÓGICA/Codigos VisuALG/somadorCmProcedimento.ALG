Algoritmo "semnome"
Var
   numUm, numDois, resultado: inteiro
   controle : caractere
Inicio
procedimento receberNumeros
inicio
   escreval("Soma de números:")
   escreva(">> ")
   leia(numUm)
   limpatela
   escreval("Soma de números:")
   escreva(">> ", numUm," + ")
   leia(numDois)
   limpatela
fimprocedimento

procedimento somar_e_exibir(i, j: inteiro)
inicio
   resultado <- i + j
   escreval("Soma de números:")
   escreval(">> ", numUm, " + ", numDois," = ", resultado)
fimprocedimento

procedimento checarContinua()
inicio
escreval("")
escreval("---------------------")
repita
   escreval("Deseja continuar? Digite 's' para continuar, e 'n' para não")
   leia(controle)
   controle <- Copia(controle, 1, 1)
   controle <- Maiusc(controle)
ate ((controle = "N") ou (controle = "S"))
fimprocedimento

escreval("### SOMA DE DOIS NÚMEROS ###")
repita
   receberNumeros()
   somar_e_exibir(numUm, numDois)
   checarContinua()
ate controle = "N"

Fimalgoritmo