Algoritmo "semnome"
Var
   numUm, numDois: inteiro
Inicio

funcao SuperSomador(i,j:inteiro): inteiro
var
   c, resultado: inteiro
inicio
   para c de i ate j faca
      resultado <- resultado + c
   fimpara
   retorne resultado
fimfuncao
escreval("A soma dos valores ", SuperSomador(15,19))
Fimalgoritmo