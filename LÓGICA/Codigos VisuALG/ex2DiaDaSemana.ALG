Algoritmo "semnome"
//Exercicio 2:
//Desenvolva um programa que receba como entrada um número inteiro que
//represente um dos 7 dias da semana, em seguida receba outro numero inteiro,
//que representará quantos dias posteriores passaram.
// Ao final imprima na tela qual dia da semana cairá esta data.
Var
   diaAtual, diasPassados: inteiro
   diaFinal, diaTemp: real
Inicio
   escreval("--- CALCULADORA DE DIA ---")
   escreval("Digite o primeiro dia: ")
   leia(diaAtual)
   escreval("Digite o primeiro dia: ")
   leia(diasPassados)
   diaTemp <- Abs(diaAtual) + Abs(diasPassados)
   se (diaTemp > 7) entao
      se (diaTemp % 7) = 0 entao
         diaFinal <- diaTemp - ((diaTemp / 7) - 1) * 7
      senao)
         diaFinal <- diaTemp - Int(diaTemp / 7) * 7
      fimse
   fimse

   escreva("Esse dia cairá ")
   escolha (diaFinal)
   caso 1
      escreval("no DOMINGO")
   caso 2
      escreval("na SEGUNDA-FEIRA")
   caso 3
      escreval("na TERÇA-FEIRA")
   caso 4
      escreval("na QUARTA-FEIRA")
   caso 5
      escreval("na QUINTA-FEIRA")
   caso 6
      escreval("na SEXTA-FEIRA")
   caso 7
      escreval("no SÁBADO")
   outrocaso
      escreval("ERRO")
   fimescolha

Fimalgoritmo