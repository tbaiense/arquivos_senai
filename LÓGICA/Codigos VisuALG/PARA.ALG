Algoritmo "semnome"
Var
   num, c: inteiro
Inicio

   repita
      escreva("Digite o n�mero final: ")
      leia(num)
      se num <> 1111 entao
         para c de 0 ate num faca
            escreva(" ", c)
         fimpara
         escreval(" Acabou!")
      fimse
   ate num = 1111
Fimalgoritmo