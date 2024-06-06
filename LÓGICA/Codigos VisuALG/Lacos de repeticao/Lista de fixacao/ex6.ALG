Algoritmo "semnome"
Var
   notaUm, notaDois, media: real
Inicio
   escreva("Digite a nota um: ")
   leia(notaUm)
   escreva("Digite a nota dois: ")
   leia(notaDois)
   media <- (notaUm + notaDois) / 2

   se (media < 5) entao
      escreval("REPROVADO")
   senao
      se (media < 7) entao
         escreval("RECUPERAÇÃO")
      senao
         escreval("APROVADO")
      fimse
   fimse
Fimalgoritmo