package ex02;

import java.util.List;

public class RelatorioMensalRH {
	private IControlePonto controlePonto;

	public RelatorioMensalRH(IControlePonto controlePonto) {

		this.controlePonto = controlePonto;
	}

	public void gerar(int funcionarioId, int mes) {
		int horas = controlePonto.calcularHorasTrabalhadas(funcionarioId, mes);
		List<String> faltas = controlePonto.listarFaltas(funcionarioId, mes);
		System.out.println("Horas: " + horas);
		faltas.forEach(System.out::println);
	}
}