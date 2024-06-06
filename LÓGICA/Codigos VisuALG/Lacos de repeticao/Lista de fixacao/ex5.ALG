Algoritmo "semnome"
Var
   numUm, numDois: inteiro
Inicio
   escreva("Digite um número: ")
   leia(numUm)
   escreva("Digite outro número: ")
   leia(numDois)

   se (numUm = numDois) entao
      escreval("Não existe valor maior, os dois são iguais")
   senao
      se (numUm > numDois) entao
         escreval("O primeiro valor é o maior")
      senao
         se (numDois > numUm) entao
            escreval("O segundo valor é o maior")
         fimse
      fimse
   fimse
Fimalgoritmo