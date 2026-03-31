package ex03;

public class AvaliacaoAluno {

    public double calcularMedia(Aluno aluno) {

        double media = 0.0;

        media += aluno.getProva1() * 0.4;
        media += aluno.getProva2() * 0.4;
        media += aluno.getTrabalho() * 0.2;

        if (media >= 7.0) {
            registrarAprovacao(aluno);
        }

        return media;
    }

	private void registrarAprovacao(Aluno aluno) {
		// salvar no banco
		System.out.println("Aprovado " + aluno);
		
	}
}
