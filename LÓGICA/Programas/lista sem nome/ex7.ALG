Algoritmo "semnome"
Var
   idade, idadeAnterior, qntIdades, maior, menor: inteiro
   media: real
Inicio
   repita
      idadeAnterior <- idade
      escreval("### PESSOA Nº", qntIdades + 1, " ###")
      escreva(">> Digite a sua idade: ")
      leia(idade)
      
      se (idade <> 0) entao
         qntIdades <- qntIdades + 1
         media <- media + idade
         se (idade < menor) entao
            menor <- idade
         senao
            se (idade > maior) entao
               maior <- idade
            fimse
         fimse
      fimse
   ate (idade = 0)
   escreval("")
   media <- media / qntIdades
   
   escreval("### ESTATÍSTICA ###")
   escreval(" a) A quantidade de idades cadastradas: ", qntIdades)
   escreval(" b) A média das idades cadastradas: ", media)
   escreval(" c) A maior idade cadastrada: ", maior)
   escreval(" d) A menor idade cadastrada: ", menor)
Fimalgoritmo