Algoritmo "semnome"
Var
   a, c, qntNeg: inteiro
Inicio
   para c de 1 ate 5 faca
      escreval("### ", c, "� N�mero ###")
      escreva("Digite o n�mero para checar se � negativo: ")
      leia(a)
      se (a < 0) entao
         qntNeg <- qntNeg + 1
      fimse
      escreval("")
   fimpara

   escreval("### ESTAT�STICA ###")
   escreval(">> ", qntNeg, " negativos contabilizados")
Fimalgoritmo