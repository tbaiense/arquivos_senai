Algoritmo "semnome"
Var
   a, c, soma: inteiro
Inicio
   para c de 1 ate 10 faca
      escreval("### ", c, "º Número ###")
      escreva("Digite o número para somar: ")
      //aleatorio 0 , 100
      leia(a)

      soma <- soma + a
      escreval("")
   fimpara
   //aleatorio off
   escreval("### SOMA ###")
   escreval(">> A soma dos números digitados é igual a ", soma)
Fimalgoritmo