Algoritmo "semnome"
Var
   R, M, L : inteiro
   ResultadoM, ResultadoL : caractere
Inicio
   escreva("Digite o resultado do melhor atleta: ")
   leia(R)
   escreva("Digite o recorde mundial atual: ")
   leia(M)
   escreva("Digite o recorde olímpico atual: ")
   leia(L)

   ResultadoM <- "*"
   ResultadoL <- "*"

   se (R < M) entao
      ResultadoM <- "RM"
   fimse
   se (R < L) entao
      ResultadoL <- "RO"
   fimse

   escreval(ResultadoM)
   escreval(ResultadoL)
Fimalgoritmo