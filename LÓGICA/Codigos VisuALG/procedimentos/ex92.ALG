Algoritmo "semnome"
Var
   entrada: inteiro
Inicio
procedimento ParOuImpar(i: inteiro)
inicio
   escreva(">> O n�mero digitado � ")
   se (i % 2 = 0) entao
      escreval("PAR.")
   senao
      escreval("�MPAR.")
   fimse
fimprocedimento

escreva("Digite um n�mero: ")
leia(entrada)
ParOuImpar(entrada)
Fimalgoritmo