Algoritmo "operadores"
Var
a, c : real // valor e parcelas, respectivamente
b : inteiro // parcela

Inicio
escreva("Qual o valor do empréstimo? (ex. R$1000.00): R$")
leia(a)
a <- a * 1.2
escreval("")
escreva("Quantas parcelas?: ")
leia(b)
c <- a / b
escreval("")
escreval("Você deverá pagar ", b," parcelas de ", c," reais")
Fimalgoritmo