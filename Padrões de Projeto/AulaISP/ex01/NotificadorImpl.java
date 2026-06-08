package ex01;
public class NotificadorImpl implements IEnviarWhats, IEnvioEmail, IEnvioSMS, IRegistradorLog, IMarcadorLida {

    @Override
    public void enviarEmail(String destinatario, String assunto, String corpo) {
        System.out.println("Email : " + destinatario + " | " + assunto);
    }

    @Override
    public void enviarSMS(String telefone, String mensagem) {
        System.out.println("SMS : " + telefone + " | " + mensagem);
    }

    @Override
    public void enviarWhatsApp(String telefone, String mensagem) {
        System.out.println("WhatsApp : " + telefone + " | " + mensagem);
    }

    @Override
    public void registrarLog(String evento, String detalhe) {
        System.out.println("LOG: " + evento + " | " + detalhe);
    }

    @Override
    public void marcarComoLida(int notificacaoId) {
        System.out.println("Notificação " + notificacaoId + " marcada como lida");
    }
}