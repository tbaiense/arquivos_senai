Algoritmo "semnome"
Var
   numUm, numDois, numTres: real
Inicio
funcao Maior(i, j, k: real): real
var
   numMaior: real
inicio
   se ((i=j) e (j=k)) entao
      escreva("Os números digitados são iguais. ")
      numMaior <- i
   senao
      se ((i > j) e (i > k)) entao
         numMaior <- i
      senao
         se ((j > i) e (j > k)) entao
            numMaior <- j
         senao
            numMaior <- k
         fimse
      fimse
   fimse
   retorne numMaior
fimfuncao

escreva("Digite o primeiro número: ")
leia(numUm)
escreva("Digite o segundo número: ")
leia(numDois)
escreva("Digite o terceiro número: ")
leia(numTres)
escreval("O maior número é ", Maior(numUm, numDois, numTres))
Fimalgoritmo