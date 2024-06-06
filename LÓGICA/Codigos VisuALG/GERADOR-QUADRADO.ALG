Algoritmo "semnome"
// Disciplina  : [Lógica de Programação]
// Professor   : Gregory Veloso
// Descrição   : Desenha um retângulo a partir de dois valores inseridos pelo
//               usuário
//  _______ < 0
// |       |< 1   larguraDigitada = 4
// |       |< 2   larguraReal = 4 * 2 - 1 = 7
// |       |< 3
// |_______|< 4
// ^^^^^^^^^
// 012345678
//
// Autor(a)    : Thiago Moura Baiense
// Data atual  : 23/02/2024
Var
 largura, altura : inteiro // definem formato do retângulo

 linha, coluna : inteiro // variável de controle de posição do cursor
 num_max_col_central : inteiro // variável que define o número máx. de "_",
							  // na linha 0 e final, e " " nas linhas medianas,
							  // entre linha 1 e penúltima.

Inicio
 escreval("-= GERADOR DE RETÂNGULO =-")

 escreval("1) Digite a seguir a largura do retângulo com um número natural")
 escreval("maior que zero (ex. 1; 20; ...):")
 escreva(">> Largura = ")
 leia(largura)
 escreval("")

 se (largura < 1 ) entao
    escreval("Largura inválida. Tente novamente com um número natural maior")
    Fimalgoritmo
 fimse

 escreval("2) Agora, a altura do retângulo:")
 escreva(">> Altura = ")
 leia(altura)
 escreval("")

 se (altura < 1 ) entao
    escreval("Altura inválida. Tente novamente com um número natural maior")
    Fimalgoritmo
 fimse

// Gerar retângulo
 escreval("### Exibindo um retângulo com dimensões ", largura, " x ", altura, " ###")

 num_max_col_central <- largura * 2 - 1 // Ajusta o número de "_" e " " a serem inseridos na hor. para igualar a proporção com cada unidade de altura

 // Percorrer desde a linha 0 (parte de cima, não contada, do retângulo) até a linha final, inclusive
 para linha de 0 ate altura faca

	 // Exibe a linha 0 do retângulo
	se (linha = 0) entao
		escreva(" ")
			para coluna de 1 ate num_max_col_central faca
				escreva("_")
			fimpara
		escreval("")
	fimse

	// Exibe as linhas medianas do retângulo
	se ( (altura > 1) e (linha > 0) e (linha < altura) ) entao
		escreva("|")
		para coluna de 1 ate num_max_col_central faca
			escreva(" ")
		fimpara
		escreval("|")
	fimse

	// Exibe a linha final do retângulo
	se (linha = altura) entao
		escreva("|")
		para coluna de 1 ate num_max_col_central faca
			escreva("_")
		fimpara
		escreval("|")
	fimse

 fimpara

Fimalgoritmo