Algoritmo "semnome"
Var
   a, c, soma: inteiro
Inicio
   para c de 1 ate 10 faca
      escreval("### ", c, "� N�mero ###")
      escreva("Digite o n�mero para somar: ")
      //aleatorio 0 , 100
      leia(a)

      soma <- soma + a
      escreval("")
   fimpara
   //aleatorio off
   escreval("### SOMA ###")
   escreval(">> A soma dos n�meros digitados � igual a ", soma)
Fimalgoritmo