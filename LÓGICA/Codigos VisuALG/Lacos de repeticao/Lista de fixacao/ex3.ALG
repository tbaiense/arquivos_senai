Algoritmo "semnome"
Var
anoAtual, anoNasc, idade: inteiro
Inicio
anoAtual <- 2024
escreva("Digite o ano do seu nascimento: ")
leia(anoNasc)
idade <- anoAtual - anoNasc

se (idade >= 16) entao
     escreval("Voc� PODE votar.")
senao
     escreval("Voc� N�O PODE votar.")
fimse
Fimalgoritmo