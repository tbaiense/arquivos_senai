Algoritmo "semnome"
//7) Faça um programa que leia a idade e o sexo de 5 pessoas, mostrando no final:

//a) Quantos homens foram cadastrados

//b) Quantas mulheres foram cadastradas

//c) A média de idade do grupo

//d) A média de idade dos homens

//e) Quantas mulheres tem mais de 20 anos
Var
   sexo: caracter
   qntMaisDeVinte, numPessoa: inteiro
   qntM, qntF, idade, idadeMedM, idadeMedGrupo, idadeTotGrupo, idadeTotM: real
Inicio
   para numPessoa de 1 ate 5 faca
      escreval("### Cadastro N.", numPessoa, " ###")
      escreva("Digite seu gênero (M, F, masculino, feminino): ")
      leia(sexo)
      sexo <- Copia(Maiusc(sexo), 1, 1)
      se (sexo <> "M") e (sexo <> "F") entao
         escreval("Gênero inválido. Digite masculino ou feminino e tente novamente.")
         fimalgoritmo
      senao
         escreva("Digite sua idade: ")
         //aleatorio 10 , 60
         leia(idade)
         idade <- Int(idade)
         //aleatorio off
         se (idade <= 0) entao
            escreval("Idade inválida. Digite uma idade maior que 0.")
            fimalgoritmo
         fimse
      fimse

      idadeTotGrupo <- idadeTotGrupo + idade

      escolha (sexo)
      caso "M"
         qntM <- qntM + 1
         idadeTotM <- idadeTotM + idade
      caso "F"
         qntF <- qntF + 1
         se(Int(idade) > 20) entao
            qntMaisDeVinte <- qntMaisDeVinte + 1
         fimse
      outrocaso
         escreval("ERRO")
         fimalgoritmo
      fimescolha
      escreval("")
   fimpara

   idadeMedGrupo <- idadeTotGrupo / (qntM + qntF)
   se (qntM = 0) entao
      idadeMedM <- 0
   senao
      idadeMedM <- idadeTotM / qntM
   fimse


   escreval("")
   escreval("### ESTATÍSTICAS ###")

   escreval(">> a) Quantos homens foram cadastrados ", qntM)
   escreval(">> b) Quantas mulheres foram cadastradas: ", qntF)
   escreval(">> c) A média de idade do grupo: ", Int(idadeMedGrupo), " anos")
   escreval(">> d) A média de idade dos homens: ", Int(idadeMedM), " anos")
   escreval(">> e) Quantas mulheres tem mais de 20 anos: ", qntMaisDeVinte)

Fimalgoritmo