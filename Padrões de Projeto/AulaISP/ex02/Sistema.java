package ex02;

public class Sistema {
	
	public static void main(String[] args) {
		
		GestaoFuncionarioImpl impl = new GestaoFuncionarioImpl();
		
		ServicoFolhaPagamento folha     = new ServicoFolhaPagamento(impl);
		ServicoBonus          bonus     = new ServicoBonus(impl, impl);
		ServicoAvaliacaoRH    avaliacao = new ServicoAvaliacaoRH(impl);
		SistemaCatraca        catraca   = new SistemaCatraca(impl);
		RelatorioMensalRH     relatorio = new RelatorioMensalRH(impl);


	}
}

