Algoritmo "semnome"
//5) Crie um programa que leia sexo e peso de 8 pessoas, usando a estrutura
//�para�. No final, mostre na tela:

//       a) Quantas mulheres foram cadastradas
//       b) Quantos homens pesam mais de 100Kg
//       c) A m�dia de peso entre as mulheres
//       d) O maior peso entre os homens
Var
   sexo: caracter
   peso, pesoTotalFTemp, pesoMedF, maiorPesoM, pesoMTemp, qntF: real
   numPessoa, qntPessoas, qntPesoCemM: inteiro
Inicio
   qntF <- 0
   pesoMTemp <- 0
   pesoTotalFTemp <- 0
   qntPesoCemM <- 0

   para numPessoa de 1 ate 8 faca
        escreval("### Cadastro N.", numPessoa, " ###")
      escreva("Digite seu g�nero (M, F, masculino, feminino): ")
      leia(sexo)
      sexo <- Copia(Maiusc(sexo), 1, 1)
      se (sexo <> "M") e (sexo <> "F") entao
         escreval("G�nero inv�lido. Digite masculino ou feminino e tente novamente.")
         //fimalgoritmo
      senao
         escreva("Digite seu peso em KG: ")
         aleatorio 40 , 120
         leia(peso)
         aleatorio off
         se (peso <= 0) entao
            escreval("Peso inv�lido. Digite um peso maior que 0.")
            fimalgoritmo
         fimse
      fimse

      escolha (sexo)
      caso "M"
         se (peso > pesoMTemp) entao // Armazena os maiores valores de pesoM
            pesoMTemp <- peso
         fimse
         se(peso > 100) entao
            qntPesoCemM <- qntPesoCemM + 1
         fimse
      caso "F"
         qntF <- qntF + 1
         pesoTotalFTemp <- pesoTotalFTemp + peso
      outrocaso
         escreval("ERRO")
         fimalgoritmo
      fimescolha
      escreval("")
   fimpara
   maiorPesoM <- pesoMTemp
   pesoMedF <- (pesoTotalFTemp) / qntF
       escreval("")
       escreval("### ESTAT�STICAS ###")
       
       escreval(">> a) N�mero de mulheres cadastradas: ", qntF)
       escreval(">> b) N�mero de homens com peso maior que 100KG: ",qntPesoCemM)
       escreval(">> c) A m�dia de peso entre as mulheres: ", PesoMedF, "KG")
       escreval(">> d) O maior peso entre os homens: ", maiorPesoM, "KG")

Fimalgoritmo