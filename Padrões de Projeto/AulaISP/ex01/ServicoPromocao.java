package ex01;

public class ServicoPromocao {
	private IEnviarWhats enviarWhatsApp;

	public ServicoPromocao(IEnviarWhats enviarWhatsApp) {
		this.enviarWhatsApp = enviarWhatsApp;
	}

	public void disparar(String telefone, String oferta) {
		enviarWhatsApp.enviarWhatsApp(telefone, oferta);
	}
}
