Algoritmo "semnome"
Var
   numUm, numDois: real
Inicio
procedimento Maior(i, j: real)
inicio
   se (i = j) entao
      escreval(">> Os n�meros ", i, " e ", j, " s�o iguais.")
   senao
        escreva(">> O n�mero ")
        se (i > j) entao
             escreval(i, " � o maior.")
        senao
             escreval(j, " � o maior.")
        fimse
   fimse
fimprocedimento

escreva("Digite o primeiro n�mero: ")
leia(numUm)
escreva("Digite o segundo n�mero: ")
leia(numDois)
Maior(numUm, numDois)
Fimalgoritmo