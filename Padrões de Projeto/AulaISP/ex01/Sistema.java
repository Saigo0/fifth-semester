package ex01;

public class Sistema {

	public static void main(String[] args) {

		NotificadorImpl impl = new NotificadorImpl();

		ServicoConfirmacaoPedido confirmacao = new ServicoConfirmacaoPedido(impl, impl);
		ServicoAlertaFraude      fraude      = new ServicoAlertaFraude(impl, impl);
		ServicoPromocao          promocao    = new ServicoPromocao(impl);
		PainelAdmin              painel      = new PainelAdmin(impl);
	}
}
