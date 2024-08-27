Scanner console = new Scanner(System.in);
		final short LINHAS = 5;
		final short COLUNAS = 5;
		final short MAX = 100;
		int[][] cartela = new int[LINHAS][COLUNAS];

		int[] numerosCartela = new int[LINHAS * COLUNAS];
		if (MAX < numerosCartela.length) {
			System.out.print("ERRO: Número de números aleatórios inferior ao tamanho da cartela. Aumente a faixa de valores a serem gerados.");
			System.exit(1);
		}

		// Geração dos números
		numerosCartela[0] = (short)(Math.random()*MAX + 1);
		for (int i = 1; i < numerosCartela.length;) {
			short aleatorio = (short)(Math.random()*MAX + 1);
			boolean repetido = false;
			for (int verificado = i-1; verificado >= 0; --verificado) {
				if (numerosCartela[verificado] == aleatorio) {
					repetido = true;
					break;
				}
			}
			if (!repetido) {
				numerosCartela[i] = aleatorio;
				++i;
			}
		}

		for (int i=0; i < numerosCartela.length; ++i)
			System.out.print(numerosCartela[i] + " - ");

		System.out.print("\n\n");

		for(int lin = 0, i = 0; lin < LINHAS; ++lin) {
			for(int col = 0; col < COLUNAS; ++col) {
				System.out.printf("%3d  ", (cartela[lin][col] = numerosCartela[i++]));
			}
			System.out.print('\n');
		}
