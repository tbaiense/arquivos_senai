algoritmo "semnome"
var
   id: inteiro
   total: real
inicio
   escreva("Digite o valor total da compra (ex: 100.50): R$")
   leia(total)
   escreval("Agora, digite seu c�digo de indentifica��o: ")
   escreval("1 Cliente")
   escreval("2 Funcion�rio")
   escreval("3 VIP")
   escreva(">> C�d.: ")
   leia(id)

   escolha (id)
   caso 2
      total <- total * 0.9
   caso 3
      total <- total * 0.95
   caso 1
   outrocaso
      escreval("C�digo de identifica��o inv�lido")
fimalgoritmo
fimescolha

escreval("TOTAL c/desc.: R$", total)
fimalgoritmo