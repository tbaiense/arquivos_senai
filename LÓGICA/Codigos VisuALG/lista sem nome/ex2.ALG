Algoritmo "semnome"
Var
   a, c, qntNeg: inteiro
Inicio
   para c de 1 ate 5 faca
      escreval("### ", c, "º Número ###")
      escreva("Digite o número para checar se é negativo: ")
      leia(a)
      se (a < 0) entao
         qntNeg <- qntNeg + 1
      fimse
      escreval("")
   fimpara

   escreval("### ESTATÍSTICA ###")
   escreval(">> ", qntNeg, " negativos contabilizados")
Fimalgoritmo