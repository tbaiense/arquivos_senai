Algoritmo "semnome"
//6) Fa�a um programa que leia 7 n�meros inteiros e no final mostre o
//somat�rio entre eles.
Var
numSomado, numDigitado, i: inteiro
Inicio
numSomado <- 0
para i de 1 ate 7 faca
aleatorio 0 , 100
     escreva(i, "# Digite o n�mero a ser somado: ")
     leia(numDigitado)
     aleatorio off
     numSomado <- numSomado + numDigitado
     escreval("")
fimpara

escreval(">> O somat�rio entre eles � igual a ", numSomado, ".")
Fimalgoritmo