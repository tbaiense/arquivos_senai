Algoritmo "semnome"
//7) Crie um algoritmo que leia o valor inicial da contagem, o valor final
// e o incremento, mostrando em seguida todos os valores no intervalo:

//       Ex: Digite o primeiro Valor: 3

//       Digite o último Valor: 10

//       Digite o incremento: 2

//       Contagem: 3 5 7 9 Acabou!
Var
primValor, ultValor, inc, i: inteiro
Inicio

escreva("Digite o primeiro Valor: ")
leia(primValor)
escreva("Digite o último Valor: ")
leia(ultValor)
escreva("Digite o incremento: ")
leia(inc)

escreva("Contagem:")
para i de primValor ate ultValor passo inc faca
     escreva(" ", i)
fimpara

escreval(" Acabou!")
Fimalgoritmo