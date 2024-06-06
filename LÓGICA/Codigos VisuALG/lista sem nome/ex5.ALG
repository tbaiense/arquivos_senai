Algoritmo "semnome"
Var
   idade, c: inteiro
   media: real
Inicio
   para c de 1 ate 20 faca
      escreval("### ", c, "º Idade ###")
      escreva("Digite a idade: ")
      //aleatorio 0 , 100
      leia(idade)
      media <- media + idade
      escreval("")
   fimpara
   media <- media / 20
   //aleatorio off
   escreval("### MÉDIA ###")
   escreval(">> a média das idades digitadas é igual a ", media)
Fimalgoritmo