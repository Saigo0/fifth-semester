package ex03;

public class Aluno {

	private double prova1, prova2, trabalho;

	public Aluno(double prova1, double prova2, double trabalho) {
		this.prova1 = prova1;
		this.prova2 = prova2;
		this.trabalho = trabalho;
	}

	public double getProva1() {
		return prova1;
	}

	public double getProva2() {
		return prova2;
	}

	public double getTrabalho() {
		return trabalho;
	}
	
}
