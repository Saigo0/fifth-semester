package ex02;

public class ServicoFolhaPagamento {
    private IFolhaPagamento folhaPagamento;

    public ServicoFolhaPagamento(IFolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}

	public void processarFolha(int funcionarioId, int mes, int ano) {
        double bruto     = folhaPagamento.calcularSalarioBruto(funcionarioId);
        double descontos = folhaPagamento.calcularDescontos(funcionarioId);
        folhaPagamento.gerarContracheque(funcionarioId, mes, ano);
        folhaPagamento.pagarSalario(funcionarioId, bruto-descontos);
    }
}

