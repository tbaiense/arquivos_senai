programa
{
	inclua biblioteca Tipos
	
	funcao bemvindo(cadeia name)
	{
	   escreva("\n*_*_*_*_*_*_*_*_*_*_*_**_*_*_")
	   escreva("\n*_ BEM VINDO AO CINESENAI _*_")
	   escreva("\n*_*_ USUÁRIO:", name, " *_*_*_")
	   escreva("\n*_*_*_*_*_*_*_*_*_*_*_**_*_*_")
	   escreva("\n                             ")
	}
	
	funcao filmesKid()
	{
	   escreva("\n*_*_*_*_*_* KIDS *_*_*_*_**_*_*")
	   escreva("\n1- Os aventureiros - A origem")
	   escreva("\n2- Homem aranha no aranhaverso")
	}
	
	funcao filmesTeen()
	{
	   escreva("\n*_*_*_*_*_* TEENS _*_*_*_**_*_*")
	   escreva("\n3- Transformers - A origem")
	   escreva("\n4- Velozes e furiosos - 50°")
	}
	
	funcao filmesAll()
	{
	   escreva("\n*_*_*_*_*_* ALL *_*_*_*_**_*_*")
	   escreva("\n5- Sobrenatural - A origem")
	   escreva("\n6- Tropa de elite ")
	}
	
	funcao mostrarFilmes(inteiro age)
	{
	
	   se (age < 11) {
	      filmesKid()
	   } senao {
	      se (age < 18) {
	         filmesKid()
	         filmesTeen()
	      } senao {
	         filmesKid()
	         filmesTeen()
	         filmesAll()
	      }
	   }
	}

	funcao logico filmePermitido(inteiro age, inteiro escolhido)
	{
		se (age < 11 e (escolhido > 2)) {
	     	 retorne falso
		 } senao se (age < 18 e (escolhido > 4)) {
		      retorne falso
		 } senao {
		 	retorne verdadeiro
		 }
	}
	
	funcao valorIngressos()
	{
	   escreva("\nPREÇOS")
	   escreva("\nMEIA-ENTRADA: R$ 13.50")
	   escreva("\nINTEIRA: R$ 27")
	}
	
	funcao real comprar(inteiro meias, inteiro inteiras)
	{	
	   real resultado
	   resultado = (meias * 13.50) + (inteiras * 27)
	   retorne resultado
	}


	cadeia nome, filme, input
	  inteiro idade, filmeEscolhido, pedido
	  inteiro qtdMeias, qtdInteiras, numTemp
	  real valorFinal
	
	funcao inicio()
	{
	  /*
	   cadeia nome, filme, input
	  inteiro idade, filmeEscolhido, pedido
	  inteiro qtdMeias, qtdInteiras, numTemp
	  real valorFinal
	*/
		faca {
		   //Guarda o nome da pessoa e sua idade
		   escreva("\nDigite seu nome: ")
		   leia(nome)
	
		   faca {
			   escreva("\nDigite sua idade: ")
			   leia(input)
		   } enquanto (nao Tipos.cadeia_e_inteiro(input, 10))
		   idade = Tipos.cadeia_para_inteiro(input, 10)
		   limpa()

		
		   
		   //Mensagem de bem vindo
		   bemvindo(nome)
		
		   //mostrar filmes disponíveis
		   mostrarFilmes(idade)
		
		   //escolher filme
		   faca {
		      faca {
			   escreva("\nEscolha seu filme (por número): ")
			   leia(input)
			 } enquanto (nao Tipos.cadeia_e_inteiro(input, 10))
			 filmeEscolhido = Tipos.cadeia_para_inteiro(input, 10)

			se (filmePermitido(idade, filmeEscolhido))
			{
					escolha (filmeEscolhido)
				     {
					      caso 1:
					         filme = "Aventureiros"
					         pare
					      caso 2:
					         filme = "Aranha"
					         pare
					      caso 3:
					         filme = "Transformers"
					         pare
					      caso 4:
					         filme = "Velozes"
					         pare
					      caso 5:
					         filme = "Sobrenatural"
					         pare
					      caso 6:
					         filme = "Tropa"
					         pare
					      caso contrario:
					         escreva("\nfilme inválido\n")
				     }
			}
		 } enquanto ((filmeEscolhido > 7) ou (filmeEscolhido <= 0) /*ou (nao filmePermitido)*/)
		 limpa()
			}
			
			
	
		   //Comprar ingressos
		   bemvindo(nome)
		   valorIngressos()
		   
		   faca {
			   escreva("\nDigite a quantidade de meias-entradas: ")
			   leia(input)
		   } enquanto (nao Tipos.cadeia_e_inteiro(input, 10))
		   qtdMeias = Tipos.cadeia_para_inteiro(input, 10)
			  
		   faca {
		  	   escreva("\nDigite a quantidade de inteiras: ")
			   leia(input)
		   } enquanto (nao Tipos.cadeia_e_inteiro(input, 10))
		   qtdInteiras = Tipos.cadeia_para_inteiro(input, 10)
		
		   valorFinal = comprar(qtdMeias, qtdInteiras)
		
		   //Finalizar pedido
		   limpa()
		   escreva("\n----- FINALIZAR PEDIDO -----")
		   escreva("\nOLÁ ", nome)
		   escreva("\nO filme escolhido foi: '", filme, "'")
		   escreva("\nO VALOR FINAL DO SEU PEDIDO FOI DE: ")
		   escreva("\n", valorFinal)
		   escreva("\nPOR FAVOR SIGA AO CAIXA PARA FINALIZAR O PEDIDO")
		
		   //Outro pedido?
		   faca {
			   escreva("\n                             ")
			   escreva("\nDESEJA REALIZAR OUTRO PEDIDO?")
			   escreva("\n      1 - SIM , 2 - NÃO      \n")
			   leia(input)
		   } enquanto (nao Tipos.cadeia_e_inteiro(input, 10) ou Tipos.cadeia_para_inteiro(input, 10) == 0)
		   pedido = Tipos.cadeia_para_inteiro(input, 10)
		
		   
		   se (pedido == 1) {
		      limpa()
		   } senao {
		      escreva("\nBOM FILME")
		   }
		
		} enquanto (pedido != 2)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3223; 
 * @DOBRAMENTO-CODIGO = [4, 62, 69, 120, 154, 160, 178, 187];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */