package ex02;

import java.time.LocalDateTime;

public class SistemaCatraca {
    private IControlePonto controlePonto;

    public SistemaCatraca(IControlePonto controlePonto) {
		this.controlePonto = controlePonto;
	}

	public void entrada(int funcionarioId) {
        controlePonto.registrarEntrada(funcionarioId, LocalDateTime.now());
    }

    public void saida(int funcionarioId) {
        controlePonto.registrarSaida(funcionarioId, LocalDateTime.now());
    }
}

