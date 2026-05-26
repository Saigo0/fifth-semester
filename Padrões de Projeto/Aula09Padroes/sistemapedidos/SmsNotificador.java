/**
 * Notificador de SMS.
 */

public class SmsNotificador {

    public void enviarConfirmacao(String clienteId, Pedido pedido) {
        System.out.printf("[SMS] Pedido %s confirmado! Total: R$ %.2f%n",
                pedido.getId(), pedido.calcularTotal());
    }

    public void enviarCancelamento(String clienteId, Pedido pedido, String motivo) {
        System.out.printf("[SMS] Seu pedido %s foi cancelado. Motivo: %s%n",
                pedido.getId(), motivo);
    }

    public void enviarAtualizacaoEnvio(String clienteId, Pedido pedido) {
        System.out.printf("[SMS] Seu pedido %s saiu para entrega!%n", pedido.getId());
    }
}