Algoritmo "semnome"
Var
   entrada: inteiro
Inicio
procedimento ParOuImpar(i: inteiro)
inicio
   escreva(">> O número digitado é ")
   se (i % 2 = 0) entao
      escreval("PAR.")
   senao
      escreval("ÍMPAR.")
   fimse
fimprocedimento

escreva("Digite um número: ")
leia(entrada)
ParOuImpar(entrada)
Fimalgoritmo