Algoritmo "semnome"
Var
   numUm, numDois, numTres: real
Inicio
funcao Maior(i, j, k: real): real
var
   numMaior: real
inicio
   se ((i=j) e (j=k)) entao
      escreva("Os n�meros digitados s�o iguais. ")
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

escreva("Digite o primeiro n�mero: ")
leia(numUm)
escreva("Digite o segundo n�mero: ")
leia(numDois)
escreva("Digite o terceiro n�mero: ")
leia(numTres)
escreval("O maior n�mero � ", Maior(numUm, numDois, numTres))
Fimalgoritmo