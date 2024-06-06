Algoritmo "semnome"
Var
   numReal, numRealMedio: real
   qntNum: inteiro
Inicio
   escreval("### MÉDIA DE Nº REAIS ###")
   escreval("obs.: '0' finaliza e calcula a média")
   repita
      escreva(">> Digite um numero real maior que zero: ")
      leia(numReal)
      enquanto (numReal < 0) faca
         escreva("Número inválido. Digite um maior que zero: ")
         leia(numReal)
      fimenquanto
      se (numReal > 0) entao
         qntNum <- qntNum + 1
         numRealMedio <- numRealMedio + numReal
      fimse
   ate numReal = 0
Fimalgoritmo