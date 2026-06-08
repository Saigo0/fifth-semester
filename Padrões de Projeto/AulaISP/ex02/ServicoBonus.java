package ex02;

public class ServicoBonus {
	private IControlePonto controlePonto;
	private IAvaliacaoDesempenho avaliacaoDesempenho;

	public ServicoBonus(IControlePonto controlePonto, IAvaliacaoDesempenho avaliacaoDesempenho) {
		this.controlePonto = controlePonto;
		this.avaliacaoDesempenho = avaliacaoDesempenho;
	}

	public double apurar(int funcionarioId, int mes) {
		int horas = controlePonto.calcularHorasTrabalhadas(funcionarioId, mes);
		double bonus = avaliacaoDesempenho.calcularBonus(funcionarioId);
		return horas >= 160 ? bonus : bonus * 0.5;
	}
}
