Algoritmo "semnome"
Var
   nomeProd: vetor [100 .. 105] de caractere
   precProd: vetor [100 .. 105] de real
   qntProd, numCod, codEsc: inteiro

Inicio
   nomeProd[100] <- "Cachorro-quente"
   nomeProd[101] <- "Bauru simples"
   nomeProd[102] <- "Bauru com ovo"
   nomeProd[103] <- "Hamburguer"
   nomeProd[104] <- "Cheeseburguer"
   nomeProd[105] <- "Refrigerante"

   precProd[100] <- 1.7
   precProd[101] <- 2.3
   precProd[102] <- 2.6
   precProd[103] <- 2.4
   precProd[104] <- 2.5
   precProd[105] <- 1

   escreval("### CARD�PIO DISPON�VEL ###")
   numCod <- 100
   para numCod de 100 ate 105 faca
      escreval("C�d.: ", numCod, " | ", nomeProd[numCod], " | R$", precProd[numCod])
   fimpara
   escreval("")
   escreva(">> Digite o c�digo do produto: ")
   leia(codEsc)
   escreval("")
   se (codEsc < 100) ou (codEsc > 105) entao
      escreval("C�digo de produto inv�lido")
      fimalgoritmo
   senao
        escreva(">> Digite a quantidade de [", nomeProd[codEsc], "]: ")
        leia(qntProd)
        escreval("Voc� comprou ", qntProd, "x ", nomeProd[codEsc], ", e o pre�o final � R$", precProd[codEsc] * qntProd)
   fimse
Fimalgoritmo