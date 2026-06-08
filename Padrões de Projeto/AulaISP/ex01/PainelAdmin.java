package ex01;

public class PainelAdmin {
	private IMarcadorLida marcadorLida;

	public PainelAdmin(IMarcadorLida marcadorLida) {
		this.marcadorLida = marcadorLida;
	}

	public void marcarLida(int notificacaoId) {
		marcadorLida.marcarComoLida(notificacaoId);
	}
}