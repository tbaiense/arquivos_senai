Algoritmo "semnome"
Var
   numUm, numDois: inteiro
Inicio
   escreva("Digite um n�mero: ")
   leia(numUm)
   escreva("Digite outro n�mero: ")
   leia(numDois)

   se (numUm = numDois) entao
      escreval("N�o existe valor maior, os dois s�o iguais")
   senao
      se (numUm > numDois) entao
         escreval("O primeiro valor � o maior")
      senao
         se (numDois > numUm) entao
            escreval("O segundo valor � o maior")
         fimse
      fimse
   fimse
Fimalgoritmo