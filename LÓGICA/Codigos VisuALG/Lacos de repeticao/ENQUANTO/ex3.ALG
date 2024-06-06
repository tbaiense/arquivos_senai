Algoritmo "semnome"
Var
   num, c: inteiro
Inicio
   c <- 1
   num <- 0
   escreva("Digite o número positivo final: ")
   leia(num)
   repita
      se num < 1 entao
         escreval("O número digitado não é válido. Digite um maior que 0.")
         escreva("Digite o número positivo final: ")
         leia(num)
      fimse
   ate num > 1
   enquanto c <= num faca
      escreva(" ", c)
      c <- c + 1
   fimenquanto
   escreval(" Acabou!")
Fimalgoritmo