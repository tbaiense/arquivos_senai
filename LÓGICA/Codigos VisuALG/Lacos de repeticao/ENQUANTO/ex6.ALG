Algoritmo "semnome"
Var
   numRand, numDiv, numMaisDeCinco, c: inteiro
Inicio
   escreval("######## SORTEADOR ########")
   numMaisDeCinco <- 0
   numDiv <- 0
   c <- 0
   enquanto (c < 10) faca
      numRand <- RandI(11)
      escreva(numRand, " ")
      se (numRand > 5) entao
         numMaisDeCinco <- numMaisDeCinco + 1
      fimse
      se ((numRand <> 0) e ((numRand % 3) = 0)) entao
         numDiv <- numDiv + 1
      fimse
      c <- c + 1
   fimenquanto
   escreval("")

   escreval("####### ESTAT�STICA #######")
   escreval("a) N�meros que est�o acima de 5: ", numMaisDeCinco)
   escreval("b) N�meros que s�o divis�veis por 3: ", numDiv)

Fimalgoritmo