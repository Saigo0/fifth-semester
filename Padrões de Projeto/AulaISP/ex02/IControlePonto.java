package ex02;

import java.time.LocalDateTime;
import java.util.List;

public interface IControlePonto {
    void registrarEntrada(int funcionarioId, LocalDateTime horario);

    void registrarSaida(int funcionarioId, LocalDateTime horario);

    int calcularHorasTrabalhadas(int funcionarioId, int mes);

    List<String> listarFaltas(int funcionarioId, int mes);
}
