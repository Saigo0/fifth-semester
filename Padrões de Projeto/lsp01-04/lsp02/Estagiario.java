package lsp02;

public class Estagiario {

	private Funcionario funcionario;

	public Estagiario(double salarioBase) {
		this.funcionario = new Funcionario(Math.min(salarioBase, BOLSA_MAXIMA));
	}

	private static final double BOLSA_MAXIMA = 1500.0;

	public double calcularSalario() {
		return Math.min(funcionario.calcularSalario(), BOLSA_MAXIMA);
	}

}
