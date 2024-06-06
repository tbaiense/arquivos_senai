Algoritmo "semnome"
Var
Inicio
procedimento Gerador(texto: caractere; i, j: inteiro)
var
   comp_visual, bordaUm, bordaDois, bordaTres: caractere
inicio
   bordaUm <- "+-------=======------+"
   bordaDois <- "~~~~~~~~:::::::~~~~~~~"
   bordaTres <- "<<<<<<<<------->>>>>>>"
   escolha (j)
   caso 1
      comp_visual <- bordaUm
   caso 2
      comp_visual <- bordaDois
   caso 3
      comp_visual <- bordaTres
   outrocaso
      escreval("BORDA INVÁLIDA. Escolhendo a Borda 1...")
      comp_visual <- bordaUm
   fimescolha
   escreval(comp_visual)
   para i de 1 ate i faca
      escreval(texto)
   fimpara
   escreval(comp_visual)
fimprocedimento

Gerador("Portugol", 6, 1)
Fimalgoritmo