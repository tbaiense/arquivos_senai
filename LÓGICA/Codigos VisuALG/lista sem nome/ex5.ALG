Algoritmo "semnome"
Var
   idade, c: inteiro
   media: real
Inicio
   para c de 1 ate 20 faca
      escreval("### ", c, "� Idade ###")
      escreva("Digite a idade: ")
      //aleatorio 0 , 100
      leia(idade)
      media <- media + idade
      escreval("")
   fimpara
   media <- media / 20
   //aleatorio off
   escreval("### M�DIA ###")
   escreval(">> a m�dia das idades digitadas � igual a ", media)
Fimalgoritmo