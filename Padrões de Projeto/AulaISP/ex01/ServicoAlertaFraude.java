package ex01;

public class ServicoAlertaFraude {
	private IEnvioSMS envioSMS;
	private IRegistradorLog registradorLog;

	public ServicoAlertaFraude(IEnvioSMS envioSMS, IRegistradorLog registradorLog) {
		this.envioSMS = envioSMS;
		this.registradorLog = registradorLog;
	}

	public void alertar(Conta conta) {
		envioSMS.enviarSMS(conta.getTelefone(), "Atividade suspeita detectada na sua conta.");
		registradorLog.registrarLog("ALERTA_FRAUDE", "conta=" + conta.getId());
	}
}
