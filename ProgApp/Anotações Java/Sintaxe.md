## Tipos
- número decimal é `double` por natureza;
	`x = 1.2` será reconhecido por `double`, portanto deverá ser declarado de forma correspondente.
- `float`s deverão ser procedidos de "F" ou "f": `float nota = 1.2f;`;
- `045`, `0120` serão considerados octais pelo compilador (base oito);
## Operadores
- Conversão automática de tipos garante que a operação ocorra com valores de tipos diferentes
- Operações de dois tipos geram retorno do mesmo tipo. Ex. `10/3 == 3
- Módulo pode gerar números negativos se dividendo for negativo:
	`int i = -10 % 3;
	`i == -1;
- Módulo pode ser aplicado em números reais: `10.0 % 0.3 == 0.3 
- Sinal de números podem ser invertido com operador unário `-`:
	`int i = 10;
	`-i == -10;
- Concatenação de strings é possivel com qualquer tipo usando o operador `+`:
	`"Conta do cartão de crédito R$ " + 1000.32f
## Outros
- Geração de javadoc para a classe: `/** Esta classe é a classe principal do programa. */`