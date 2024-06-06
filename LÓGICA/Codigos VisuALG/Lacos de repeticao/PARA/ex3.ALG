Algoritmo "semnome"
//3) Faça um programa usando a estrutura “para” que leia um número inteiro
//positivo e mostre na tela uma contagem de 0 até o valor digitado:

//      Ex: Digite um valor: 9

//       Contagem: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, FIM!
Var
x, y: inteiro
Inicio
escreva("Digite um valor: ")
leia(y)
y <- Abs(y)
para x de 0 ate y passo 1 faca
     escreva(" ", x)
fimpara
escreval(" FIM!")
Fimalgoritmo