package ex02;

import java.time.LocalDateTime;
import java.util.List;

public class GestaoFuncionarioImpl implements IAvaliacaoDesempenho, IControlePonto, IFolhaPagamento {

	@Override
	public double calcularSalarioBruto(int funcionarioId) {
		return 5000.0;
	}

	@Override
	public double calcularDescontos(int funcionarioId) {
		return 800.0;
	}

	@Override
	public void gerarContracheque(int funcionarioId, int mes, int ano) {
		System.out.println("Contracheque gerado: func=" + funcionarioId);
	}

	@Override
	public void pagarSalario(int funcionarioId, double salario) {
		System.out.println("Salário pago: func=" + funcionarioId + " R$ " + String.format("%.2f", salario));
	}

	@Override
	public void registrarAvaliacao(int funcionarioId, int nota, String comentario) {
		System.out.println("Avaliação registrada: " + nota);
	}

	@Override
	public double calcularBonus(int funcionarioId) {
		return 1200.0;
	}

	@Override
	public List<String> listarAvaliacoes(int funcionarioId) {
		return List.of("Nota 8 - bom desempenho", "Nota 9 - excelente");
	}

	@Override
	public void registrarEntrada(int funcionarioId, LocalDateTime horario) {
		System.out.println("Entrada: " + horario);
	}

	@Override
	public void registrarSaida(int funcionarioId, LocalDateTime horario) {
		System.out.println("Saída: " + horario);
	}

	@Override
	public int calcularHorasTrabalhadas(int funcionarioId, int mes) {
		return 168;
	}

	@Override
	public List<String> listarFaltas(int funcionarioId, int mes) {
		return List.of("05/03 - falta injustificada");
	}
}
