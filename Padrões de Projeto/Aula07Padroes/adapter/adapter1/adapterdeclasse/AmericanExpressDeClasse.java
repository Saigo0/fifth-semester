package adapter1.adapterdeclasse;

import adapter1.americanexpress.AmericanExpress;
import adapter1.sistemavendas.Cartao;

public class AmericanExpressDeClasse extends AmericanExpress implements Cartao {

	@Override
	public void pagar(String nome, String numero, double valor, String validade) throws Exception {

		System.out.println("Pagamento com AmericanExpress");
		super.setNome(nome);
		super.setNumero(numero);
		super.setValor(valor);
		super.setMesVencimento(Integer.parseInt(validade.split("/")[0]));
		super.setAnoVencimento(Integer.parseInt(validade.split("/")[1]));
		
		super.pagar();
	}

}
