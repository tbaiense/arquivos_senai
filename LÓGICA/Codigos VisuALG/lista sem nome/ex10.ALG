Algoritmo "semnome"
Var
   numReal, numRealMedio: real
   qntNum: inteiro
Inicio
   escreval("### M�DIA DE N� REAIS ###")
   escreval("obs.: '0' finaliza e calcula a m�dia")
   repita
      escreva(">> Digite um numero real maior que zero: ")
      leia(numReal)
      enquanto (numReal < 0) faca
         escreva("N�mero inv�lido. Digite um maior que zero: ")
         leia(numReal)
      fimenquanto
      se (numReal > 0) entao
         qntNum <- qntNum + 1
         numRealMedio <- numRealMedio + numReal
      fimse
   ate numReal = 0
Fimalgoritmo