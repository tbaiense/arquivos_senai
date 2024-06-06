Algoritmo "semnome"
Var
   num, c: inteiro
Inicio
   repita
      escreva("Digite o número final: ")
      leia(num)
      SE num <> 1111 entao
         enquanto c <= num faca
            escreva(" ", c)
            c <- c + 1
         fimenquanto
         escreval(" Acabou!")
      fimse
   ate num = 1111
Fimalgoritmo