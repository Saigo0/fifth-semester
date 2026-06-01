package lsp02;

public class FolhaPagamento {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario(3000);
		Estagiario e2 = new Estagiario(1500);
		
		registrarFaltas(f1, 5);
		System.out.println(f1.calcularSalario());

		System.out.println(e2.calcularSalario());
		
	}

	private static void registrarFaltas(Funcionario f, int dias) {
		
		f.registrarFaltas(dias);
		
	}

}
