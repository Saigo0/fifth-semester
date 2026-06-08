package ex02;

import java.util.List;

public class ServicoAvaliacaoRH {
    private IAvaliacaoDesempenho avaliacaoDesempenho;

    public ServicoAvaliacaoRH(IAvaliacaoDesempenho avaliacaoDesempenho) {
		this.avaliacaoDesempenho = avaliacaoDesempenho;
	}

	public void avaliar(int funcionarioId, int nota, String comentario) {
        avaliacaoDesempenho.registrarAvaliacao(funcionarioId, nota, comentario);
    }

    public void exibirHistorico(int funcionarioId) {
        List<String> avaliacoes = avaliacaoDesempenho.listarAvaliacoes(funcionarioId);
        avaliacoes.forEach(System.out::println);
    }
}
