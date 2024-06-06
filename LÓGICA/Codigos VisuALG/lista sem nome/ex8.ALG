Algoritmo "semnome"
// juca 1,10cm 3cm/ano
// chico 1,70 2cm/ano
// qnt anos juca > chico?
Var
crescChico, crescJuca, altChico, altJuca: real
anosPassados: inteiro
Inicio
altChico <- 1.70
altJuca <- 1.10
crescChico <- 0.02
crescJuca <- 0.03

enquanto (altJuca < altChico) faca
         altJuca <- altJuca + crescJuca
         altChico <- altChico + crescChico
         anosPassados <- anosPassados + 1
fimenquanto

escreval(">> Levou ", anosPassados, " anos para que Juca passasse da altura de Chico")
Fimalgoritmo