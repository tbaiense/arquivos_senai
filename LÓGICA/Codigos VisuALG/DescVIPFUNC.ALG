algoritmo "semnome"
var
   id: inteiro
   total: real
inicio
   escreva("Digite o valor total da compra (ex: 100.50): R$")
   leia(total)
   escreval("Agora, digite seu código de indentificação: ")
   escreval("1 Cliente")
   escreval("2 Funcionário")
   escreval("3 VIP")
   escreva(">> Cód.: ")
   leia(id)

   escolha (id)
   caso 2
      total <- total * 0.9
   caso 3
      total <- total * 0.95
   caso 1
   outrocaso
      escreval("Código de identificação inválido")
fimalgoritmo
fimescolha

escreval("TOTAL c/desc.: R$", total)
fimalgoritmo