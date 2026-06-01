package lsp01;
public class ContaInvestimento implements SaqueComTaxa, Deposito{
	private double taxaManutencao = 10.0;
	private ContaBancaria contaBancaria;

	ContaInvestimento(){
		contaBancaria = new ContaBancaria();
	}

	public void sacar(double valor) {
		sacarComTaxa(valor);
	}
	
	public void reinvestir() {
		contaBancaria.saldo = contaBancaria.getSaldo() * 1.05;
	}

	@Override
	public void depositar(double valor) {
		contaBancaria.depositar(valor);
	}

	public double getSaldo() {
		return contaBancaria.getSaldo();
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	@Override
	public void sacarComTaxa(double valor) {
		if (valor + taxaManutencao <= contaBancaria.getSaldo()) {
			contaBancaria.sacar(valor + taxaManutencao);
		} else {
			throw new RuntimeException("Saldo insuficiente");
		}
	}
}