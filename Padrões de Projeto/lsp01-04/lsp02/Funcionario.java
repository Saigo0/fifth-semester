package lsp02;

public class Funcionario {

	protected double salarioBase;
	private double diasFaltou;
	
	public Funcionario(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double calcularSalario() {
		double desconto = (salarioBase / 30) * diasFaltou;
		return salarioBase - desconto;
	}

	public void registrarFaltas(int dias) {
		diasFaltou += dias;
	}

}
