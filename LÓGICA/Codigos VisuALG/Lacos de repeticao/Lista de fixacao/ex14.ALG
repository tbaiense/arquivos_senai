Algoritmo "semnome"
Var
   idadeUm, idadeDois : inteiro
   total : real
Inicio
// ###########################################
funcao totalIngressos(i,j: inteiro):real
var
   c: inteiro
   idades: vetor [1..2] de inteiro
   preco, totalTemp: real
inicio
   idades[1] <- i
   idades[2] <- j
   
   para c de 1 ate 2 faca
      se (idades[c] <= 17) entao
         preco <- 15
      senao
         se (idades[c] <= 59) entao
            preco <- 30
         senao // idade 60 ou maior
            preco <- 20
         fimse
      fimse

      totalTemp <- totalTemp + preco
   fimpara
   
   retorne (totalTemp)
fimfuncao
// -----------------------------------------

escreva("Digite a idade da primeira: ")
leia(idadeUm)
escreva("Digite a idade da segunda: ")
leia(idadeDois)

total <- totalIngressos(idadeUm, idadeDois)
escreval("O total é de R$", total)
Fimalgoritmo