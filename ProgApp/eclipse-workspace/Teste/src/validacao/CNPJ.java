package validacao;

import java.util.Date;

public class CNPJ {
	public final String numerico;
	public final Date dataCriacao;
	
	CNPJ(String strCnpj) {
		this.numerico = strCnpj;
		this.dataCriacao = new Date();
	}
}
