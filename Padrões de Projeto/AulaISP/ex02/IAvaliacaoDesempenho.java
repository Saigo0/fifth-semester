package ex02;

import java.util.List;

public interface IAvaliacaoDesempenho {
    void registrarAvaliacao(int funcionarioId, int nota, String comentario);

    double calcularBonus(int funcionarioId);

    List<String> listarAvaliacoes(int funcionarioId);
}
