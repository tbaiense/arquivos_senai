Algoritmo "semnome"
Var
   num, c: inteiro
Inicio
   repita
      c <- 0
      escreva("Digite o número final: ")
      leia(num)
      se num <> 1111 entao
         repita
            escreva(" ", c)
            c <- c + 1
         ate c > num
         escreval(" Acabou!")
      fimse
      escreval("------------")
   ate num = 1111

Fimalgoritmo