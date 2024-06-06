Algoritmo "semnome"
Var
   entrada_inicio, entrada_final, entrada_incremento: inteiro
   msg_erro: caractere
Inicio
   msg_erro <- "Incremento inválido. Tente novamente."
procedimento Contador(i, j, k: inteiro)
inicio
   para i de i ate j passo k faca
      escreva(i, " >> ")
   fimpara
   escreval("FIM")
fimprocedimento

escreva("Digite o número inicial: ")
leia(entrada_inicio)
escreva("Digite o número final: ")
leia(entrada_final)

repita //Garante a entrada de um incremento correto
   escreva("Digite o incremento da contagem: ")
   leia(entrada_incremento)
   se (entrada_incremento = 0) entao
      escreval(msg_erro)
   senao
      se ((entrada_inicio < entrada_final) e (entrada_incremento < 0)) entao
         escreval(msg_erro)
         entrada_incremento <- 0
      senao
         se ((entrada_inicio > entrada_final) e (entrada_incremento > 0)) entao
            escreval(msg_erro)
            entrada_incremento <- 0
         fimse
      fimse
   fimse
ate (entrada_incremento <> 0)

Contador(entrada_inicio, entrada_final, entrada_incremento)
Fimalgoritmo