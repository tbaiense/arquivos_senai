Algoritmo "semnome"
// Disciplina  : [L�gica de Programa��o]
// Professor   : Gregory Veloso
// Descri��o   : Desenha um ret�ngulo a partir de dois valores inseridos pelo
//               usu�rio
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
 largura, altura : inteiro // definem formato do ret�ngulo

 linha, coluna : inteiro // vari�vel de controle de posi��o do cursor
 num_max_col_central : inteiro // vari�vel que define o n�mero m�x. de "_",
							  // na linha 0 e final, e " " nas linhas medianas,
							  // entre linha 1 e pen�ltima.

Inicio
 escreval("-= GERADOR DE RET�NGULO =-")

 escreval("1) Digite a seguir a largura do ret�ngulo com um n�mero natural")
 escreval("maior que zero (ex. 1; 20; ...):")
 escreva(">> Largura = ")
 leia(largura)
 escreval("")

 se (largura < 1 ) entao
    escreval("Largura inv�lida. Tente novamente com um n�mero natural maior")
    Fimalgoritmo
 fimse

 escreval("2) Agora, a altura do ret�ngulo:")
 escreva(">> Altura = ")
 leia(altura)
 escreval("")

 se (altura < 1 ) entao
    escreval("Altura inv�lida. Tente novamente com um n�mero natural maior")
    Fimalgoritmo
 fimse

// Gerar ret�ngulo
 escreval("### Exibindo um ret�ngulo com dimens�es ", largura, " x ", altura, " ###")

 num_max_col_central <- largura * 2 - 1 // Ajusta o n�mero de "_" e " " a serem inseridos na hor. para igualar a propor��o com cada unidade de altura

 // Percorrer desde a linha 0 (parte de cima, n�o contada, do ret�ngulo) at� a linha final, inclusive
 para linha de 0 ate altura faca

	 // Exibe a linha 0 do ret�ngulo
	se (linha = 0) entao
		escreva(" ")
			para coluna de 1 ate num_max_col_central faca
				escreva("_")
			fimpara
		escreval("")
	fimse

	// Exibe as linhas medianas do ret�ngulo
	se ( (altura > 1) e (linha > 0) e (linha < altura) ) entao
		escreva("|")
		para coluna de 1 ate num_max_col_central faca
			escreva(" ")
		fimpara
		escreval("|")
	fimse

	// Exibe a linha final do ret�ngulo
	se (linha = altura) entao
		escreva("|")
		para coluna de 1 ate num_max_col_central faca
			escreva("_")
		fimpara
		escreval("|")
	fimse

 fimpara

Fimalgoritmo