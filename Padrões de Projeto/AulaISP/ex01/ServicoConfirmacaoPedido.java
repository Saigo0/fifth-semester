package ex01;

public class ServicoConfirmacaoPedido {
	private IEnvioEmail envioEmail;
	private IRegistradorLog registradorLog;

	public ServicoConfirmacaoPedido(IEnvioEmail envioEmail, IRegistradorLog registradorLog) {
		this.envioEmail = envioEmail;
		this.registradorLog = registradorLog;
	}

	public void confirmar(Pedido pedido) {
		envioEmail.enviarEmail(pedido.getEmailCliente(), "Pedido confirmado",
				"Seu pedido #" + pedido.getId() + " foi confirmado.");
		registradorLog.registrarLog("PEDIDO_CONFIRMADO", "id=" + pedido.getId());
	}
}
