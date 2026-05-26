
/**
 * Notificador de e-mail.
 */
public class EmailNotificador {

    public void confirmar(String clienteId, Pedido pedido) {
        System.out.printf("[EMAIL] Confirmação de pedido %s enviada para cliente %s. Total: R$ %.2f%n",
                pedido.getId(), clienteId, pedido.calcularTotal());
    }

    public void cancelar(String clienteId, Pedido pedido, String motivo) {
        System.out.printf("[EMAIL] Cancelamento do pedido %s enviado para cliente %s. Motivo: %s%n",
                pedido.getId(), clienteId, motivo);
    }

    public void atualizarEnvio(String clienteId, Pedido pedido) {
        System.out.printf("[EMAIL] Pedido %s enviado! Notificação para cliente %s%n",
                pedido.getId(), clienteId);
    }

    public void alertarEstoque(Produto produto) {
        System.out.printf("[EMAIL] ALERTA: Estoque baixo para '%s' (restam %d unidades)%n",
                produto.getNome(), produto.getEstoque());
    }
}