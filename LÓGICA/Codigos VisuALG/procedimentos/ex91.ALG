Algoritmo "semnome"
Var
   numUm, numDois: real
Inicio
procedimento Maior(i, j: real)
inicio
   se (i = j) entao
      escreval(">> Os números ", i, " e ", j, " são iguais.")
   senao
        escreva(">> O número ")
        se (i > j) entao
             escreval(i, " é o maior.")
        senao
             escreval(j, " é o maior.")
        fimse
   fimse
fimprocedimento

escreva("Digite o primeiro número: ")
leia(numUm)
escreva("Digite o segundo número: ")
leia(numDois)
Maior(numUm, numDois)
Fimalgoritmo