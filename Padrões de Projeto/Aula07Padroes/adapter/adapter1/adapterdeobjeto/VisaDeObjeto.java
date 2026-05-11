package adapter1.adapterdeobjeto;

import adapter1.sistemavendas.Cartao;
import adapter1.visa.Visa;

public class VisaDeObjeto implements Cartao {

	private Visa adaptada;
	
	public VisaDeObjeto() {
		this.adaptada = new Visa();
	}
	
	@Override
	public void pagar(String nome, String numero, double valor, String validade) throws Exception {
		
		System.out.println("Pagamento com Visa");
		if (!this.adaptada.verificar(nome, numero, valor, Integer.parseInt(validade.split("/")[0]), Integer.parseInt(validade.split("/")[1])))
				throw new Exception("Problema com seu cartao");
		

	}

}
