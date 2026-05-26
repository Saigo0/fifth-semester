import java.util.List;

/**
 * Serviço principal de pedidos.
 */

public class ProcessadorPedido {

    private final RepositorioPedido repositorio;
    private final EmailNotificador emailNotificador;
    private final SmsNotificador smsNotificador;
    private final Logger logger;

    public ProcessadorPedido() {
    	repositorio = new RepositorioPedidoEmMemoria();
    	emailNotificador = new EmailNotificador();
    	smsNotificador = new SmsNotificador();
    	logger = new Logger("ProcessadorPedido");
	}
    
    public Pedido confirmarPedido(String clienteId, List<ItemPedido> itens, String endereco) {
        logger.info("Iniciando confirmação de pedido para cliente: " + clienteId);
        long inicio = System.currentTimeMillis();

        validarEstoque(itens);

        String id = "PED-" + System.currentTimeMillis();
        Pedido pedido = new Pedido(id, clienteId, itens, endereco);
        pedido.setStatus(Pedido.Status.CONFIRMADO);

        baixarEstoque(itens);
        repositorio.salvar(pedido);

        emailNotificador.confirmar(clienteId, pedido);
        smsNotificador.enviarConfirmacao(clienteId, pedido);

        long duracao = System.currentTimeMillis() - inicio;
        logger.info("Pedido confirmado: " + id + " | duração: " + duracao + "ms");

        return pedido;
    }

    public void cancelarPedido(String pedidoId, String motivo) {
        logger.info("Iniciando cancelamento do pedido: " + pedidoId);
        long inicio = System.currentTimeMillis();

        Pedido pedido = repositorio.buscarPorId(pedidoId);
        if (pedido == null) {
            logger.error("Pedido não encontrado: " + pedidoId);
            throw new IllegalArgumentException("Pedido não encontrado: " + pedidoId);
        }

        if (pedido.getStatus() == Pedido.Status.ENVIADO || pedido.getStatus() == Pedido.Status.ENTREGUE) {
            logger.error("Cancelamento inválido para status: " + pedido.getStatus());
            throw new IllegalStateException("Não é possível cancelar pedido com status: " + pedido.getStatus());
        }

        pedido.setStatus(Pedido.Status.CANCELADO);
        restaurarEstoque(pedido.getItens());
        repositorio.atualizar(pedido);

        emailNotificador.cancelar(pedido.getClienteId(), pedido, motivo);
        smsNotificador.enviarCancelamento(pedido.getClienteId(), pedido, motivo);

        long duracao = System.currentTimeMillis() - inicio;
        logger.info("Pedido cancelado: " + pedidoId + " | duração: " + duracao + "ms");
    }

    public void atualizarStatusEnvio(String pedidoId, Pedido.Status novoStatus) {
        logger.info("Atualizando status do pedido: " + pedidoId + " → " + novoStatus);
        long inicio = System.currentTimeMillis();

        Pedido pedido = repositorio.buscarPorId(pedidoId);
        if (pedido == null) {
            logger.error("Pedido não encontrado: " + pedidoId);
            throw new IllegalArgumentException("Pedido não encontrado: " + pedidoId);
        }

        pedido.setStatus(novoStatus);
        repositorio.atualizar(pedido);

        if (novoStatus == Pedido.Status.ENVIADO) {
            emailNotificador.atualizarEnvio(pedido.getClienteId(), pedido);
            smsNotificador.enviarAtualizacaoEnvio(pedido.getClienteId(), pedido);
        }

        long duracao = System.currentTimeMillis() - inicio;
        logger.info("Status atualizado: " + pedidoId + " | duração: " + duracao + "ms");
    }

    // --- métodos auxiliares ---

    private void validarEstoque(List<ItemPedido> itens) {
        for (ItemPedido item : itens) {
            if (item.getProduto().getEstoque() < item.getQuantidade()) {
                throw new IllegalStateException(
                        "Estoque insuficiente para: " + item.getProduto().getNome());
            }
        }
    }

    private void baixarEstoque(List<ItemPedido> itens) {
        for (ItemPedido item : itens) {
            int novoEstoque = item.getProduto().getEstoque() - item.getQuantidade();
            item.getProduto().setEstoque(novoEstoque);
        }
    }

    private void restaurarEstoque(List<ItemPedido> itens) {
        for (ItemPedido item : itens) {
            int novoEstoque = item.getProduto().getEstoque() + item.getQuantidade();
            item.getProduto().setEstoque(novoEstoque);
        }
    }
}