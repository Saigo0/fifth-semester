package adapter1.adapterdeclasse;

import adapter1.sistemavendas.Cartao;
import adapter1.visa.Visa;

public class VisaDeClasse extends Visa implements Cartao {

	@Override
	public void pagar(String nome, String numero, double valor, String validade) throws Exception {

		System.out.println("Pagamento com Visa");
		if (!super.verificar(nome, numero, valor, Integer.parseInt(validade.split("/")[0]), Integer.parseInt(validade.split("/")[1])))
				throw new Exception("Problema com seu cartao");
		
	}

}
