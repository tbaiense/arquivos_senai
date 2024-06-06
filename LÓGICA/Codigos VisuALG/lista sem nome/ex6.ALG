Algoritmo "semnome"
Var
   a, c, qntPar: inteiro
Inicio
   para c de 1 ate 20 faca
      escreval("### ", c, "º Número ###")
      escreva("Digite o número para checar se é par: ")
      aleatorio 0, 10
      leia(a)
      se (a % 2 = 0) entao
         qntPar <- qntPar + 1
      fimse
      escreval("")
   fimpara
   aleatorio off
   escreval("### ESTATÍSTICA ###")
   escreval(">> ", qntPar, " pares contabilizados")
Fimalgoritmo