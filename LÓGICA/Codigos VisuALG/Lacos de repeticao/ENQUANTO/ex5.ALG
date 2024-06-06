Algoritmo "semnome"
Var
   numIni, numFin, numInc, num, cReal : real
   c: inteiro
Inicio
   c <- 0
   para c de 1 ate 3 faca
      escreva("Digite")
      escolha (c)
      caso 1
         escreva(" o número inicial: ")
      caso 2
         escreva(" o número final: ")
      caso 3
         escreva(" o increvemento: ")
      outrocaso
      fimescolha

      leia(num)

      se (c = 2) entao
         // Finaliza se inicial e final forem iguais
         se (numIni = num) entao
            escreval(num, " Acabou!")
            fimalgoritmo
         fimse

      fimse

      se (c = 3) entao
         repita
            // Garante que a contagem não vire um loop infinito
            se ( ( (numIni < numFin) e (num <= 0) ) ou ( (numIni > numFin) e (num >= 0) ) ) entao
               escreval("O incremento digitado não é válido.")
               escreva("Digite o novo valor do incremento: ")
               leia(num)
            fimse
         ate ( ( (numIni < numFin) e (num > 0) ) ou ( (numIni > numFin) e (num < 0) ) )
      fimse

      escolha (c)
      caso 1
         numIni <- num
      caso 2
         numFin <- num
      caso 3
         numInc <- num
      outrocaso
      fimescolha
   fimpara

   cReal <- numIni
   se (numIni < numFin) entao
      enquanto (cReal <= numFin) faca
         escreva(" ", cReal)
         cReal <- cReal + NumInc
      fimenquanto
   senao
      enquanto (cReal >= numFin) faca
         escreva(" ", cReal)
         cReal <- cReal + numInc
      fimenquanto
   fimse
   escreval(" Acabou!")
Fimalgoritmo