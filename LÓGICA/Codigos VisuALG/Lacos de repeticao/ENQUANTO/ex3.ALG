Algoritmo "semnome"
Var
   num, c: inteiro
Inicio
   c <- 1
   num <- 0
   escreva("Digite o n�mero positivo final: ")
   leia(num)
   repita
      se num < 1 entao
         escreval("O n�mero digitado n�o � v�lido. Digite um maior que 0.")
         escreva("Digite o n�mero positivo final: ")
         leia(num)
      fimse
   ate num > 1
   enquanto c <= num faca
      escreva(" ", c)
      c <- c + 1
   fimenquanto
   escreval(" Acabou!")
Fimalgoritmo