package adapter1.adapterdeclasse;

import adapter1.mastercard.MasterCard;
import adapter1.sistemavendas.Cartao;

public class MasterCardDeClasse extends MasterCard implements Cartao {

	@Override
	public void pagar(String nome, String numero, double valor, String validade) throws Exception {
		
		System.out.println("Pagamento com Mastercard");
		if (!super.aprovar(nome, numero, valor, validade))
			throw new Exception("Problema com seu cartao");
		
	}

}
