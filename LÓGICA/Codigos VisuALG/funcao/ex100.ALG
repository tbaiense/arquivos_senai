Algoritmo "semnome"
Var
   notaUm, notaDois, media: real
Inicio
   // FUNÇÕES ---------------------------------
funcao MostrarMed(i, j: inteiro):real
inicio
      media <- ((i+j)/2)
   retorne media
fimfuncao

funcao Situacao(i: real): caractere
inicio
   se (i >= 70) entao
      retorne "APROVADO"
   senao
      se (i >= 40) entao
        retorne "RECUPERAÇÃO"
      senao
         retorne "REPROVADO"
      fimse
   fimse
fimfuncao
// -----------------------------------------
escreva("Digite a primeira nota do aluno: ")
leia(notaUm)
escreva("Digite a segunda nota do aluno: ")
leia(notaDois)
escreval("O aluno se encontra ", Situacao(MostrarMed(notaUm, notaDois)),", com média", media, ".")
Fimalgoritmo