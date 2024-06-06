Algoritmo "semnome"
//6) Faça um programa que leia 7 números inteiros e no final mostre o
//somatório entre eles.
Var
numSomado, numDigitado, i: inteiro
Inicio
numSomado <- 0
para i de 1 ate 7 faca
aleatorio 0 , 100
     escreva(i, "# Digite o número a ser somado: ")
     leia(numDigitado)
     aleatorio off
     numSomado <- numSomado + numDigitado
     escreval("")
fimpara

escreval(">> O somatório entre eles é igual a ", numSomado, ".")
Fimalgoritmo