Algoritmo "semnome"
//8) [DESAFIO] Faça um programa que mostre os 10 primeiros elementos
//da Sequência de Fibonacci:
// 0 1 1 2 3 5 8 13 21...
Var
numPrim, numPrimTemp, numSeg, numSegTemp, resultado, i: inteiro
Inicio
numSeg <- 0
numPrim <- 1
escreva(numSeg, " ", numPrim)
para i de 3 ate 11 faca
     resultado <- numSeg + numPrim
     escreva(" ", resultado)
     numSeg <- numPrim
     numPrim <- resultado
fimpara
Fimalgoritmo