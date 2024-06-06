Algoritmo "semnome"
//4) Escreva um programa que leia um número qualquer e mostre a tabuada
//desse número, usando a estrutura “para”.

// Ex: Digite um valor: 5

// 5 x 1 = 5

// 5 x 2 = 10

// 5 x 3 = 15 ...
Var
   x: inteiro
   y: real
Inicio
   escreva("Digite um valor: ")
   leia(y)
   para x de 1 ate 10 passo 1 faca
      escreval(y, " x ", x, " = ", y*x)
   fimpara
Fimalgoritmo