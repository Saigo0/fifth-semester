package adapter1.adapterdeobjeto;

import adapter1.americanexpress.AmericanExpress;
import adapter1.sistemavendas.Cartao;

public class AmericanExpressDeObjeto implements Cartao {

	private AmericanExpress adaptada;
	
	public AmericanExpressDeObjeto() {
		this.adaptada = new AmericanExpress();	
	}
	
	@Override
	public void pagar(String nome, String numero, double valor, String validade) throws Exception {
		
		System.out.println("Pagamento com AmericanExpress");
		this.adaptada.setNome(nome);
		this.adaptada.setNumero(numero);
		this.adaptada.setValor(valor);
		this.adaptada.setMesVencimento(Integer.parseInt(validade.split("/")[0]));
		this.adaptada.setAnoVencimento(Integer.parseInt(validade.split("/")[1]));
		
		this.adaptada.pagar();
		
	}

}
