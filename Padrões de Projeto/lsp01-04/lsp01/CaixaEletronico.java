package lsp01;

public class CaixaEletronico {

	public static void main(String[] args) {

		ContaCorrente cc1 = new ContaCorrente();
		cc1.depositar(1000);
		
		ContaInvestimento ci1 = new ContaInvestimento();
		ci1.depositar(5000);
	
		transferirComTaxa(ci1, cc1, 5000);
		
	}

	private static void transferirComTaxa(SaqueComTaxa ci1, Deposito d, double valor) {
		ci1.sacarComTaxa(valor);
		d.depositar(valor);
	}

	private static void transferirSemTaxa(SaqueSemTaxa cc1, Deposito d, double valor){
		cc1.sacarSemTaxa(valor);
		d.depositar(valor);
	}

	
	
}
